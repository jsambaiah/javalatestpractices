package com.learning.corejava.readInputs;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInputsFromConsole {

	public static void main(String[] args) throws IOException {

		// 1.Reading User's Input using Scanner class
		Scanner input = new Scanner(System.in);

		System.out.println("Enter name :");
		String name = input.nextLine();
		System.out.println("Name: " + name);

		System.out.println("Enter age between 10 to 110 :");
		int age = input.nextInt();
		System.out.println("Age: " + age);
		
		System.out.println("Enter salary in integer or decimal:");
		double salary = input.nextDouble();
		System.out.println("Salary: " + salary);


		// 2.Reading User's Input using BufferedReader class

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your name: ");

		String name1 = reader.readLine();
		System.out.println("Your name is: " + name1);
		
		input.close();


	}	
}
