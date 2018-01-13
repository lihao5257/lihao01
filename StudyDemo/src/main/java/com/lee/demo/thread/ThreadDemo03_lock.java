package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo03_lock {

	public static void main(String[] args) throws InterruptedException {

		ThreadDemo02_lock demo02 = new  ThreadDemo02_lock();
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(demo02);
		}
		service.shutdown();
	}
}

