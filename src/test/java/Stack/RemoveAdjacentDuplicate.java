package Stack;

import java.util.Stack;

import org.testng.annotations.Test;

public class RemoveAdjacentDuplicate {

	/*
	 * you are given a string s consisting of lowercase English letters. 
	 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.

		we repeatedly make duplicate removals on s until we no longer can.

		return final string after all such duplicate removal have been made. 
		It can be proven that the answer is unique.
	 */

	@Test
	public void example1() {
		String s= "abbaca";
		String output = "ca";
		System.out.println(removeDuplicate(s));
	}

	@Test
	public void example2() {
		String s= "azxxzy";
		String output = "ay";
		System.out.println(removeDuplicate(s));
	}
	
	@Test
	public void example3() {
		String s= "azxbzy";
		System.out.println(removeDuplicate(s));
	}
	
	@Test
	public void example4() {
		String s= "a";
		System.out.println(removeDuplicate(s));
	}

	private String removeDuplicate(String s) {
		if(s.length()<2) return s;
		
		Stack<Character> stack = new Stack<Character>();

		for (int j = 0; j < s.length(); j++)
			if(stack.isEmpty()) stack.push(s.charAt(j));
			else if(stack.peek() == s.charAt(j)) stack.pop();
			else stack.push(s.charAt(j));
		
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) sb = sb.append(stack.pop());
		return sb.reverse().toString();
	}
}