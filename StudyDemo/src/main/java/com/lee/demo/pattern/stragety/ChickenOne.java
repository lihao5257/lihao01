package com.lee.demo.pattern.stragety;

import org.apache.log4j.Logger;

public class ChickenOne extends Chick {

	private static Logger logger = Logger.getLogger(ChickenOne.class);
	public static void main(String args[]){
		
	
	// Fly fly = new ConcreteCanFly();
	Fly fly = new ConcreteCanNotFly();
	Chick one = new ChickenOne();
	one.setFly(fly);
	one.performFly();
	}
}
