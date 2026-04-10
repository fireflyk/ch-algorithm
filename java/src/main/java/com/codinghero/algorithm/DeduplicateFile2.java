package com.codinghero.algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DeduplicateFile2 {

    public void check(final String filePath) throws IOException {
        // Build content to files map
        final Map<String, List<String>> contentToFiles = new HashMap<>();
        Files.walk(new File(filePath).toPath())
            .filter(Files::isRegularFile)
            .forEach(path -> {
                try {
                    final String content = Files.readString(path);
                    contentToFiles.computeIfAbsent(content, key -> new ArrayList<>());
                    contentToFiles.get(content).add(path.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        // Collect duplicates
        final List<List<String>> result = new ArrayList<>();
        for (Entry<String, List<String>> e : contentToFiles.entrySet()) {
            if (e.getValue().size() >= 2) {
                result.add(e.getValue());
            }
        }

        // Print
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        DeduplicateFile2 deduplicator = new DeduplicateFile2();
        deduplicator.check("/Users/tong/test");
    }
}
