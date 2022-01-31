/**
 * 
 */
package com.learning.corejava.interfaces;

/**
 * @author samba
 *
 */
public class ProgrammingLanguage implements Language {

	public String getName(String str) {
		str = "Java";

		System.out.println("The Language name  is :" + str);

		return str;

	}

	public void getType() {

		String type = "Programming Lanaguage";
		System.out.println("The language type  is :" + type);
	}

	public void getVersion() {
		double version = 1.8;
		System.out.println("The language version  is :" + version);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Language lr = new ProgrammingLanguage();

		lr.getName("");
		lr.getType();
		lr.getVersion();

	}

}
