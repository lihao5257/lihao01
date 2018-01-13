package com.lee.demo.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo05 {

	public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 1024; i++) {
			executor.execute(new LiftOff());
		}
		// shutDown方法，拒绝接受新�?任务。�?�认为类似于io�?close
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		    System.out.println("------------");
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}
		
	}

}
