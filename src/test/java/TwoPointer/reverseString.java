package TwoPointer;

import org.junit.Test;

public class reverseString {

	@Test
	public void example() {
		String s = "hello";
		//reverseString(s);
		reverseString2Pointer(s);
	}

	private void reverseString(String s) {
		char ch[] = s.toCharArray();		//memory copy
		for(int i=ch.length-1; i>=0; i--) { //O[n]
			System.out.print(ch[i]);
		}
	}
	
	private void reverseString2Pointer(String s) {
		char ch[] = s.toCharArray();
		int right=ch.length-1, left=0;
		
		while(left<right) {		//O[n] or O[n/2]
			char temp = ch[right];
			ch[right--]=ch[left];
			ch[left++]=temp;
			System.out.println(temp);
		}
		System.out.println(new String(ch));
		
	}
}
