package Stack;

import java.util.Stack;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CanonicalPath {
	@Test
	public void example1() {
		String str = "/a/./b/../../c/";
		Assert.assertTrue(findPath(str).equals("/c"));
	}

	@Test
	public void example2() {
		String str = "/home//foo";
		Assert.assertTrue(findPath(str).equals("/home/foo"));
	}

	@Test
	public void example3() {
		String str = "/../";
		Assert.assertTrue(findPath(str).equals("/"));
	}

	/*
	 *  Split the string by /
		traverse through each string
			empty or dot -> ignore
			.. -> pop
			else -> push
		convert the stack by appending
	 */

	private String findPath(String str) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String[] ch = str.split("/");

		for (int i = 0; i < ch.length; i++) {
			if(ch[i].equals("") || ch[i].equals(".")) continue;
			else if(ch[i].equals("..")) {
				if(!stack.isEmpty())
					stack.pop();
			}else stack.push(ch[i]);
		}

		if(stack.isEmpty()) sb.insert(0, "/");

		while(!stack.isEmpty()) {
			sb=sb.insert(0, stack.pop());
			sb=sb.insert(0, "/");
		}
		return sb.toString();
	}
}