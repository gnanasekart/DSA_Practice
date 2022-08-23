package basicPractice;

import org.testng.annotations.Test;

public class ArmstrongNumber extends baseTestNG {

	@Test
	public void armstrong() {
		int n = 153;
		int sum= 0;
		int remainder, q;
		int original = n;
		while(n>0) {
			remainder = n%10;
			n = n/10;
			sum+=(remainder*remainder*remainder);
		}
		if(sum == original) System.out.println("correct");
		else System.out.println("wrong");
	}
}
