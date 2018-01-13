package com.lee.demo.thread;

public class PairManager2 extends PairManager {

	@Override
	public void increment() {

		Pair pair;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			pair = getPair();
		}
		store(pair);
	}

}
