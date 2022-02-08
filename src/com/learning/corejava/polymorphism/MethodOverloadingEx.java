package com.learning.corejava.polymorphism;

public class MethodOverloadingEx {

	// Overloading by changing the number of parameters and type of parameters
	public static void display(int i) {
		System.out.println("Arguments are " + i);
	}

	public static void display(int i, int j) {
		System.out.println("Arguments are " + i + " and " + j);
	}

	public static void display(int i, double j) {
		System.out.println("Arguments are " + i + " and " + j);
	}

	public static void display(String str) {
		System.out.println("Arguments are " + str);
	}

	public static String display(String str1, String str2) {

		String fullStr = str1.concat(str2);

		System.out.println("Arguments are " + str1 + " " + str2);

		return fullStr;

	}

	public static void main(String[] args) {
		display(1);
		display(5, 10);
		display(3, 5.5);
		display("yakshitha");
		display("kavitha", "Inturi");

	}

}
