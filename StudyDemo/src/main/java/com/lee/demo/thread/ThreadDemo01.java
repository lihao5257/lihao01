package com.lee.demo.thread;

public class ThreadDemo01 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
				
				try {
					Thread.sleep(5000);
					System.out.println("sleep 5000");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		});
		Thread thread2 = new Thread(() -> System.out.println("print thead2"));
		
		// thread1.run();
		// thread2.run();
		thread1.start();
		thread2.start();
	}
}
