package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {

			service.execute(new Entrance(i));
		}
		TimeUnit.MICROSECONDS.sleep(250);
		Entrance.cancel();
		service.shutdownNow();
		if (!service.awaitTermination(250, TimeUnit.MICROSECONDS)) {
			System.out.println("Some tasks were not terminated");
		}
		System.out.println("Total " + Entrance.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
		TimeUnit.MICROSECONDS.sleep(550);
	}

}
