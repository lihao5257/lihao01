package com.lee.demo.springSourceLearn.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.lee.demo.lambda.Person;

public class Test {

	public static void main(String args[]){
		int a = 2,b =2,c =2,d = 2;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		Student oldStudent = new Student();
		oldStudent.name = "lee";
		Student newStudent = oldStudent;	

		System.out.println(oldStudent.name);
		System.out.println(newStudent.name);
		System.out.println("----------------------");
		newStudent.name = "hao";
		System.out.println(oldStudent.name);
		System.out.println(newStudent.name);
	
}
}

class Student {
	String name;
}


