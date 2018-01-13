package com.lee.demo.pattern.mediator;

public class Client {

	public static void main(String args[]){
		AirportControlTower tower = new AirportControlTower();
		PlaneA a = new PlaneA(tower);
		PlaneB b = new PlaneB(tower);
		tower.setPlaneA(a);
		tower.setPlaneB(b);
		a.requestLanding();
		b.requestLanding();
		
	}
}
