package com.lee.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo02_lock implements Runnable{

	private static int i = 0;
	private Lock lock = new ReentrantLock();
	public void run() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " i value is " + i++);
		} finally {
			lock.unlock();
		}
	}
}
