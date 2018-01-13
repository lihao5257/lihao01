package com.lee.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountSizeDemo {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(4);
		DiskMemory diskMemory = new DiskMemory();
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {

			executorService.execute(() -> {
				try {
					TimeUnit.MICROSECONDS.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				int size = diskMemory.getSize();
				System.out.println("get size: " + size);
				diskMemory.setSize(size);
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(diskMemory.getTotalSize());
		executorService.shutdownNow();
	}

}
