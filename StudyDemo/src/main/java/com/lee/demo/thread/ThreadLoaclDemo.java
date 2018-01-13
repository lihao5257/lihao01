package com.lee.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.lee.demo.polo.User;

public class ThreadLoaclDemo {

	private static final int THREAD_LOOP_SIZE= 500;
	private static final int MAX_DIB_DATA_LOOP_SIZE= 1000;
	private static ThreadLocal<List<User>> local = new ThreadLocal<>();
	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
		for (int i= 0; i< THREAD_LOOP_SIZE; i++) {
			service.execute(()-> {
				local.set(new ThreadLoaclDemo().addBigList());
				Thread thread = Thread.currentThread();
				System.out.println(thread.getName());
				//local.remove();
				
			});
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//service.shutdown();
	}
	
	private List<User> addBigList() {
		List<User> params = new ArrayList<>(MAX_DIB_DATA_LOOP_SIZE);
		for(int i = 0; i<MAX_DIB_DATA_LOOP_SIZE; i++){
			params.add(new User("ruliugen", "password" + i, "nan" ,i));
		}
		return params;
	}
}
