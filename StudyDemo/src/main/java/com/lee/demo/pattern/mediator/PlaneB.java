package com.lee.demo.pattern.mediator;

public class PlaneB extends Colleague {

	public PlaneB(Mediator mediator) {
		super(mediator);
	}

	public void requestLanding(){
		System.out.println("this is planeB, request landing");
		getMediator().change(this);
	}
	

}
