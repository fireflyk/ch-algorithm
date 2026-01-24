package com.codinghero.datastructure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

class LRUCacheSolution {
    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache(3);
        cache.put("test1", "value1");
        cache.put("test2", "value2");
        cache.put("test3", "value3");
        cache.put("test1", "value11");
        cache.put("test4", "value4");
        cache.saveSnapshotToFile();
        System.out.println(cache.get("test1"));
        System.out.println(cache.get("test2"));
    }
    
    private static class LRUCache<K, V> {

        private String snapshotFilePath = "/tmp/lru_cache_snapshot.txt";
        
        private int capacity;
        
        private Node<K, V> head;
        
        private Node<K, V> tail;
        
        private Map<K, Node<K, V>> map = new HashMap<>();
        
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node<>(null, null);
            this.tail = head;
        }
        
        public V get(K key) {
            Node<K, V> node = map.get(key);
            if (node == null) {
                return null;
            }
            this.removeNode(node);
            this.moveToTail(node);
            return node.value;
        }
        
        public void put(K key, V value) {
            Node<K, V> oldNode = map.remove(key);
            if (oldNode != null) {
                this.removeNode(oldNode);
            }
            
            Node<K, V> newNode = new Node(key, value);
            map.put(key, newNode);
            this.moveToTail(newNode);
            
            while (map.size() > capacity) {
                Node<K, V> firstNode = head.next;
                this.removeNode(firstNode);
                map.remove(firstNode.key);
                this.cleanUpPointers(firstNode);
            }
        }

        public void saveSnapshotToFile() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(snapshotFilePath))) {
                oos.writeObject(map);
            } catch (IOException e) {
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