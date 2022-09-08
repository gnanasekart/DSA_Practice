package leetcodechallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class MedianTwoSortedArr {
	//redquark.org/leetcode/0004-median-of-two-sorted-arrays/
	@Test
	public void example1() {
		double[] nums1 = {1,2};
		double[] nums2 = {3};
		System.out.println(medianNumber(nums1, nums2));
	}

	private double medianNumber(double[] nums1, double[] nums2) {
		List<Double> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) list.add((double) nums1[i]);

		for (int i = 0; i < nums2.length; i++) list.add(nums2[i]);

		Collections.sort(list);
		float sum=0f, count=0f;
		for(int i=1; i<list.size()-1; i++) {
			sum+=list.get(i);
			count++;
		}
		return sum/count;
	}
}