package com.lee.demo.lambda;

public class LamdbaDemo02 {

	public static void main(String[] args) {

		// 接口�?须只能有�?个方法，这种接口叫做功能接口
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hellow world! anonymous class");
			}
		}).run();
		
		new Thread(() -> System.out.println("Hellow world! Lambda ")).run();
	}

}
