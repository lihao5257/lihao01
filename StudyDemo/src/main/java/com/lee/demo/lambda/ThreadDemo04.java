package com.lee.demo.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo04 {
	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		
		// ExecutorService service = Executors.newFixedThreadPool(2);
		// ExecutorService service = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			service.execute(new LiftOff());
		}
		// shutDown方法，拒绝接受新�?任务。�?�认为类似于io�?close
		service.shutdown();
		System.out.println("------------");
	}
}
