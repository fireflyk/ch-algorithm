package com.codinghero.algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeduplicateFile3 {

    public void checkDupFiles(final String filePath) throws IOException {
        final Map<Long, List<Path>> sizeToFiles = this.aggregateFilesByCheckingSize(filePath);
        System.out.println(sizeToFiles);

        final List<List<Path>> result = new ArrayList<>();
        for (List<Path> files : sizeToFiles.values()) {
            result.addAll(this.findDupFilesByCheckingContent(files));
        }

        System.out.println(result);
    }

    Map<Long, List<Path>> aggregateFilesByCheckingSize(final String filePath) throws IOException {
        final Map<Long, List<Path>> sizeToFiles = new HashMap<>();
        Files.walk(new File(filePath).toPath())
            .filter(Files::isRegularFile)
            .forEach(path -> {
                try {
                    final long size = Files.size(path);
                    sizeToFiles.computeIfAbsent(size, key -> new ArrayList<>());
                    sizeToFiles.get(size).add(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        return sizeToFiles.entrySet().stream()
            .filter(e -> e.getValue().size() >= 2)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private List<List<Path>> findDupFilesByCheckingContent(List<Path> files) {
        final List<List<Path>> result = new ArrayList<>();
        for (Path file : files) {
            Optional<List<Path>> optionalDupFiles = result.stream().filter(dupFiles -> {
                try {
                    return Files.mismatch(dupFiles.get(0), file) == -1L;
                } catch (IOException e) {
                    return false;
                }
            }).findAny();
            if (optionalDupFiles.isPresent()) {
                optionalDupFiles.get().add(file);
            } else {
                final List<Path> newDupFiles = new ArrayList<>();
                newDupFiles.add(file);
                result.add(newDupFiles);
            }
        }
        return result.stream().filter(dupFiles -> dupFiles.size() >= 2).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        DeduplicateFile3 deduplicator = new DeduplicateFile3();
        deduplicator.checkDupFiles("/Users/tong/test");
    }
}
