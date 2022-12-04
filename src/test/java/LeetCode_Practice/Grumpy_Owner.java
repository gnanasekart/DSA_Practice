package LeetCode_Practice;

import org.testng.annotations.Test;

public class Grumpy_Owner {
	/*

	There is a bookstore owner that has a store open for n minutes. Every minute, 
	some number of customers enter the store. You are given an integer array customers of length n 
	where customers[i] is the number of the customer that enters the store at the start of the ith minute and
	 all those customers leave after the end of that minute.

	On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 
	if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

	When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

	The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, 
	but can only use it once.

	Return the maximum number of customers that can be satisfied throughout the day.

	Example 1:

	Input: customers = [1,0,1,2,1,1,7,5],
			  grumpy = [0,1,0,1,0,1,0,1], minutes = 3
	Output: 16
	Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
	The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
	 */

	@Test
	public void example1() {
		int[] customers= {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int min=3;
		//grumpyStore_SlidingWindow(customers, grumpy, min);
		grumpyStore_TwoPass(customers, grumpy, min);
	}

	@Test
	public void example2() {
		int[] customers= {1,2,7};
		int[] grumpy = {0,1,0};
		int min=2;
		//grumpyStore_TwoPass(customers, grumpy, min);
	}

	@Test
	public void example3() {
		int[] customers= {1};
		int[] grumpy = {0};
		int min=1;
		//grumpyStore(customers, grumpy, min);
	}

	private void grumpyStore_TwoPass(int[] customers, int[] grumpy, int min) {
		int currentCustomer=0, maxCustomer=0;
		
		for (int i = 0; i < grumpy.length; i++) {
			if(grumpy[i]==0)
				currentCustomer += customers[i];
		}
		maxCustomer = currentCustomer;
		
		for (int i = 0; i < min; i++) {
			if(grumpy[i]==1)
				currentCustomer += customers[i];
		}
		
		maxCustomer = Math.max(maxCustomer, currentCustomer);
		
		for (int i = min; i < grumpy.length; i++) {
			if(grumpy[i-min] == 1) currentCustomer -= customers[i-min];
			if(grumpy[i] == 1) currentCustomer += customers[i];
			
			maxCustomer = Math.max(maxCustomer, currentCustomer);
		}
		System.out.println(maxCustomer);
	}

	private int grumpyStore_SlidingWindow(int[] customers, int[] grumpy, int min) {
		int happyCustomer=0, maxChanges=0, currentChanges=0;
		for (int i = 0; i < grumpy.length; i++) {

			if(grumpy[i] == 0) happyCustomer += customers[i];
			if(grumpy[i] == 1) currentChanges += customers[i];
			if(i>=min && grumpy[i-min]==1) currentChanges -= customers[i-min];
			maxChanges=Math.max(currentChanges, maxChanges);
		}
		return happyCustomer+maxChanges;
	}

}
