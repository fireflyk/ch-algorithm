package me;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hello2 {

    record Request(long timestamp, String ip, String host) {

    }

    record PerIpPerHostRule(int maxRequests, int timeInterval) {

    }

    record PerIpRule(int maxRequests, int timeInterval) {

    }

    private static class SlidingWindowLimiter {

        private Map<String, Deque<Request>> windows;

        private PerIpRule perIpRule;

        public SlidingWindowLimiter(
            Map<String, Deque<Request>> windows,
            PerIpRule perIpRule) {
            this.windows = windows;
            this.perIpRule = perIpRule;
        }

        public boolean handle(Request request) {
            windows.putIfAbsent(request.ip(), new LinkedList<>());
            final Deque<Request> window = windows.get(request.ip());
            cleanRequestsBeforeTheInterval(window, request.timestamp());
            if (window.size() < perIpRule.maxRequests()) {
                window.add(request);
                return true;
            } else {
                return false;
            }

        }

        private void cleanRequestsBeforeTheInterval(Deque<Request> window, long timestamp) {
            long cutoff = timestamp - perIpRule.timeInterval();
            while (!window.isEmpty() && window.peekFirst().timestamp() < cutoff) {
                window.removeFirst();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final Path path = Path.of("/Users/tong/my-wp/ch-algorithm/java/src/main/java/me/requests.csv");

        final List<Request> requests = loadRequests(path);

        final SlidingWindowLimiter slidingWindowLimiter = new SlidingWindowLimiter(
            new HashMap<>(), new PerIpRule(1, 60));
        for (Request request : requests) {
            System.out.print(request);
            System.out.print(" . ");
            System.out.println(slidingWindowLimiter.handle(request));
        }
    }

    static List<Request> loadRequests(Path path) throws IOException {
        return Files.readAllLines(path)
            .stream()
            .skip(1)
            .filter(line -> !line.isBlank())
            .map(Hello2::parseRequest)
            .toList();
    }

    static Request parseRequest(String line) {
        String[] parts = line.split(",", -1);

        long timestamp = OffsetDateTime
            .parse(parts[0])
            .toInstant()
            .getEpochSecond();

        return new Request(timestamp, parts[1], parts[2]);
    }

    static long countBlocked(
        List<Request> requests,
        int ipReqMax,
        Integer ipHostReqMax,
        long windowSeconds
    ) {
        Map<String, Deque<Long>> ipWindows = new HashMap<>();
        Map<String, Deque<Long>> ipHostWindows = new HashMap<>();

        long blocked = 0;

        for (Request r : requests) {
            Deque<Long> ipWindow =
                ipWindows.computeIfAbsent(r.ip(), k -> new ArrayDeque<>());

            evictOld(ipWindow, r.timestamp(), windowSeconds);

            boolean blockedByIp = ipWindow.size() >= ipReqMax;
            boolean blockedByIpHost = false;

            Deque<Long> ipHostWindow = null;

            if (ipHostReqMax != null) {
                String ipHostKey = r.ip() + "|" + r.host();

                ipHostWindow =
                    ipHostWindows.computeIfAbsent(ipHostKey, k -> new ArrayDeque<>());

                evictOld(ipHostWindow, r.timestamp(), windowSeconds);

                blockedByIpHost = ipHostWindow.size() >= ipHostReqMax;
            }

            if (blockedByIp || blockedByIpHost) {
                blocked++;
            }

            ipWindow.addLast(r.timestamp());

            if (ipHostWindow != null) {
                ipHostWindow.addLast(r.timestamp());
            }
        }

        return blocked;
    }

    static void evictOld(
        Deque<Long> window,
        long currentTimestamp,
        long windowSeconds
    ) {
        long cutoff = currentTimestamp - windowSeconds;

        while (!window.isEmpty() && window.peekFirst() <= cutoff) {
            window.removeFirst();
        }
    }
}