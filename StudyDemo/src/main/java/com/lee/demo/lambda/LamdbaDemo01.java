package com.lee.demo.lambda;

public class LamdbaDemo01 {

	public static void main(String[] args) {

		// new Thread( () -> System.out.println("--")).start();
		MyLambda greet = () -> System.out.println("Hello World!");
		greet.foo();
		// MyAdd myAdd = (int i, int j) -> i + j; 
		// �?为参数�?变量名称�?致?��所以参数�?变量类型可以省略
		MyAdd myAdd = (i, j) -> i + j; 
		System.out.println(myAdd.add(2, 3));
		
		// 当参数只有�?个�?时候可以省略?���? ?�? 此外当箭头右侧�?代码只用�?行的时候，可以省略{}
		MyLength myLength = s -> s.length();
		System.out.println(myLength.leng("Hello world!"));
		
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 接口中只能有�?个方法，这是使用Lambda表达式的要�?
interface MyLambda {
	void foo();
}

interface MyAdd {
	int add(int i, int b);
}

interface MyLength {
	int leng(String s);
}
