package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo03 {

	public static void main(String[] args) throws InterruptedException {

		ThreadDemo02 demo02 = new  ThreadDemo02();
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.execute(demo02);
		}
		service.shutdown();
	}
}

