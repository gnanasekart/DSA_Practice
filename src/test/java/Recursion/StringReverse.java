package Recursion;

import org.testng.annotations.Test;

public class StringReverse {

	String rev = "";
	@Test
	public void example1() {
		String s = "hello";
		System.out.println(StringReverseRecursion(s));
	}

	/*
	 *  Input length ==> 0 return input
		call recursively -> 0 to n-1
		get the last char - append to string
		finally return appended.
	 */
	private String StringReverseRecursion(String s) {
		if(s.length() == 0) return s;
		
		rev = rev+s.charAt(s.length()-1);
		
		StringReverseRecursion(s.substring(0, s.length()-1));
		return rev;
	}
}
