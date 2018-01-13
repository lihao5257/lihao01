package com.lee.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Thread(() -> {
			System.out.println("Polling...");
			while (true) {
				Integer poll;
				try {
					poll = queue.take();
					System.out.println("Pooled: " + poll);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}));
		
		TimeUnit.MICROSECONDS.sleep(5);
		System.out.println("Adding to queue");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(1);
		queue.addAll(list);
		TimeUnit.MICROSECONDS.sleep(1);
	}
}
