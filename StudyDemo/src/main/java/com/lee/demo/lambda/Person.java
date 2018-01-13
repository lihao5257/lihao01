package com.lee.demo.lambda;

public class Person {
	
	public Person (String first ,String last ,int age) {
		this.firstName = first;
		this.lastName = last;
		this.age = age;
	}

	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String lastName;
	private int age;
	
	@Override
	public String toString(){
		return "firstName :" + firstName + " lastName ÅF" + lastName + " age "  + Integer.toString(age);
	}
}
