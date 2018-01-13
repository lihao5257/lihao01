package com.lee.demo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExercistWithJava7 {

	public static void main(String args[]) {
		
	List<Person> list = Arrays.asList(
			new Person ("Charles", "Dickens", 60),
			new Person ("Lewis", "Carrol", 42),
			new Person ("Thamos", "Cayloe", 51),
			new Person ("Charlotte", "Brote", 45),
			new Person ("Matthew", "Aroid", 39)
			);
	
	// step 1: sort list by lastName
	Collections.sort(list, new Comparator<Person>(){
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
	} );
	
	// step 2: Create a method that print all elements in the list
	printConditionally (list, new Condition(){
		@Override
		public boolean test(Person p) {
			return true;
		}
	});
	
	System.out.println("-------------------------");
	// step 3: Create a method that prints all people whose lastName beginning whie C
	printConditionally(list, new Condition(){
		@Override
		public boolean test(Person p) {
			return p.getLastName().startsWith("C");
		}
	});
	}

	private static void printConditionally (List<Person> list, Condition condition) {
		for (Person p : list) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
}

