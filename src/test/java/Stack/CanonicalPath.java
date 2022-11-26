package Stack;

import java.util.Stack;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CanonicalPath {
	/*//leetcode.com/problems/simplify-path/
	Given a string path, which is an absolute path (starting with a slash '/')
	to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
In a Unix-style file system,
a period '.' refers to the current directory,
a double period '..' refers to the directory up a level,
and any multiple consecutive slashes (i.e. '//')
are treated as a single slash '/'.
For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory
to the target file or directory
(i.e., no period '.' or double period '..')
Return the simplified canonical path.

Constraints:
1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
	 */

	@Test
	public void example1() {
		String str = "/a/./b/../../c/";
		Assert.assertTrue(findPath(str).equals("/c"));// a,.,b,..,..,c

		String c[] = str.split("/");
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