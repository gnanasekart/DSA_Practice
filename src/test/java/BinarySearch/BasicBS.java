package BinarySearch;

import org.testng.annotations.Test;

import static java.util.Arrays.binarySearch;

public class BasicBS {
    @Test
    public void example1(){
        int[] arr = {2, 5, 7, 11, 12, 17, 22, 27, 31};
        int k=10;
        System.out.println(binary_Search(arr, k));
    }

    @Test
    public void example2(){
        int[] arr = {2, 5, 7, 11, 12, 17, 22, 27, 31};
        int k=17;
        System.out.println(binary_Search(arr, k));
    }

    @Test
    public void example3(){
        int[] arr = {2};
        int k=17;
        System.out.println(binary_Search(arr, k));
    }

    /*
    1. Two pointers: low(0 index), high (n-1 index)
    2. find the mid point(low+high)/2
    3. Check if the value == arr[mid]
    4. a. Matches exactly - return true
       b. No - value is less than expected - move low -> mid+1
               value is high than expected -> move high -> mid-1
    break point - low crosses high
    */

    private boolean binary_Search(int[] arr, int k) {
        int low=0, high=arr.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(arr[mid]==k) return true;
            else if (arr[mid] < k) low=mid+1;
            else high=mid-1;
        }
        return  false;
    }

}
