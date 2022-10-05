package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_6_Merge_Sorted_Array {
	//leetcode.com/problems/merge-sorted-array/

	@Test
	public void example2() {
		int[] nums1 = {1};
		int m = 1;
		int[] nums2 = {};
		int n = 0;
		Assert.assertEquals(mergeArray(nums1, m, nums2, n), new int[]{1});
	}

	@Test
	public void example3() {
		int[] nums1 = {0};
		int m = 0;
		int[] nums2 = {1};
		int n = 1;
		Assert.assertEquals(mergeArray(nums1, m, nums2, n), new int[]{1});
	}

	@Test
	public void example4() {
		int[] nums1 = {1, 2, 3, 4, 0, 0};
		int m = 4;
		int[] nums2 = {2, 5};
		int n = 2;
		Assert.assertEquals(mergeArray2(nums1, m, nums2, n), new int[]{1, 2, 2, 3, 4, 5});
	}

	@Test
	public void example1() {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int m = 3;
		int[] nums2 = {2, 5, 6};
		int n = 3;
		Assert.assertEquals(mergeArray2(nums1, m, nums2, n), new int[]{1, 2, 2, 3, 5, 6});
	}

	private int[] mergeArrayBF(int[] nums1, int m, int[] nums2, int n) {
		int[] result;
		if (m == 0 && n == 0) {
			result = nums1;
		}

		if (m == 0) result = nums2;
		else result = nums1;

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m + j; i++) {
				if (nums1[i] == nums2[j]) {
					int t = m - i;
					while (t >= i)
						nums1[t + 1] = nums1[t--];
				} else if (nums1[i] < nums2[j] && nums1[i + 1] == 0)
					nums1[i + 1] = nums2[j];
			}
		}
		return result;
	}

	private int[] mergeArray(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] < nums2[j])
				nums1[i + j + 1] = nums2[j--];
			else
				nums1[i + j + 1] = nums1[i--];
		}
		while (j >= 0)
			nums1[j] = nums2[i--];
		return nums1;
	}

	private int[] mergeArray2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = nums1.length - 1;
		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

		return nums1;
	}


}