package com.lee.demo.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {

	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random rand = new Random(47);

		protected synchronized Integer initialValue() {
			return rand.nextInt(100);
		}
	};

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {
		return value.get();
	}
	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 4; i++) {

			service.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		service.shutdownNow();
	}

}
