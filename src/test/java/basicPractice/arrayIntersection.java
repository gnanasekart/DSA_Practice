package basicPractice;

import org.junit.Test;

public class arrayIntersection {

	@Test
	public void example() {
		int[] val1 = {2, 3, 5, 6, 8, 10};
		int[] val2 = {2, 4, 5, 7, 8};
		arrayInter(val1, val2);
	}
	
	@Test
	public void example1() {
		int[] val1 = {2, 3, 5, 6, 8, 10};
		int[] val2 = {2, 3, 5, 6, 8, 10};
		arrayInter(val1, val2);
	}
	
	@Test
	public void example2() {
		int[] val1 = {2, 3, 5, 6, 8, 10};
		int[] val2 = {1};
		arrayInter(val1, val2);
	}

	@Test
	public void example3() {
		int[] val1 = {9, 8, 6, 4, 1, 10};
		int[] val2 = {1, 4, 6, 8, 9};
		arrayInter(val1, val2);
	}
	/*
	intersection of two array in sorted order
	if(left < arr1.length && right < arr2.length)
	if left == right
	   get the intersection value
	   move both left++ and right++
	if left < right
	   move left++
	if left > right
	   move right--
	 * 
	 */

	private void arrayInter(int[] val1, int[] val2) {
		int left = 0;
		int right = 0;
		boolean haveIntersection = false;
		while(left < val1.length && right < val2.length) {
			if(val1[left] == val2[right]) {
				System.out.printf("%1d %n", val1[left]);
				haveIntersection = true;
				left++;
				right++;
			}else if(val1[left] < val2[right]) {
				left++;
			}else right++;
		}
		if(!haveIntersection)
			System.err.println("there is no intersection");
	}
}