package LeetCode_Daily_Practice.IV;

import org.testng.annotations.Test;

import java.util.Arrays;

public class P_I_Max_Product_Of_Three_Number {

    int[] arr = {3, 5, 8, 1, 2, 0, 6, 4};
    int[] out = {5, 6, 8};

    //Product of 3 numbers which will return max product. We need to return those numbers
    @Test
    public void main() {
        int[] arr = {3, 5, 8, 1, 2, 0, 6, 4};

        int[] arr1 = {};

        Arrays.sort(arr);
        System.out.println(arr);
        int[] prod = new int[3];
        int last = arr.length - 1;

        int p1 = arr[0] * arr[1];
        int p2 = arr[last - 1] * arr[last - 2];

        if (p1 > p2) {
            prod[0] = arr[0];
            prod[1] = arr[1];
        } else if (p2 > p1) {
            prod[0] = arr[last - 1];
            prod[1] = arr[last - 2];
        }
        prod[2] = arr[last];
    }

    @Test
    public void test1() {
        int max = Integer.MIN_VALUE, prod = 1;
        int[] arr = {3, 5, -6, 1, 2, 0, -8, 4};
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] >= 0 && arr[j] >= 0 && arr[k] >= 0) {
                        prod = arr[i] * arr[j] * arr[k];
                        max = prod > max ? prod : max;
                    }
                }
            }
        }
    }
}
