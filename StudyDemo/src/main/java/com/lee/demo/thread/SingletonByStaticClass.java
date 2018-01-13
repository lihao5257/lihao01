package com.lee.demo.thread;

public class SingletonByStaticClass {

	/*通过类加载机制，保证创建单一对象*/
	private static class SingletonHolder {
		private static final SingletonByStaticClass single = new SingletonByStaticClass();
	}
	
	private SingletonByStaticClass() {}
	
	/*对于JAVA的加载机制来说，当第一次访问类的静态字段时，会触发类的加载*/
	public static SingletonByStaticClass getInstance() {
		return SingletonHolder.single;
	}
}
