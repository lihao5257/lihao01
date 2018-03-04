package com.lee.demo.pattern.observer;

public class Test {
	public static void main(String[] args) {
        WechatServer server = new WechatServer();
        
        Observer userZhang = new User("Lee");
        Observer userLi = new User("Lee2");
        Observer userWang = new User("Lee3");
        
        server.addObserver(userZhang);
        server.addObserver(userLi);
        server.addObserver(userWang);
        server.notifyObservers("C是世界上最好用的语言！");
        
        System.out.println("----------------------------------------------");
        server.delObserver(userZhang);
        server.notifyObservers("JAVA是世界上最好用的语言！");
        
    }
}
