package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo04 implements Runnable{

	private int i=0;
	
	// 为了保证获取I的数值时，能达到稳定状态，应该同步地使用getValue，也就是加上synchronized关键字
	public int getValue() {
		// 虽然return i是原子性操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取。
		return i;
	}
	
	@Override
	public void run() {
		while (true) {
			evenIncrement();
		}
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		ThreadDemo04 demo04 = new ThreadDemo04();
		service.execute(demo04);
		while (true) {
			int val = demo04.getValue();
			if(val%2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
