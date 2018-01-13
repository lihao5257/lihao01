package com.lee.demo.pattern.mediator;

public class AirportControlTower implements Mediator {

	private PlaneA planeA;
	
	private PlaneB planeB;
	
	public void setPlaneA(PlaneA planeA){
		this.planeA = planeA;
	}
	
	public void setPlaneB(PlaneB planeB) {
		this.planeB = planeB;
	}
	@Override
	public void change(Colleague c) {
		if (c instanceof PlaneA) {
			System.out.println("planeA ,you can land");
		} else if (c instanceof PlaneB) {
			System.out.println("planeB ,you can land");
		}

	}

}
