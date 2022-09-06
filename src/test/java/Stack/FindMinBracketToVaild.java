package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.testng.annotations.Test;

public class FindMinBracketToVaild {

	@Test
	public void example1() {
		String s = "{";
		Assert.assertEquals(findMinValid(s), 1);
	}
	
	@Test
	public void example2() {
		String s = "{})}";
		Assert.assertEquals(findMinValid(s), 2);
	}
	
	@Test
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
}