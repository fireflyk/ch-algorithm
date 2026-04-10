package com.codinghero.datastructure;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.time.Instant;

class PersistentLRUCacheSolution {
    public static void main(String[] args) {
        PersistentLRUCache<String, String> cache = new PersistentLRUCache<>(3);
        cache.put("test1", "value1");
        cache.put("test2", "value2");
        cache.put("test3", "value3");
        cache.put("test4", "value4");
        cache.saveSnapshotToFile();

        PersistentLRUCache<String, String> cache2 = PersistentLRUCache.restoreSnapshotFromFile();
        System.out.println(cache2.get("test1"));
        System.out.println(cache2.get("test2"));
        System.out.println(cache2.get("test3"));
        System.out.println(cache2.get("test4"));
    }
    
    private static class PersistentLRUCache<K, V> {

        private static final String DEFAULT_SNAPSHOT_FILE_PATH = "/tmp/lru_cache_snapshot.txt";

        private String snapshotFilePath = DEFAULT_SNAPSHOT_FILE_PATH;
        
        private int capacity;
        
        private Node<K, V> head;
        
        private Node<K, V> tail;
        
        private Map<K, Node<K, V>> map = new HashMap<>();
        
        private IncrementalRecordWriter<K, V> incrementalRecordWriter;
        
        public PersistentLRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node<>(null, null);
            this.tail = head;
            this.incrementalRecordWriter = new IncrementalRecordWriter<>();
        }
        
        public V get(K key) {
            final LRUCacheRecord<K, V> record = new LRUCacheRecord<>(
                key, null, RecordType.GET, System.currentTimeMillis());
            incrementalRecordWriter.write(record);

            Node<K, V> node = map.get(key);
            if (node == null) {
                return null;
            }
            this.removeNode(node);
            this.moveToTail(node);
            return node.value;
        }
        
        public void put(K key, V value) {
            final LRUCacheRecord<K, V> record = new LRUCacheRecord<>(
                key, value, RecordType.PUT, System.currentTimeMillis());
            incrementalRecordWriter.write(record);

            final Node<K, V> oldNode = map.remove(key);
            if (oldNode != null) {
                this.removeNode(oldNode);
            }
            
            final Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            this.moveToTail(newNode);
            
            while (map.size() > capacity) {
                Node<K, V> firstNode = head.next;
                this.removeNode(firstNode);
                map.remove(firstNode.key);
                this.cleanUpPointers(firstNode);
            }
        }

        public void clear() {
            map.clear();
            head.next = null;
            tail = head;
        }

        public int size() {
            return map.size();
        }

        public void saveSnapshotToFile() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(snapshotFilePath))) {
                oos.writeObject(capacity);
                oos.writeObject(this.size());
                Node<K, V> cursor = head.next;
                while (cursor != null) {
                    oos.writeObject(cursor);
                    cursor = cursor.next;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        public static <K, V> PersistentLRUCache<K, V> restoreSnapshotFromFile() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEFAULT_SNAPSHOT_FILE_PATH))) {
                final int capacity = (int) ois.readObject();
                final PersistentLRUCache<K, V> cache = new PersistentLRUCache<>(capacity);
                final int size = (int) ois.readObject();
                for (int i = 0; i < size; i++) {
                    final Node<K, V> node = (Node<K, V>) ois.readObject();
                    cache.put(node.key, node.value);
                }
                return cache;
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        
        private void moveToTail(Node<K, V> node) {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        
        private void removeNode(Node<K, V> node) {
            Node<K, V> prevNode = node.prev;
            Node<K, V> nextNode = node.next;
            prevNode.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }
        
        private void cleanUpPointers(Node<K, V> node) {
            node.prev = null;
            node.next = null;
        }
    }

    private static enum RecordType {
        PUT,
        GET,
        REMOVE,
    }

    private static class LRUCacheRecord<K, V> implements Serializable {

        private K key;

        private V value;

        private RecordType type;

        private long timestamp;

        public LRUCacheRecord(K key, V value, RecordType type, long timestamp) {
            this.key = key;
            this.value = value;
            this.type = type;
            this.timestamp = timestamp;
        }
    }

    private static class IncrementalRecordWriter<K, V> {
        
        private static final String FILE_PATH_FORMAT = "/tmp/lru_cache_history_%s.txt";

        private String currentFileId;

        private ObjectOutputStream oos;

        private final int flushCapacity;

        private int flushCounter = 0;

        public IncrementalRecordWriter() {
            this(1000);
        }

        public IncrementalRecordWriter(int flushCapacity) {
            this.flushCapacity = flushCapacity;
        }

        private ObjectOutputStream getObjectOutputStream(final long timestamp) throws IOException {
            final Instant instant = Instant.ofEpochMilli(timestamp);
            final LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
            String formattedTime = localDateTime.format(formatter);
            if (formattedTime.equals(currentFileId)) {
                return oos;
            } else {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
                oos = new ObjectOutputStream(new FileOutputStream(String.format(FILE_PATH_FORMAT, formattedTime)));
                currentFileId = formattedTime;
                return oos;
            }
        }

        public void write(final LRUCacheRecord<K, V> record) {
            try {
                ObjectOutputStream oos = this.getObjectOutputStream(record.timestamp);
                oos.writeObject(record);
                flushCounter++;
                if (flushCounter >= this.flushCapacity) {
                    oos.flush();
                    flushCounter = 0;
                }
            } catch (IOException e) {
                // TODO add memory buffer
                System.err.println("Failed to write record to snapshot file");
            }
        }
    }
    
    private static class Node<K, V> implements Serializable {
        
        private K key;
        
        private V value;
        
        private Node<K, V> prev;
        
        private Node<K, V> next;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}