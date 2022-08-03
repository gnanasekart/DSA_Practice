package basicPractice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RemoveTargetArray {

	/*
	 * Given the integer array and the target, 
	 * Remove the matching target from the array
	 * 
	 */
	
	
	@Test //+ve
	public void example1() {
		int[] nums = {2, 3, 4, 5, 4, 6};
		int target = 4;
		BruteForce_removeTarget1(nums, target);
	}
	
	//@Test //edge
	public void example2() {
		int[] nums = {2};
		int target = 4;
		BruteForce_removeTarget(nums, target);
	}
	
	//@Test //-ve
	public void example3() {
		int[] nums = {2, 3, -4, 0, 5, 4, 6};
		int target = 4;
		BruteForce_removeTarget(nums, target);
	}
	
	/*
	 * Psuedo code
	 * 1. get the integer array and the target value
	 * 2. get the element in for loop
	 * 3. If the target element matches means remove from array
	 * 4. if does not match means continue
	 * 5. return the value 
	 * 
	 */
	
	private void BruteForce_removeTarget(int[] nums, int target) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) == target) {
				list.remove(i);
			}else{
				continue;
			}
		}
		System.out.println(list);
	}
	
	private void BruteForce_removeTarget1(int[] nums, int target) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != target) {
				list.add(nums[i]);
			}
		}
		System.out.println(list);
	}
	
	
}
