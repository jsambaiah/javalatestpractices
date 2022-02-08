package com.learning.corejava.leapyear;

import java.util.Scanner;

public class CheckLeapYear {

	public static void main(String[] args) {
		int year;

		System.out.println("Enter the year...");

		Scanner input = new Scanner(System.in);

		year = input.nextInt();

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 
		{
			System.out.println("Entered year is a leap year...");
			
		} 
		else

			System.out.println("Entered  year is non leap year...");
		
		input.close();
	}

}
