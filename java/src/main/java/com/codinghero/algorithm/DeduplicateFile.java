package com.codinghero.algorithm;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeduplicateFile {

    private static final int MAX_DEPTH = 1;

    public void check(String path) {
        final Map<Long, List<File>> sizeToFiles = new HashMap<>();
        File folder = new File(path); // Current directory
        aggregateBySize(folder, sizeToFiles, 1);

        final Map<String, List<File>> hashToFiles = new HashMap<>();
        for(Map.Entry<Long, List<File>> entry : sizeToFiles.entrySet()) {
            List<File> files = entry.getValue();
            if (files.size() >= 2) {
                System.out.println("Files with size " + entry.getKey() + " bytes:");
                for (File file : files) {
                    System.out.println(" - " + file.getAbsolutePath());
                }
            }
        }
        // TODO Find duplicates after size check
    }

    private void aggregateBySize(File folder, Map<Long, List<File>> sizeToFiles, int depth) {
        if (depth > MAX_DEPTH) {
            return;
        }
        System.out.println("Scanning folder: " + folder.getAbsolutePath());
        final File[] filesList = folder.listFiles();
        if (filesList != null) {
            for (File element : filesList) {
                if (element.isFile()) {
                    long fileSize = element.length();
                    sizeToFiles.computeIfAbsent(fileSize, k -> new java.util.ArrayList<>()).add(element);
                } else {
                    aggregateBySize(element, sizeToFiles, depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        DeduplicateFile deduplicator = new DeduplicateFile();
        deduplicator.check("/Users/tong/test");
    }
}
