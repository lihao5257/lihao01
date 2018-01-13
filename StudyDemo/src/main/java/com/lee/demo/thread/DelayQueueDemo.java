package com.lee.demo.thread;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueDemo {

	public static void main(String[] args) {
		Random random  = new Random(47);
		ExecutorService executorService = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<>();
		for (int i=0; i<20 ; i++) {
			queue.put(new DelayedTask(random.nextInt(5000)));
		}
		queue.add(new DelayedTask.EndSentinel(5000, executorService));
		executorService.execute(new DelayedTaskConsumer(queue));
	}
}
