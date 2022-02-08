package com.learning.corejava.polymorphism;

public class MethodOverloadingTest extends MethodOverloadingEx {

	private static void display(int i, int j, int k) {
		System.out.println("Arguments are " + i + " and " + j + " and " + k);
	}

	public static void main(String[] args) {

		MethodOverloadingEx.display("kavitha");
		display(2,4,6);

	}

}