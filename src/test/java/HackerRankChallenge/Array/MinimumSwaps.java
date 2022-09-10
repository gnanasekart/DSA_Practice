package HackerRankChallenge.Array;

import org.testng.annotations.Test;

public class MinimumSwaps {
	
	@Test
	public void miniSwap() {
		int[] arr = {4,3,1,2};
		
		int i =0;
        int count=0;
        int temp;
        int  n = arr.length;
        while(i<n){
            if(arr[i] != i+1){
                temp = arr[i];
                arr[i] = arr[temp-1];
                arr[temp-1]=temp;
                count++;
            }
            else{
                i++;
            }
        }
        System.out.println(count);
	}
}