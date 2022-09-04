package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.testng.annotations.Test;

public class ValidateParanthesis {

	@Test
	public void example1() {
		String str="()";
		System.out.println(isValid(str));
	}

	@Test
	public void example2() {
		String str="[]";
		System.out.println(isValid(str));
	}

	@Test
	public void example3() {
		String str="[()]";
		System.out.println(isValid(str));
	}

	@Test
	public void example4() {
		String str="([]) {[(({}))]}";
		System.out.println(isValid(str));
	}

	/*
	 * Algorithm: stack and map

		1. Convert the string into char array
		2. Create a map with key(closing brackets) and value(open brackets)
		3. Loop through each char
			a. check if the char exist in the map as key
				i. Exist: Pop the stack value and compare the map value
				ii. If matches --> continue, else ->> return false;
			b. If the char does not exist -> push to the stack
		4. Finally, return the boolean -> if the stack is empty -> true else false
	 * 
	 */
	private boolean isValid(String str) {
		char[] ch = str.toCharArray();

		Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('}', '{');
			map.put(')', '(');
			map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < ch.length; i++) {
			if(map.containsKey(ch[i])) {
				if(stack.isEmpty() || stack.pop() != map.get(ch[i])) {
					return false;
				}else {
					stack.push(ch[i]);
				}
			}
		}
		if (stack.isEmpty()) return true;
		else return false;
	}
}