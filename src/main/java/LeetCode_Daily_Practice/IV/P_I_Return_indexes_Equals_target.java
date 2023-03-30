package LeetCode_Daily_Practice.IV;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_I_Return_indexes_Equals_target {
    /*
    Given a array of nos, return the nos whose sum equal to target
int[] arr = {1,5,3,2,4,7,8,10}
int target = 10
output = 3,7 2,8
     */

    @Test
    public void ex() {
        int[] arr = {1, 5, 3, 2, 4, 7, 8, 10};
        int target = 10;
        //Assert.assertEquals(findPairs(arr, target), new ArrayList<>(new int[][]{{3,7},{2,8}}));
    }

    public static List<String> findPairs1(int[] arr, int target) {
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target)
                    pairs.add(arr[i] + "," + arr[j]);
            }
        }
        return pairs;
    }

    //O(nlogn)
    public static List<String> findPairs(int[] arr, int target) {
        List<String> pairs = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target)
                pairs.add(arr[left++] + "," + arr[right--]);
            else if (sum < target) left++;
            else right--;
        }
        return pairs;
    }

}
