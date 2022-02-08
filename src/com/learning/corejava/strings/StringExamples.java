package com.learning.corejava.strings;

public class StringExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating a string as primitive datatype and assiged a value to it
		
		String FName = "kavitha";
		String LName = "Inturi";
		System.out.println(FName);
		System.out.println(LName);
		
		//To find the length of a string, we use the length() method of the String
		
		String name = "kavitha";
		System.out.println("name of the string is:" +name);
		System.out.println("Length of the string is:" +name.length());
		
		//We can join two strings in Java using the concat() method
		String FirstName = "kavitha ";
		String LastName = "Inturi";
		String fullName = FirstName.concat(LastName);
		System.out.println("joined String is :"+fullName);
		
		//we can make comparisons between two strings using the equals() method
		String name1 = "kavitha";
		String name2 = "Inturi";
		String name3 = "kavitha";
		
		// compare first and second strings
		boolean result1 = name1.equals(name2);
		boolean result2 = name1.equals(name3);
		
		if (result1 == true) 
			
			System.out.println("string1 and string2 are equal:");
	
			
		else if (result2 == true)
			
			System.out.println("string1 and string3 equal");
		
		else 
			System.out.println("given strings are not equal");	
		
		
		//*******Create Java Strings using the new keyword******
		
		String userName  = new String("kavitha Inturi");
		System.out.println("UserName is: " + userName);
		
		//The contains() method checks whether the specified string
		//(sequence of characters) is present in the string or not.
		String userName1  = new String("kavitha Inturi");
		boolean output = userName1.contains("kavi");
		System.out.println("String contains substring : " + output);
		
		String str1 = "I";
	    String str2 = "love";
	    String str3 = "Java";

	    // join strings with space between them
	    String joinedStr = String.join(" ", str1, str2, str3);

	    System.out.println(joinedStr);
		
	}
}
