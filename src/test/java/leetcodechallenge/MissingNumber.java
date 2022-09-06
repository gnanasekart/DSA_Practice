package leetcodechallenge;

import java.util.Arrays;

import org.testng.annotations.Test;

public class MissingNumber {

	@Test
	public void example1() {
		int[] num = {1, 0, 2, 4};
		missingNumberWithZero(num);
	}

	private void missingNumberWithZero(int[] num) {
		int result = num.length*(num.length+1)/2 - Arrays.stream(num).sum();
		System.out.println(result);
	}

	//@Test
	public void example2() {
		int[] num = {3,7,5,6};
		missingNumber(num);
	}

	/*
	 * - By programming - O(n)
		- sort the array
		- Lowest number as for loop start point
		- highest number as for loop end point
		compare i value with the array index -> if it does not match -> you found it.
		
		Another way is by finding math formula
		
		example- 
		if number have zero means
		
		input = 4, 2, 0, 1 
		sorted - 0, 1, 2, 4
		missing number is - 3
		
		By formula
		1. when the number start at 0 -> (n(n+1)/2) - sum
		
		2. when the number starts at any other positive number 
		(n(n+1)/2)-(m*m+1)/2 - sum
		
		example
		4, 2, 5, 6
		
		formula - (n(n+1)/2)-(m*m+1)/2
		n=6(last index number), m=1(starting number -1)
		
		((6*7)/2)-(1*(1+1))/2
		21 - 1 = 20 - sum(4+2+5+6)
		20 - 17 = 3
	 */
	
	private void missingNumber(int[] num) {
		
	}
}
