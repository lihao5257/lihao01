package com.lee.demo.thread;

public class DualSynch {

	private Object object = new Object();
	public synchronized void f() {
		for (int i = 0; i < 5; i++) {
			System.out.println("f()");
			Thread.yield();
		}
	}
	
	public void g() {
		synchronized (object) {
			for (int i = 0; i < 5; i++) {
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}
