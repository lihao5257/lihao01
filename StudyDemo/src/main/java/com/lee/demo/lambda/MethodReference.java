package com.lee.demo.lambda;

public class MethodReference {

	public static void main(String[] args) {

		// 下面两行的代码是等价�?
		// Thread thread = new Thread(() -> printMessage());
		Thread thread = new Thread(MethodReference::printMessage);
		thread.start();
	}

	private static void printMessage() {
		System.out.println("Hello World!");
	}

}
