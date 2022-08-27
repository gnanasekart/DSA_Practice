package SlidingWindow;

import org.junit.Test;

public class LongestOne {
    
    @Test
    public void example1(){
        int[] arr = {1,1,1,0,0,0,1,1,1,0};
        int k = 2;
        longestOne1(arr, k);
    }

    @Test
    public void example2(){
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1};
        int k = 3;
        longestOne1(arr, k);
    }

    /*
     *  Take two points fast moving right=0, slow moving left=0
        if value == 0 then reduce k
        until k < 0 we consumed all the zero flips
        Move the left towards right and stop at next zero
        keep finding the count and find the max
     * 
     */
    private void longestOne1(int[] arr, int k) {
        int left=0, right=0, max=0;

        for(right=0; right<arr.length; right++){
            if(arr[right] == 0){
                k--;
            }

            if(k < 0){
                if(arr[left] == 0){
                    k++;
                }
                left++;
            }
            max = Math.max(max, right-left);
        }
        System.out.println(max);
    }
}
