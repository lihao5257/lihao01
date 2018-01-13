package com.lee.demo.pattern.mediator;

public class PlaneA extends Colleague {

	public PlaneA(Mediator mediator) {
		super(mediator);
	}
	
	public void requestLanding(){
		System.out.println("this is planeA, request landing");
		getMediator().change(this);
	}
	

}
