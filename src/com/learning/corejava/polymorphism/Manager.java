package com.learning.corejava.polymorphism;

//Child classs extended parent class
public class Manager extends Employee {

	public int salary() {
		int sal = base + 5000;
		System.out.println("Manager salary is " + sal);
		return sal;
	}

}
