package SlidingWindow;

import org.junit.Test;

public class MaxSum {
    
    @Test
    public void example1() {
        int[] arr = { 1, 5, 2, 3, 7, 1 };
        int subarr = 3;
        slidingWindow(arr, subarr);
    }

   // @Test
    public void example2() {
        int[] arr = { 1, -5, 2, 3, 0, 1 };
        int subarr = 3;
        slidingWindow(arr, subarr);
    }

    @Test
    public void example3() {
        int[] arr = {8, 4, 2, 3, 11, 15, 2, 1};
        int subarr = 2;
        slidingWindow(arr, subarr);
    }

    private void slidingWindow(int[] arr, int k) {
        int max=0, newmax=0;

        for(int i=0; i<k; i++){
            newmax+=arr[i];
        }
        max = newmax;

        for(int i=k; i<arr.length; i++){
            newmax = newmax - arr[i-k] + arr[i];
            max = Math.max(max, newmax);
        }
        
        System.out.println(max);
    }
}
