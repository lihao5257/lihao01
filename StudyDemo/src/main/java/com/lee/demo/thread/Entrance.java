package com.lee.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {

	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	
	private static volatile boolean canceled = false;
	
	public static void cancel() {
		canceled = false;
	}
	
	public Entrance(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	
	
	@Override
	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MICROSECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("sleep intertrupted");
			}
		}
		System.out.println("stoppint " + this);
	}
	
	public synchronized int getValue() {
		return number;
	}
	
	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}
	
	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance: entrances){
			sum += entrance.getValue();
		}
		return sum;
	}
}
