package HackerRankChallenge;

import java.util.Arrays;
import java.util.Collections;

import org.testng.annotations.Test;

public class MinimumDifferentSum {

	/*
	 * 
	 * Given an array of integers, rearrange them so that the sum of the absolute 
	 * diferences of all adjacent elements is minimized, then compute the sum of those absolute differences.

		n=5;
		arr=[1, 3, 3, 2, 4];

		1, 2, 3, 3, 4 => 
		1-2=1, 
		2-3=1, 
		3-3=0, 
		3-4=1
		1+1+0+1=3
	 */

	@Test
	public void example1() {
		int[] arr = {1, 3, 3, 2, 4};
		System.out.println(findDifferenceAbs(arr));
	}

	@Test
	public void example2() {
		int[] arr = {5, 1, 3, 7, 2};
		System.out.println(findDifferenceAbs(arr));
	}

	@Test
	public void example3() {
		int[] arr = {3, 2};
		System.out.println(findDifferenceAbs(arr));
	}

	private int findDifferenceAbs(int[] arr) {
		if(arr.length<2) return 0;
		else if(arr.length==2) return Math.abs(arr[0] - arr[1]);
		else Arrays.sort(arr);
		int sum=0;
		for (int i = 0; i < arr.length-1; i++) {
			sum+=Math.abs(arr[i+1])-Math.abs(arr[i]);
		}
		return sum;
	}

	private int findDifference(int[] arr) {
		int[] a = new int[arr.length];
		int sum=0;
		if(arr.length>2) Arrays.sort(arr);//1 2 3 3 4
		for(int i=0; i<arr.length-1; i++) {
			a[i]=arr[i+1]-arr[i];
			System.out.println(arr[i+1]+"-"+arr[i]+"="+a[i]);
			sum+=a[i];
		}
		return sum;
	}
}