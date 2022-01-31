package com.learning.corejava.strings;

public class TestStringFormatter 
{

	public static void main(String[] args) {

				StringBuffer sbf = new StringBuffer("kavitha Inturi!");
		        System.out.println("String buffer = " + sbf);
		         
		        // Here it reverses the string buffer
		        sbf.reverse();
		        System.out.println("String buffer after reversing = " + sbf); 
		        
		        
		        //counting the alphabets in given string
		        
		        String str = "I Love Duabi";
		        
		        int count = 0;
		        
		        for (int i = 0; i< str.length();i++)
		        {
		        	if(str.charAt(i) != ' ')    
		                count++;    
		        }
		        System.out.println ("Number of letters/characters in a given string :" +count);

	}

 }
