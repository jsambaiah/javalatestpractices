package com.learning.corejava.arrays;

import java.util.Arrays;

public class MaxAndMinNumbersArray {

	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;

	}

	public static void main(String[] args) {

		int[] numbersArray = { 10, 5, 120, 35, 15, 40, 99, 25, 0 };
        //Using Arrays.sort method to Find Maximum and Minimum Values in an Array
		Arrays.sort(numbersArray);
		System.out.println("Array of elements after sorting...");
		System.out.println("minimum number is:" + numbersArray[0]);
		System.out.println("maximum number is:" + numbersArray[numbersArray.length - 1]);

		
		//we can find maximum or minimum value in a numeric array by looping through the array. 
		int numbers[] = { 1, 5, -9, 12, 89, 18, 23, 4, 6 };
		
		// Find minimum (lowest) value in array using loop
		System.out.println("Array of elements after looping...");
		System.out.println("Minimum Value = " + getMinValue(numbers));

		// Find maximum (largest) value in array using loop
		System.out.println("Maximum Value = " + getMaxValue(numbers));

	}

}