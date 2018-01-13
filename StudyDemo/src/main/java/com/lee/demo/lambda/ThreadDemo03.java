package com.lee.demo.lambda;

public class ThreadDemo03 {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
	}

}
