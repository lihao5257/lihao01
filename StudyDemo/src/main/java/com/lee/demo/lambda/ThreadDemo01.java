package com.lee.demo.lambda;

public class ThreadDemo01 extends Thread{
	public static void main(String args[]){
		LiftOff lift = new LiftOff();
		lift.run();
	}
}
