package Codility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_I_Smallest_Number {
    /*
    Write a function in java:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
     */

    @Test
    public void ex1(){
        int[] a = {1, 3, 6, 4, 1, 2};
        Assert.assertEquals(solution(a), 5);
    }

    @Test
    public void ex2(){
        int[] a = {1,2,3};
        Assert.assertEquals(solution(a), 4);
    }

    @Test
    public void ex3(){
        int[] a = {-1, -3};
        Assert.assertEquals(solution(a), 1);
    }

        public int solution(int[] A) {
            // Step 1: Create a boolean array of length N+1 and initialize all elements to false
            boolean[] present = new boolean[A.length + 1];

            // Step 2: Traverse the input array and mark the elements present in the boolean array
            for(int i=0; i<A.length; i++) {
                if(A[i] > 0 && A[i] <= A.length) {
                    present[A[i]] = true;
                }
            }

            // Step 3: Traverse the boolean array and return the index of the first false element
            for(int i=1; i<present.length; i++) {
                if(!present[i]) {
                    return i;
                }
            }

            // Step 4: If all elements are present, return N+1
            return A.length + 1;
        }
}
