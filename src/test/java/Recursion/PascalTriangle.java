package Recursion;

import org.testng.annotations.Test;

public class PascalTriangle {
	
	@Test
	public void example1() {
		pascal(5);
	}

	private void pascal(int k) {
		
		int left=1, right=1;
		
		for(int i=0; i<k; i++) {
			for(int j=i+1; j<k; j++) {
				int[][] arr = new int[i][j];
				if(j==1) {
					arr[i][j] = 1;
				}else if(j > 1) {
					 
				}
			}
		}
		
	}

}
