package com.lee.demo.pattern.stragety;

public class ConcreteCanNotFly implements Fly {


	@Override
	public void fly() {
		System.out.println("I cannot fly");
	}

}
