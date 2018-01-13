package com.lee.demo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExercistWithLambda3 {

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
	printConditionally (list, (p) -> true, (p) -> System.out.println(p));
	
	System.out.println("-------------------------");
	// step 3: Create a method that prints all people whose lastName beginning whie C
	// printConditionally(list, (p) -> p.getLastName().startsWith("C"), (p) -> System.out.println(p));
	
	printConditionally(list, (p) -> p.getLastName().startsWith("C"), System.out::println);
	}

	private static void printConditionally (List<Person> list, Predicate<Person> predict, Consumer<Person> consumer) {
		for (Person p : list) {
			if (predict.test(p)) {
				consumer.accept(p);
			}
		}
	}
}

