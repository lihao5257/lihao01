package com.lee.demo.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {

	private ToastQueue taostQueut;
	private int count = 0;
	private Random rand = new Random(47);
	public Toaster(ToastQueue tq){
		taostQueut = tq;
	}
	@Override
	public void run() {

		try {
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100 + rand.nextInt(500));
				Toast toast = new Toast(count++);
				System.out.println(toast);
				taostQueut.put(toast);
			}
		}catch (InterruptedException e) {
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}
}
