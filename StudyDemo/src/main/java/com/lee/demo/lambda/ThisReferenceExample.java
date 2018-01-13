package com.lee.demo.lambda;

public class ThisReferenceExample {

	public static void main(String[] args) {
		AA aa = new AA();
		aa.doPrint();
	}


}

class AA {
	void doPrint() {
		System.out.println(this);
	}
	
	public String toString() {
		return "unbelievable";
	}
	
	
}