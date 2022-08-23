package basicPractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class baseTestNG {
 
	long startTime;
	long endTime;
	int  letter, space, num, specialChar;
	
	@BeforeMethod
	public void startTimer() {
		letter = 0;
		 space = 0; num = 0; specialChar = 0;
		startTime = System.currentTimeMillis();
	}

	@AfterMethod
	public void endTimer() {
		endTime = System.currentTimeMillis();
		System.out.println("ms = "+(endTime - startTime));
	}

}
