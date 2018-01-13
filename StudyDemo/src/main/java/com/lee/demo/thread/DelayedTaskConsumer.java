package com.lee.demo.thread;

import java.util.concurrent.DelayQueue;

public class DelayedTaskConsumer implements Runnable {

	private DelayQueue<DelayedTask> q;
	public DelayedTaskConsumer (DelayQueue<DelayedTask> q){
		this.q = q;
	}
	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				q.take().run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Finished DelayedTaskConsumer");
	}

}
