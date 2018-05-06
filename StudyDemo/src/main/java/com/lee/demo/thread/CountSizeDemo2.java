package com.lee.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.StaticApplicationContext;

public class CountSizeDemo2 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println(Integer.SIZE);
/*		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 40; i++) {
			executorService.execute(() -> {
					System.out.println("j");
			});
		}*/
	}

}
