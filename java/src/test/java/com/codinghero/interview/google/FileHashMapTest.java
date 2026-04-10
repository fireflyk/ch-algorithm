package com.codinghero.interview.google;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class FileHashMapTest {
	
	private String indexFileName = "file_hash_map.index";
	
//	@Test
	public void test1() throws IOException {
		File indexFile = new File(indexFileName);
		indexFile.createNewFile();
		RandomAccessFile raf = new RandomAccessFile(indexFile, "rw");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(raf.getFD()));
		raf.seek(0);
		raf.writeLong(3);
		raf.writeLong(0);
		raf.writeLong(3);
		os.writeObject(new Long(1));
		Assert.assertEquals(102, raf.getFilePointer());
		raf.close();
		os.close();
	}

	
	@Test
	public void test2() throws IOException {
		Map<Integer, String> map = new FileHashMap<Integer, String>(100);
		map.put(3, "abc");
		map.put(5, "abcde");
		Assert.assertEquals("abc", map.get(3));
		Assert.assertEquals("abcde", map.get(5));
	}
}
