package com.lee.demo.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observable{

	private List<Observer> list;
	
	public WechatServer(){
		list = new ArrayList<Observer>();
	}
	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	@Override
	public void delObserver(Observer o) {
		// TODO Auto-generated method stub
		list.remove(o);
	}

	@Override
	public void notifyObservers(String message) {
		// TODO Auto-generated method stub
		System.out.println("服务更新消息： " + message);
		for (Observer observer : list) {
			observer.update(message);
		}
	}

}
