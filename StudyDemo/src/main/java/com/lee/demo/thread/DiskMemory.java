package com.lee.demo.thread;

import java.util.Random;

public class DiskMemory {

	private static int totalSize;
	
	public int getSize() {
		return new Random().nextInt(5) + 1;
	}
	
	public void setSize(int size) {
		// synchronized method is must
		synchronized (this) {
			System.out.println("-------first totalSize: " + totalSize);
			totalSize = totalSize + size;
			System.out.println("-------end totalSize: " + totalSize);
		}
		
	}
	
	public int getTotalSize() {
		return totalSize;
	}
}
