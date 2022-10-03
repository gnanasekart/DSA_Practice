package leetcodechallenge;

import org.testng.annotations.Test;

public class First_Unique_Character_in_String {

	@Test
	public void example1() {
		String s = "leetcode";
		System.out.println(FirstUnique(s));
	}
	
	@Test
	public void example2() {
		String s = "loveleetcode";
		System.out.println(FirstUnique(s));
	}
	
	@Test
	public void example3() {
		String s = "aabb";
		System.out.println(FirstUnique(s));
	}

	private int FirstUnique(String s) {
		
		int[] arr = new int[26];
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
		}
		
		System.out.println();
		
		for (int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i) - 'a'] == 1) return i;
		}
		
		return -1;
		
	}
}
