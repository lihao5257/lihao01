package com.lee.demo.pattern.mediator;

public abstract class Colleague {

	Mediator mediator;
	
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public Mediator getMediator() {
		return mediator;
	}
	
	public abstract void requestLanding();
}
