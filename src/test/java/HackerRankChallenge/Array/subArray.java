package HackerRankChallenge.Array;

import org.testng.annotations.Test;

public class subArray {

	@Test
	public void subArray() {
		//hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=false
int k=5;
		int[] a = {1, -2, 4, -5, 1};
		int sum=0, count=0;
		for(int i=0; i<k; i++) {
			for(int j=i; j<k; j++) {
				sum+=a[j];
				if(sum<0) count++;
			}
			sum=0;
		}
		System.out.println(count);
	}
}
