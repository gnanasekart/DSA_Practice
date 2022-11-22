package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.testng.annotations.Test;

public class StringDecode {
	/*
	 * DS: Stack and ArrayList
		1. Create Empty stack
		2. convert string to char array
		3. loop each char (until it reaches the closing bracket)
			a. pop from the stack
			b. Add to the arraylist
			c. when you notice the opening bracket -> next char is freq
			d. check if it is a digit -> append the same string to list
			e. Reverse the string and push back to the stack
		4. Repeat the step 3 until stack is empty

	    ab(3c) = bbccc
		a3(bc2(d)) = abcddbcddbcdd
		3(ab) = ababab
		2d(3(a)) = daaadaaa
	 */

	@Test
	public void example1() {
		String s = "3[a2[bc]]";//abcbcbcabcbcbcabcbcbc
		System.out.println(decoding(s));
	}

	@Test
	public void example2() {
		String s = "ab[3[c]]";//abccc
		System.out.println(decoding(s));
	}

	@Test
	public void example3() {
		String s = "2[ab]";//abab
		System.out.println(decoding(s));
	}

	@Test
	public void example4() {
		String s = "2[a3[b]]";//abbbbabbbb
		System.out.println(decoding(s));
	}

	@Test
	public void example5() {
		String s = "2[a3[bc]]";//abcbcbcbcabcbcbcbc
		System.out.println(decoding(s));
	}
	
	@Test
	public void example6() {
		String s = "2[b3[c]]";//bccccbcccc
		System.out.println(decoding(s));
	}

	private String decoding(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		List<Character> list = new ArrayList<Character>();

		for(int i=0; i<ch.length; i++) {
			if(ch[i] != ']'){
				stack.push(ch[i]);
			}else {
				while(stack.peek() != '[')
					list.add(stack.pop());
				//pop the next char -> third id opening bracket
				stack.pop();

				//get the frequency
				int k=1;
				if(!stack.isEmpty() && Character.isDigit(stack.peek())){
					k=Character.getNumericValue(stack.pop());
					while(!stack.isEmpty() && Character.isDigit(stack.peek()))
						k= k + Character.getNumericValue(stack.pop()) * 10;
				}

				while(k>0){
					for(int j=list.size()-1; j>=0; j--)
						stack.push(list.get(j));
					k--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb = sb.append(stack.pop());
		//System.out.println(sb.reverse().toString());
		return sb.reverse().toString();
	}
}