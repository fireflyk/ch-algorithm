package com.codinghero.interview.openai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageSystem {

    private List<String> messages;

    private List<Bot> bots;

    private static List<Bot> defaultBots() {
        final AwayBot awayBot = new AwayBot();
        return Arrays.asList(new MeetBot(awayBot), new GiveTacoBot(), awayBot);
    }

    public List<String> getMessages() {
        return messages;
    }

    public MessageSystem() {
        this(new ArrayList<>(), defaultBots());
    }

    public MessageSystem(
        final List<String> messages,
        final List<Bot> bots) {
        this.messages = messages;
        this.bots = bots;
    }

    public void sendMessage(String name, String msg) {
        messages.add(name + ": " + msg);

        bots.forEach(bot -> messages.addAll(bot.preProcess(name, msg).messages()));
        bots.stream().filter(bot -> bot.canProcess(name, msg))
            .forEach(bot -> messages.addAll(bot.process(name, msg).messages()));
    }

    record PreProcessResponse(List<String> messages) {

    }

    record ProcessResponse(List<String> messages) {

    }

    interface Bot {

        default PreProcessResponse preProcess(String name, String msg) {
            return new PreProcessResponse(List.of(msg));
        }

        boolean canProcess(String name, String msg);
        ProcessResponse process(String name, String msg);
    }

    private static class MeetBot implements Bot {

        private final AwayBot awayBot;

        public MeetBot(AwayBot awayBot) {
            this.awayBot = awayBot;
        }

        @Override
        public boolean canProcess(String name, String msg) {
            return msg.length() >= 5 && msg.substring(1, 5).equals("meet");
        }

        @Override
        public ProcessResponse process(String name, String msg) {
            awayBot.addAway(name, "@" + name + " may be in a meeting right now");
            awayBot.addAway(msg.substring(7),
                "@" + msg.substring(7) + " may be in a meeting right now");
            return new ProcessResponse(List.of(
                "MeetBot: Google Meet with @"
                    + name
                    + ", and "
                    + msg.substring(6)
                    + " starting at https://meet.google.com/abc-def-123"
            ));
        }
    }

    private static class GiveTacoBot implements Bot {

        private Map<String, Integer> tacos = new HashMap<>();

        @Override
        public boolean canProcess(String name, String msg) {
            return msg.length() >= 9 && msg.substring(1, 9).equals("givetaco");
        }

        @Override
        public ProcessResponse process(String name, String msg) {
            String[] parts = msg.split(" ");
            int numTacos = parts[1].length();
            String who = parts[2];
            String whoName = who.substring(1);

            if (!tacos.containsKey(whoName)) {
                tacos.put(whoName, 0);
            }
            tacos.put(whoName, tacos.get(whoName) + numTacos);

            return new ProcessResponse(List.of(
                "TacoBot: @"
                    + name
                    + " gave @"
                    + who
                    + " "
                    + numTacos
                    + " 🌮's. "
                    + who
                    + " now have " + tacos.get(whoName) + " 🌮s."
            ));
        }
    }

    private static class AwayBot implements Bot {

        private Map<String, String> aways = new HashMap<>();

        public void addAway(String name, String msg) {
            aways.put(name, msg);
        }

        @Override
        public PreProcessResponse preProcess(String name, String msg) {
            final List<String> messages = aways.entrySet().stream()
                .filter(entry -> msg.contains(entry.getKey()))
                .map(entry -> "AwayBot: " + entry.getKey() + " is away: " + entry.getValue())
                .toList();
            return new PreProcessResponse(messages);
        }

        @Override
        public boolean canProcess(String name, String msg) {
            return msg.length() >= 5 && msg.substring(1, 5).equals("away");
        }

        @Override
        public ProcessResponse process(String name, String msg) {
            aways.put(name, msg.substring(6));
            return new ProcessResponse(List.of(msg));
        }
    }

    public static void main(String[] args) {
        MessageSystem messageSystem = new MessageSystem();
        messageSystem.sendMessage("Alice", "Hello");
        messageSystem.sendMessage("Bob", "Hi");
        messageSystem.sendMessage("Alice", "Nice job on your presentations");
        messageSystem.sendMessage("Cindy", "/givetaco 🌮🌮 @justin");
        messageSystem.sendMessage("Alice", "Bob let's meet");
        messageSystem.sendMessage("Bob", "/meet Alice");
        messageSystem.sendMessage("David", "/away out for lunch");
        messageSystem.sendMessage("Emily", "Anyone around?");
        messageSystem.sendMessage("Frank", "/meet David");

        List<String> expected = Arrays.asList(
            "Alice: Hello",
            "Bob: Hi",
            "Alice: Nice job on your presentations",
            "Cindy: /givetaco 🌮🌮 @justin",
            "TacoBot: @Cindy gave @@justin 2 🌮's. @justin now have 2 🌮s.",
            "Alice: Bob let's meet",
            "Bob: /meet Alice",
            "MeetBot: Google Meet with @Bob, and Alice starting at https://meet.google.com/abc-def-123",
            "David: /away out for lunch",
            "Emily: Anyone around?",
            "Frank: /meet David",
            "AwayBot: David is away: out for lunch",
            "MeetBot: Google Meet with @Frank, and David starting at https://meet.google.com/abc-def-123"
        );

        assert messageSystem.getMessages().equals(expected) : "Messages don't match expected output!";
        System.out.println("All tests passed!");

        // Print all messages for verification
        for (String message : messageSystem.getMessages()) {
            System.out.println(message);
        }
    }
}
