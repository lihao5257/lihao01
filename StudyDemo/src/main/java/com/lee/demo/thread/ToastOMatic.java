package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {

	public static void main(String[] args) throws InterruptedException {

		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butteredQueue = new ToastQueue();
		ToastQueue finishedQueue = new ToastQueue();
		//ExecutorService servie = Executors.newCachedThreadPool();
		ExecutorService servie = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                // user-defined ThreadFactory
                new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread thread = new Thread(r);
						thread.setName(r.getClass().getName());
						return thread;
					}
				},
                // user-defined Thread rejection policy
                new ThreadPoolExecutor.AbortPolicy());
		servie.execute(new Toaster(dryQueue));
		servie.execute(new Butter(dryQueue, butteredQueue));
		servie.execute(new Jammer(butteredQueue, finishedQueue));
		servie.execute(new Eatter(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		servie.shutdownNow();
	}

}
