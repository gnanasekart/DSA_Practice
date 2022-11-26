package Stack;

import java.util.Scanner;
import java.util.Stack;

import org.junit.Assert;
import org.testng.annotations.Test;

public class FindMinBracketToVaild {

	//@Test
	public void example1() {
		String s = "{";
		Assert.assertEquals(findMinValid(s), 1);
		//findMinValid1();
	}

	@Test
	public void example2() {
		String s = "{})}";
		Assert.assertEquals(findMinValid(s), 2);
	}

	@Test
	public void example5() {
		String s = "()";
		Assert.assertEquals(findMinValid(s), true);
	}
	//@Test
	public void example3() {
		String s = "))";
		Assert.assertEquals(findMinValid(s), 2);
	}

	private Object findMinValid(String s) {
		//		Map<Character, Character> map = new HashMap<Character, Character>();
		//		map.put('}', '{');
		//		map.put(')', '(');
		//		map.put(']', '[');
		//		Stack<Character> stack = new Stack<Character>();
		//		
		//		char[] ch = s.toCharArray();
		//		for (int i = 0; i < ch.length; i++) {
		//			if(stack.isEmpty()) 
		//				stack.push(ch[i]);
		//			else if(map.containsKey(ch[i]) && stack.peek() == map.get(ch[i])) 
		//				stack.pop();
		//			else stack.push(ch[i]);
		//		}
		//return stack.size();

		char[] ch = s.toCharArray();
		int open=0, closed=0;
		for(char c: ch) 
			if(c == '(' || c == '[' || c == '{') open++;
			else closed++;
		return Math.abs(closed-open);
	}

	@Test
	private void findMinValid1() {
		/*
		 * input
{}()
({()})
{}(
[]

output
true
true
false
true
		 */
		Scanner sc = new Scanner(System.in);
		Stack<Character> st= new Stack<>();
		while (sc.hasNext()) {
			String input=sc.next();
			st.clear();
			boolean pass = true;
			for (Character c : input.toCharArray()) {
				if(c=='(') st.push(')');
				else if(c=='[') st.push(']');
				else if(c=='{') st.push('}');
				else if(st.isEmpty()) pass = false;
				else if(st.pop()!=c) pass = false;
			}
			if (!st.isEmpty()) pass = false;
			System.out.println(pass);
		}
	}
}
