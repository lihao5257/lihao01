package com.lee.demo.thread;

public class Singleton {

	/*为了防止外部访问，所以实例是private的
	为了在static方法中访问，所以必须是static
	至于为什么，叫饿汉模式。我想，因为在程序走到下面这一行时，
	会初始化，调用构造方法。在没有调用getInstance方法时，就创建好了实例。
	因为，可能叫做饿汉模式吧*/
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("666");
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
