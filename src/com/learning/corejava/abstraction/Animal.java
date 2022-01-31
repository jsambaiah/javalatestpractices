package com.learning.corejava.abstraction;

//An abstract class can have both abstract and regular methods:

public abstract class Animal {
	
	public abstract void animalSound();
	
	public void eat() {
		System.out.println("food");
	}
	
	public void sleep() {
		System.out.println("sleeps under drainage");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
