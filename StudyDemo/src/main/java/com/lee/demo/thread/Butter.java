package com.lee.demo.thread;

public class Butter implements Runnable {

	private ToastQueue dryQueue, butteredQueue;
	public Butter(ToastQueue dry, ToastQueue butteredQueue){
		dryQueue = dry;
		this.butteredQueue = butteredQueue;
	}
	@Override
	public void run() {

		try {
			while(!Thread.interrupted()){
				Toast toast = dryQueue.take();
				toast.butter();
				System.out.println(toast);
				butteredQueue.put(toast);
			}
		}catch (InterruptedException e) {
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}
}
