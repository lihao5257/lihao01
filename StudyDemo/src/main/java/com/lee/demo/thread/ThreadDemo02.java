package com.lee.demo.thread;

public class ThreadDemo02 implements Runnable{

	private static int i = 0;
	
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " i value is " + i++);
		}
	}
}
