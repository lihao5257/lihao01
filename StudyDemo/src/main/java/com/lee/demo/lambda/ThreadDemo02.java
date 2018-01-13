package com.lee.demo.lambda;

public class ThreadDemo02 extends Thread{
	public static void main(String args[]){
		Thread thread = new Thread(new LiftOff());
		thread.start();
	}

}
