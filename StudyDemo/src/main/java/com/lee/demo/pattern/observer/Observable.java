package com.lee.demo.pattern.observer;

public interface Observable {

	public void addObserver(Observer o);
	public void delObserver(Observer o);
	public void notifyObservers(String message); 
}
