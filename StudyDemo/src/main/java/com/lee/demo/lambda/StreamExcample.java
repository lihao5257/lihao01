package com.lee.demo.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamExcample {

	public static void main(String[] args) {

		List<Person> list = Arrays.asList(
				new Person ("Charles", "Dickens", 60),
				new Person ("Lewis", "Carrol", 42),
				new Person ("Thamos", "Cayloe", 51),
				new Person ("Charlotte", "Brote", 45),
				new Person ("Matthew", "Aroid", 39)
				);
		
		System.out.println("-------------------------");
		list.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p));
		System.out.println("-------------------------");
		long count = list.stream()
		.filter(p -> p.getFirstName().startsWith("M"))
		.count();
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println(count);
		System.out.println();
	}
}
