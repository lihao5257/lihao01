package com.lee.demo.pattern.stragety;

public class Chick {

	private Fly fly;
	
	public void setFly(Fly fly) {
		this.fly = fly;
	}

	public void run () {
		System.out.println("I can run");
	}
	
	public void dance() {
		System.out.println("I can dance");
	}
	
	public void performFly() {
		fly.fly();
	}
	
}
