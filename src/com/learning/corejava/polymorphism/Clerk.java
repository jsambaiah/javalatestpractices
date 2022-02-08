package com.learning.corejava.polymorphism;

//Child classs extended parent class
public class Clerk extends Employee {

	public int salary() {
		int sal = base + 2000;
		System.out.println("clerk salary is " + sal);
		return sal;

	}
}
