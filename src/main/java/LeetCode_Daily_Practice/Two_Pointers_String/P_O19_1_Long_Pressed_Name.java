package LeetCode_Daily_Practice.Two_Pointers_String;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O19_1_Long_Pressed_Name {

    /*
    leetcode.com/problems/long-pressed-name/
Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that
it was your friends name, with some characters (possibly none) being long pressed.
Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.
    */

	@Test
	public void example1() {
		String name = "alex";
		String typed = "aaleex";
		Assert.assertEquals(longPress(name, typed), true);
	}

	@Test
	public void example2() {
		String name = "saeed";
		String typed = "ssaaedd";
		Assert.assertEquals(longPress2(name, typed), false);
	}

	@Test
	public void example3() {
		String name = "saeed";
		String typed = "saaeeed";
		Assert.assertEquals(longPress(name, typed), true);
	}

	@Test
	public void example4() {
		String name = "saeed";
		String typed = "s";
		Assert.assertEquals(longPress(name, typed), false);
	}

	@Test
	public void example5() {
		String name = "sad";
		String typed = "ssaadd";
		Assert.assertEquals(longPress(name, typed), true);
	}

	@Test
	public void example6() {
		String name = "alex";
		String typed = "aaleexa";
		Assert.assertEquals(longPress3(name, typed), false);
	}

	@Test
	public void example7() {
		String name = "alex";
		String typed = "aaleexeex";
		Assert.assertEquals(longPress3(name, typed), false);
	}

	@Test
	public void example8() {
		String name = "alex";
		String typed = "aaleelx";
		Assert.assertEquals(longPress2(name, typed), false);
	}
/*
- check condition name is <= typed means return true
- also check if both char array last length != then return false
- consider two pointer for both the array
- if both the first i values and typed i+1 values matches
	- we count the occurrence and increment typed pointer
	   - if again count more than 2 then return false
	- else increment both pointer
- check if char increment stopped
	- if both increment not reach end return false
	- else return true
*/

	//mine
	private boolean longPress(String name, String typed){
		if(name.length() <= typed.length()/2) return true;
		boolean isLongPressed=false;
		char[] n=name.toCharArray();
		char[] t=typed.toCharArray();

		if(n[n.length-1] != t[t.length-1]) return false;

		int left=0, right=0, count=0;
		while(left<n.length && right<t.length){
			count=0;
			if(n[left]==t[right]){
				count++;
				isLongPressed=true;
				if(count>2)
					return true;
				left++;
			}
			right++;
		}
		if(left<name.length() && right==typed.length())
			return false;
		else return isLongPressed;
	}

	private boolean longPress2(String name, String typed) {
		if (name.charAt(0) != typed.charAt(0)) return false;

		char[] n = name.toCharArray();
		char[] t = typed.toCharArray();

		int left = 1, right = 1, count = 0;
		while (left < t.length) {
			count = 0;
			if (n[left] == t[right]) {
				count++;
				if (count > 2) {
					return true;
				}
				left++;
				right++;
			} else if (t[right]==t[right-1]) {
				right++;
			}
			return false;
		}
		return right==name.length();
	}

	//best solution
	private boolean longPress3(String name, String typed){
		int left=0, right=0;
		while(left<name.length() && right<typed.length()){
			if(name.charAt(left) == typed.charAt(right)){
				left++;
				right++;
			} else if (right==0 || typed.charAt(right) != typed.charAt(right-1)) {
				return false;
			}
			right++;
		}
		return left==name.length();
	}

	//best solution
	private boolean longPress4(String name, String typed){
		if(name.length()>typed.length()) return false;
		int i=0; int j=0;
		while(i<name.length() && j<typed.length()){
			if(name.charAt(i)==typed.charAt(j)){
				i++;
				j++;
			}
			else if(i>0 && name.charAt(i-1)==typed.charAt(j)) j++;
			else return false;
		}

		while(j<typed.length()){
			if(name.charAt(i-1)!=typed.charAt(j)) return false;
			j++;
		}
		return i==name.length();
	}
}

