package com.learning.corejava.arrays;

import java.util.Arrays;

public class SortArray {

	  public static void main(String[] args) {        
	        //Initialize array     
	        int [] arr = {5, 2, 8, 7, 1};     
	        int temp = 0;    
	        //Displaying elements of original array    
	        System.out.println("Elements of original array: ");    
	        for (int i = 0; i < arr.length; i++) {     
	            System.out.print(arr[i] + " ,");    
	        }    
	            
	        //Sort the array in descending order    
	        for (int i = 0; i < arr.length; i++) {     
	            for (int j = i+1; j < arr.length; j++) {     
	               if(arr[i] < arr[j]) {    
	                   temp = arr[i];    
	                   arr[i] = arr[j];    
	                   arr[j] = temp;    
	               }     
	            }     
	        }    
	            
	        System.out.println();    
	            
	        //Displaying elements of array after sorting    
	        System.out.println("Elements of array sorted in descending order: ");    
	        for (int i = 0; i < arr.length; i++) {     
	            System.out.print(arr[i] + " ");    
	        }    
	        System.out.println();
	        
	        System.out.println("Elements of array sorted in asscending order: "); 
	       for (int  i = arr.length-1; i>=0; i--)
	       {     
	    	   System.out.print(arr[i] + " "); 
	       }  
	       
	  }
}