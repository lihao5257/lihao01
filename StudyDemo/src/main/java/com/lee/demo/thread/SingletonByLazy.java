package com.lee.demo.thread;

public class SingletonByLazy {

	private static SingletonByLazy singleton;
	
	/*这里必须是private修饰符，否则，就可以new多个对象，这是单例模式SingletonByLazy.java最基本的保证*/
	private SingletonByLazy() {}
	
	/*需要注意的是，必须加上synchronized关键字。否则会导致对象的访问变得不安全。
	 * 饿汉的优点是延迟加载，在你需要的时候进行加载。缺点是必须使用同步*/
	public static synchronized SingletonByLazy getInstance() {
		if (singleton == null) {
			singleton = new SingletonByLazy();
		}
		return singleton;
	}
}
