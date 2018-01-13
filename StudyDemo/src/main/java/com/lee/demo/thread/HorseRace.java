package com.lee.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {

	static final int FINIASH_LINE = 39;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService executorService = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	
	public HorseRace (int nHorse, final int pause) {
		barrier = new CyclicBarrier(nHorse, () -> {
			StringBuilder s = new StringBuilder();
			System.out.println("============================");
			for (Horse horse: horses) {
				System.out.println(horse.getStrides());
			}
			for (Horse horse: horses) {
				if (horse.getStrides() >= FINIASH_LINE) {
					System.out.println(horse + "won!");
					executorService.shutdownNow();
					return;
				}
			}
			
			try {
				TimeUnit.MICROSECONDS.sleep(pause);
			} catch (InterruptedException e) {
				System.out.println(s);
			}
 		});
		
		for (int i=0; i<nHorse; i++) {
			Horse horse = new Horse(barrier);
			horses.add(horse);
			executorService.execute(horse);
		}
	}
	public static void main(String[] args) {

		new HorseRace(3, 200);
	}

}
