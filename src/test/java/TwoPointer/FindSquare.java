package TwoPointer;

import java.util.Arrays;
import org.junit.Test;
public class FindSquare {

	/*
	 * Given sorted integer array in non-decreasing order, 
	 * return the array of the squares of each number sorted in non-decreasing order
	 * 
	 */


	@Test //+ve
	public void example1() {
		int[] nums = {2, 3, 4, 4, 5};

		absSqAndSort(nums);
		//Assert.assertEquals(true, Arrays.equals(findSquare_bruteForce(nums), new int[] {4, 9, 16, 16, 25}));
		//Assert.assertEquals(true, findSquare_bruteForce(nums), new int[] {4, 6, 16, 16, 25});
	
	}

	//@Test //edge
	public void example2() {
		int[] nums = {4/2 , 6/3, 9/4, 10/5, 12/6, 13/7, 14/8 };
		findSquare_bruteForce(nums);
	}

	//@Test //-ve
	public void example3() {
		int[] nums = {-4, -2, -1, 0, 2, 4, 5, 7};
		findSquare_bruteForce(nums);
	}

	@Test
	public void example4(){
		int[] nums = {-7, -5, 1, 4, 7};
		absSqAndSort(nums);
	}

	/* pseudo code
	 * 1. take the input array value
	 * 2. traverse every element in the array by for loop
	 * 3. once the square is completed for particular number then continue with another number
	 * 4. collect the element in a list
	 * 5. sort the element in non decreasing order
	 * 6. if the array is empty means return error
	 * 7. Finally, return the list
	 * 
	 */

	private int[] findSquare_bruteForce(int nums[]) {
		for(int i=0; i<nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	

	/*
	 *  1. create a new array of same size and value
		2. left=0, right=len-1;
		3. insertIndex=len-1(bigger no at end)
		4. while(left<=right)
		 a. if left abs is smaller than right abs
		  -> insert the square value of left in the insert index
		 b. else insert the square value of right in the insert index

		 time comp - mixed value - O[n/2]
		 normal value like 1, 2, 3, 4, 5 - O[n]
		 space comp = O[n]
	 */

	//{-7, -5, 1, 4, 7} = {1, 16, 25, 49, 49}
	private void absSqAndSort(int[] nums){
		int left=0, right=nums.length-1;

		int[] arr = new int[nums.length];
		int index = arr.length-1;

		while(left<=right){
			if(Math.abs(nums[left]) < Math.abs(nums[right])){
				arr[index--] = nums[right]*nums[right--];
			}else{
				arr[index--] = nums[left]*nums[left++];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}