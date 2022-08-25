package basicPractice;

import org.junit.Test;

public class vovelSwap {

	//@Test //O(n/2)
	public void example1() {
		String s = "hello";
		checkVovle2Pointer(s);
	}

	@Test //O(n/2)
	public void example2() {
		String s = "gnanaaeiou";
		checkVovle2Pointer(s);
	}

	//@Test //O(n/2) - best
	public void example3() {
		String s = "aeiou";
		checkVovle2Pointer(s);
	}

	//@Test //O(n) - worst
	public void example5() {
		String s = "abcd";
		checkVovle2Pointer(s);
	}

	public boolean isVovle(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}
		return false;
	}

	private void checkVovle2Pointer(String s) {
		char[] c = s.toCharArray();
		int left=0, right=c.length-1;

		while(left < right) {
			if(isVovle(c[left]) && isVovle(c[right])) {
				char temp = c[left];
				c[left++] = c[right];
				c[right--] = temp;
				break;
			}else if(isVovle(c[right])) left++;
			else right--;
		}
		System.out.println(new String(c));
	}

	//@Test
	public void example4() {
		int[] arr = {3, 0, 4, 5, 0, 0, 1};
		zeroSwap2Pointer(arr);
	}

	private void zeroSwap2Pointer(int[] arr) {
		int left=0, right=1;

		while(left > right) {

			if(arr[right] == 0) {

				int temp = arr[right];
				arr[right++] = arr[left++];
			}
		}
	}
}
