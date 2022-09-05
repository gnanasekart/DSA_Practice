package leetcodechallenge;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class smallestLexicographicalOrder {
	
	/*
	 * Given a string s, remove duplicate letters so that every letter appears once and only once. 
	 * you must take sure your result is the smallest in lexicographical order amoung all possible results.
	 */
	
	@Test
	public void example1() {
		String s = "bcabc";
		removeDuplicate(s);//abc
	}
	
	@Test
	public void example2() {
		String s = "cbacdcbc";
		removeDuplicate(s);//acdb
	}

	/*
	 * DS = set and stack or queue
	 * 
	 */
	
	private void removeDuplicate(String s) {
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		System.out.println(set);
	}
}