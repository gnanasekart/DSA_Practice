package Stack;

import java.util.Stack;

import org.testng.annotations.Test;

public class RemoveOuterParanthesis {

	@Test
	public void example1() {
		String str = "(()())(())";
		System.out.println(removeOuter(str));
	}
	
	@Test
	public void example2() {
		String str = "(()())(())(()(()))";
		System.out.println(removeOuter(str));
	}

	public String removeOuter(String s){
		char[] charr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack();
		for(char ch: charr){
			if(ch=='(')
			{
				if(stack.size()>=1) {
					sb.append(ch);
				}
				stack.push(ch);
			}
			else{
				if(stack.size()>1) {
					sb.append(ch);
				}
				stack.pop();
			}
		}
		return sb.toString();
	}
}