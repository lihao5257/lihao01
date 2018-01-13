package com.lee.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {

	static void testApproaches(PairManager pman1 , PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1);
		PairManipulator pm2 = new PairManipulator(pman2);
		PairChecker pch1 = new PairChecker(pman1);
		PairChecker pch12= new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pch1);
		exec.execute(pch12);
		try {
			TimeUnit.MICROSECONDS.sleep(500);
		} catch (InterruptedException ex) {
			System.out.println("sleep intertuped");
		}
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
		System.exit(0);
	}
	
	public static void main(String[] args){
		PairManager pm1 = new PairManager1();
		PairManager pm2 = new PairManager2();
		testApproaches(pm1, pm2);
	}
}
