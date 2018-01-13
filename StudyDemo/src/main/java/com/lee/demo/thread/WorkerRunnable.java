package com.lee.demo.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class WorkerRunnable implements Runnable {

	private CountDownLatch doneSignal;
	private static int totalSize = 0;
	public WorkerRunnable (CountDownLatch doneSignal) {
		this.doneSignal = doneSignal;
	}
	@Override
	public void run() {
		synchronized (this) {
			
		
		setSize();
		System.out.println(totalSize);
		}
	}
	
	public synchronized int getSize() {
		int i = 0;
		i = new Random().nextInt(4) + 1;
		System.out.println("created number: " + i);
		return i;
	}
	
	public synchronized void setSize() {
		totalSize = totalSize + getSize();
	}

}
