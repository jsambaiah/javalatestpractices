package com.learning.corejava.abstraction;

public class Pig extends Animal {

	public void animalSound() {
		System.out.println("pig makes the sound as......Wawawawa.....");

	}

	public void eat() {
		System.out.println("Pig eats plants and grains");

	}

	public void sleep() {
		System.out.println("Pig sleeps at different places.....");
	}
	
	public void pigLifeSpan()
	{
		System.out.println("Pigs live an average of 5-18 years..");
	}
	

	public static void main(String[] args) {

		Pig p1 = new Pig();
		p1.animalSound();
		p1.sleep();
		p1.eat();
		p1.pigLifeSpan();
	}

}
