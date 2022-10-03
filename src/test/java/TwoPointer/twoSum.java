package TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
public class twoSum {

	/*
	 * Given the input int array, find the sum of any two distinct indices of the matching given the target
	 */

	//@Test  //+ve
	public void example1(){
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		//Assert.assertEquals(true,  Arrays.equals(twoSum_BruteForce(nums, target), new int[] {0, 1}));
		//twoSum_BruteForce(nums, target);
		twoSum_2pointer(nums, target);
		//twoSum_Map(nums, target);
		//output = {0, 1}
	}

	@Test //edge
	public void example2(){
		int nums[] = {2, 2, 3, 1, 4, 0, 5};
		int target = 5;
		//twoSum_BruteForce(nums, target);
		twoSum_Map(nums, target);
	}

	//@Test  //-Ve
	public void example3(){
		int nums[] = {2, 2, 3, 1, 4, 0, 5};
		int target = 45;
		twoSum_BruteForce(nums, target);
	}

	/*
	 * 
	 * Pseudo code

		1. Take the input array
		2. Traverse every element using for loop
		3. Add with the next element with the outer loop
		4. Compare the sum with the target
			- If the matched, store them in a list
			- If it does not match, continue
		5. Finally, return the list.
	 * 
	 * 
	 */

	private int[] twoSum_BruteForce(int[] nums, int target) {
		boolean bMatch = false;
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					System.out.println(i+","+j);
					bMatch = true;
				}
			}
		}

		if(!bMatch)
			throw new RuntimeException("there is no match");
		return nums;
	}

	@Test
	public void example4(){
		int nums[] = {2, 7,11, 15};
		int target = 9;
		//Assert.assertEquals(true,  Arrays.equals(twoSum_2pointer(nums, target), new int[] {0, 1}));
		twoSum_2pointer(nums, target);
		//twoSum_Map(nums, target);
	}

	@org.testng.annotations.Test
	public void example5() {
		int[] num = {3, 2, 4};
		int target = 6;
		twoSum_Map(num, target);
	}
	/*
	 * pseudo code >> this solution works only for ascending order of array.
	 * 1. left -> 0, right -> nums.length-1;
	 * 2. Loop through until left is smaller than right index
	 *   a. sum both left and right index value
	 *    - sum = k => return left and right
	 *    - sum > k => increment left
	 *    - sum < k => decrement right
	 * 
	 */

	private void twoSum_2pointer(int[] nums, int target) {

		int left = 0, right = nums.length-1;
		boolean bFound = false;
		while(left < right) {
			int sum = nums[right] + nums[left];
			if(sum == target) {
				System.out.println(right+" "+left);
				bFound = true;
				break;
			}else if(sum < target) left++;
			else right--;
		}
		if(!bFound)
			throw new RuntimeException("not found matches");
	}

	private int[] twoSum_Map(int[] numbers, int target) {
		int[] res = new int[2];
		Map map = new HashMap();
		for(int i = 0; i < numbers.length; i++){
			map.put(numbers[i], i);
		}
		for(int i = 0; i < numbers.length; i++){
			int gap = target - numbers[i];
			if(map.get(gap)!= null && (int)map.get(gap)!= i){
				res[0] = i;
				res[1] = (int)map.get(gap);
				//break;
				System.out.println(res[0]+" "+res[1]);
			}
		}
		return res;
	}
}
