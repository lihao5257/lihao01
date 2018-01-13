package com.lee.demo.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {

	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storange = Collections.synchronizedList(new ArrayList<Pair>());
	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}
	protected void store(Pair p){
		storange.add(p);
		try {
			TimeUnit.MICROSECONDS.sleep(50);
		} catch (InterruptedException ignore){
			
		}
	}
	
	public abstract void increment();
}
