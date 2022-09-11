package leetcodechallenge;

import org.testng.annotations.Test;

public class Happy_number {
	/*
	 * Write an algorithm to determine if a number n is happy.

	A happy number is a number defined by the following process:
	Starting with any positive integer, replace the number by the sum of the squares of its digits.
	Repeat the process until the number equals 1 (where it will stay), 
	or it loops endlessly in a cycle which does not include 1.
	Those numbers for which this process ends in 1 are happy.
	Return true if n is a happy number, and false if not.

	Input: n = 19
	Output: true
	Explanation:
	1^2 + 9^2 = 82
	8^2 + 2^2 = 68
	6^2 + 8^2 = 100
	1^2 + 0^2 + 0^2 = 1
	 */

	@Test
	public void example1() {
		int n=19;
		System.out.println(happy(n));
	}

	@Test
	public void example2() {
		int n=2;
		System.out.println(happy(n));
	}

	private boolean happy(int n) {
		if(n<=0) return false;
		while(true) {	
			int sum=0;
			while(n != 0) {
				sum = sum + (n%10) * (n%10);
				n=n/10;
			}
			if(sum/10==0) {
				if(sum == 1 || sum == 7) return true;
				else return false;
			}
			n=sum;
		}
	}
}
