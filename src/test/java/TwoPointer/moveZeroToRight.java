package TwoPointer;

import java.util.Arrays;

import org.junit.Test;

public class moveZeroToRight {

	//@Test
	public void example1() {
		int[] value = { 3, 0, 4, 5, 0, 0, 1 };
		moveZero(value);
	}

	@Test
	public void example2() {
		int[] value = { 3, 0, -1, 0, 4, 0, 5, 0, 0, 1 };
		//moveZero(value);
		movezeroOpps(value);
	}

	// maintain position
	//@Test
	private void moveZero(int[] arr) {
		int left = 0, right = 0;
		while (right < arr.length) {
			if (arr[right] != 0) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left++] = temp;
				// Math.pow(2, 31);
			}
			right++;
			// System.out.println(Arrays.toString(arr));
		}
		System.out.println("maintain = "+Arrays.toString(arr));
		// System.out.println(Math.pow(2, 31));
	}

	// non maintain position {3, 0, 4, 5, 0, 0, 1}

	private void movezeroOpps(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] != 0 && arr[right] != 0) {
				left++;
			} else if (arr[right] != 0 && arr[left] == 0) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left++] = temp;
			} else {
				right--;
			}
		}
		System.out.println("non maintain = "+Arrays.toString(arr));
	}
}
