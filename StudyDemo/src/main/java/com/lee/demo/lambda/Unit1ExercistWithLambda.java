package com.lee.demo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1ExercistWithLambda {

	public static void main(String args[]) {
		
	List<Person> list = Arrays.asList(
			new Person ("Charles", "Dickens", 60),
			new Person ("Lewis", "Carrol", 42),
			new Person ("Thamos", "Cayloe", 51),
			new Person ("Charlotte", "Brote", 45),
			new Person ("Matthew", "Aroid", 39)
			);
	
	// step 1: sort list by lastName
	// 使用Lambda表达式时?���?��?始�?�不�?�?��可以先�?��?�匿名类�?形式，之后在这个基�?上�?�进行修改?���?�慢�?就会�?��?
	// 为�?么括号里直接省略掉参数类型，�?�?看用Java8实现�?例�?
	Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
	
	// step 2: Create a method that print all elements in the list
	printConditionally (list, (p) -> true);
	
	System.out.println("-------------------------");
	// step 3: Create a method that prints all people whose lastName beginning whie C
	printConditionally(list, (p) -> p.getLastName().startsWith("C"));
	}

	private static void printConditionally (List<Person> list, Condition condition) {
		for (Person p : list) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
}
