package com.learning.corejava.polymorphism;

public class MethodOverridingEx extends Employee {

	public static void main(String[] args) {
		Employee clerk = new Clerk();
		Employee manager = new Manager();
		clerk.salary();
		manager.salary();
		
	}

}
