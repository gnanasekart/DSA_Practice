package SlidingWindow;

import org.junit.Test;

public class ExactSum {

    @Test
    public void example1() {

        int[] arr = { 1, 7, 4, 3, 1, 2, 1, 5, 1 };
        int sum = 7;
        classicalSlidingWindow(arr, sum);
    }

    @Test
    public void example2() {

        int[] arr = { 1, 5, 2, 3, 7, 1 };
        int sum = 3;
        classicalSlidingWindow(arr, sum);
    }

    /*
     * Technics
     * - start with first element
     * - If the sum is less than the desired sum, slide to the next element(grow)
     * - Again, sum that and check if it is lesser, equal or greater
     * - If it is lesser, the next element to slide(grow)
     * - If it is greater, than shrink the last element on the left(shrink)
     * - If it is equal, you got it and again do both grow and shrink(slide)
     */
    //time - O[n]
    //space - O[1]
    private void classicalSlidingWindow(int[] arr, int k) {
        int left = 0, sum = 0;
        for(int right=0; right<arr.length; right++){
            sum += arr[right];
            while(sum > k){
               sum -= arr[left++];
            }
            if(sum == k){
                System.out.println(left+", "+right);
            }
        }
    }
}