package leetcodechallenge;

import java.util.Arrays;

import org.junit.Test;

public class sortAndArrange {

    @Test
    public void example1() {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3, n = 3;
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, m, nums2, n);
    }

    @Test
    public void example2() {
        int[] nums1 = { 4, 7, 9 };
        int m = 3, n = 3;
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, m, nums2, n);
    }

    /*
     * 
     *  1, 2, 3
        ^
        L
        
        2, 5, 6
        ^
        R
        
        L = 0, R = 0;
        create new array based on output
        1. we need to traverse both the array even if one ends it iteration
        while(L<m || R<n)
        2. if(n1[L]<n2[R]) => o[i++]=n1[L++];
        3. else if(n1[L]>n2[R]) => o[i++]=n2[R++];
        4. else if(L == m) o[i++]=n2[R++];
        5. else o[i++]=n1[L++]
     */
    private void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = 0, left = 0;
        int index = 0;
        int[] arr = new int[n + m];
        while ((right < m) || (left < n)) {
            if (left == m) {
                arr[index++] = nums2[right++];
            } else if (right == n) {
                arr[index++] = nums1[left++];
            }
            else if (nums1[left] < nums2[right]) {
                arr[index++] = nums1[left++];
            } else {
                arr[index++] = nums2[right++];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}