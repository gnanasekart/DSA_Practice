package basicPractice;

import java.util.Arrays;

import org.junit.Test;

public class moveZeroToRight {

	@Test
	public void example1() {
		int[] value = {3, 0, 4, 5, 0, 0, 1};
		moveZero(value);
	}

	private void moveZero(int[] arr) {
		int left=0, right=0;
		while(right < arr.length) {
			if(arr[right] != 0) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left++] = temp;
				Math.pow(2, 31);
			}
			right++;
			//System.out.println(Arrays.toString(arr));
		}
		System.out.println(Math.pow(2, 31));
	}
}
