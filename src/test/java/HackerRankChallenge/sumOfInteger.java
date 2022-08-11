package HackerRankChallenge;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class sumOfInteger {
	    /*
	     * Complete the 'simpleArraySum' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts INTEGER_ARRAY ar as parameter.
	     */

	    public static int simpleArraySum(int[] ar) {
			int sum=0;
	    	for (int i = 0; i < ar.length; i++) {
				sum+=ar[i];
			}
	    	System.out.println(sum);
	    	
	    	return 0;
	    

	    }

	
	    public static void main(String[] args) throws IOException {
	       int[] ar = {1, 2, 3, 4, 5, 6};

	        int result = sumOfInteger.simpleArraySum(ar);

	      
	    }
	}