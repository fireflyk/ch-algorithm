package com.codinghero.interview.google;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FileHashMap<K, V> implements Map<K, V> {

	private final static int INDEX_VALUE_LENGTH = 8;
	
	private File indexFile;
	
	private File dataFile;
	
	/**
	 * FileOutputStream will tack up 4 bytes at the head
	 */
	private long dataPos = 4;
	
	//private RandomAccessFile raIndex = new RandomAccessFile(indexFile, "rw");
	
	//private RandomAccessFile raData = new RandomAccessFile(dataFile, "rw");
	
	//@SuppressWarnings("rawtypes")
	//private Entry[] table;
	
	private int capacity;
	
	private int size;
	
	private int threshold;
	
	private final float loadFactor = 0.75f;
	
	private void init() throws IOException {
		Random random = new Random();
		indexFile = new File("file_hash_map" + System.currentTimeMillis() + "_"
				+ random.nextLong() + ".index");
		dataFile = new File("file_hash_map" + System.currentTimeMillis() + "_"
				+ random.nextLong() + ".data");
		if (indexFile.exists()) {
			indexFile.delete();
		}
		indexFile.createNewFile();
		if (dataFile.exists()) {
			dataFile.delete();
		}
		dataFile.createNewFile();
	}
	
	public FileHashMap(int capacity) throws IOException {
		init();
		this.capacity = capacity;
		this.threshold = (int) (loadFactor * capacity);
		//table = new Entry[capacity];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public V get(Object key) {
		int hashCode = hash(key.hashCode()) % capacity;
		RandomAccessFile raIndex = null, raData = null;
		ObjectInputStream is = null;
		V value = null;
		try {
			raIndex = new RandomAccessFile(indexFile, "r");
			raIndex.seek(hashCode * INDEX_VALUE_LENGTH);
			long pos = raIndex.readLong();
			
			raData = new RandomAccessFile(dataFile, "r");
			is = new ObjectInputStream(new FileInputStream(raData.getFD()));
			raData.seek(pos);
			value = (V) is.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close(raIndex);
		}
		return value;
	}

	@Override
	public V put(K key, V value) {
		int hashCode = hash(key.hashCode()) % capacity;
		RandomAccessFile raIndex = null, raData = null;
		ObjectOutputStream os = null;
		try {
			//final long curDataPos = dataPos;
			raIndex = new RandomAccessFile(indexFile, "rw");
			raIndex.seek(hashCode * INDEX_VALUE_LENGTH);
			raIndex.writeLong(dataPos);
			
			raData = new RandomAccessFile(dataFile, "rw");
			os = new ObjectOutputStream(new FileOutputStream(raData.getFD()));
			raData.seek(dataPos);
			os.writeObject(value);
			dataPos = raData.getFilePointer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(raIndex);
			close(raData);
			close(os);
		}
		return value;
	}

	@Override
	public V remove(Object key) {
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
	
	private void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
