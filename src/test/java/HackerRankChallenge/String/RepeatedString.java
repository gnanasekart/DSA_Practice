package HackerRankChallenge.String;

import org.testng.annotations.Test;

public class RepeatedString {

	@Test
	public void example1() {
		String s = "abcd";
		int n =10;

		long strLength = s.length();

		// Count the number of 'a' in the given string
		int count = 0;
		for (int i = 0; i < strLength; i++) {
			if (s.charAt(i) == 'a') {
				++count;
			}
		}

		long repeatedTimes = n / strLength;

		// Find the length of string left after repetitions
		long stringLeftLength = n - (strLength * repeatedTimes);

		// Count the remaining repetitions
		int extra = 0;
		for (int i = 0; i < stringLeftLength; i++) {
			if (s.charAt(i) == 'a') {
				++extra;
			}
		}

		long totalCount = (repeatedTimes * count) + extra;

		System.out.println(totalCount);
	}
}
