package com.lee.demo.lambda;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(
				new Person ("Charles", "Dickens", 60),
				new Person ("Lewis", "Carrol", 42),
				new Person ("Thamos", "Cayloe", 51),
				new Person ("Charlotte", "Brote", 45),
				new Person ("Matthew", "Aroid", 39)
				);
		
		System.out.println("Using for loop");
		for (int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("Using for each loop");
		for (Person person : list) {
			System.out.println(person);
		}
		
		// Java8 Lambda
		System.out.println("Using for loop");
		list.forEach(p -> System.out.println(p));
		System.out.println("--------------");
		list.forEach(System.out::println);
	}

}
