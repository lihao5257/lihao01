package com.lee.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetTotalSize {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; ++i) // create and start threads
		    e.execute(new WorkerRunnable(latch));

		latch.await();           // wait for all to finish
		e.shutdown();
	}

}
