package com.lee.demo.thread;

public class Eatter implements Runnable {

	private ToastQueue finishedQueue;
	private int counter = 0;
	public Eatter(ToastQueue tq){
		finishedQueue = tq;
	}
	@Override
	public void run() {

		try {
			while(!Thread.interrupted()){
				Toast toast = finishedQueue.take();
				if (toast.getId() != counter++ || toast.getStatus() != Toast.Status.JAMMED) {
					System.out.println(">>>> Eooro: " + toast);
					System.exit(1);
				} else {
					System.out.println("chomp " + toast);
				}
			}
		}catch (InterruptedException e) {
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}
}
