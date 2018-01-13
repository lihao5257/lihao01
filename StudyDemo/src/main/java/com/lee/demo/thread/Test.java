package com.lee.demo.thread;

public class Test {

	public void method01(){
		System.out.println("method01");
	}
	
	public static void method02(){
		System.out.println("method02");
	}
	
	public static void main(String args[]){
		new Test().method01();
		method02();
	}
}
