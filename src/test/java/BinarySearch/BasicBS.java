package BinarySearch;

import org.testng.annotations.Test;

import static java.util.Arrays.binarySearch;

public class BasicBS {
    @Test
    public void example1() {
        int[] arr = {2, 5, 7, 11, 12, 17, 22, 27, 31};
        int k = 11;
        System.out.println(binary_Search(arr, k));
        System.out.println(binarySearch(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {2, 5, 7, 11, 12, 17, 22, 27, 31};
        int k = 17;
        System.out.println(binary_Search(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {2};
        int k = 17;
        //System.out.println(binary_Search(arr, k));
        System.out.println(binarySearch(arr, k));
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
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) return true;
            else if (arr[mid] < k) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static int binarySearch(int arr[], int value) {
        int start = 0, end = arr.length - 1;
        int middle = (start + end) / 2;
        while (arr[middle] != value && start <= end) {
            if (value < arr[middle]) end = middle - 1;
            else start = middle + 1;
            middle = (start + end) / 2;
        }
        if (arr[middle] == value) return middle;
        else return -1;
    }
}
