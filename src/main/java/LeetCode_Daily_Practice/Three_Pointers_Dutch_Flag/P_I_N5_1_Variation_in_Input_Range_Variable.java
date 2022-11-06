package LeetCode_Daily_Practice.Three_Pointers_Dutch_Flag;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class P_I_N5_1_Variation_in_Input_Range_Variable {
    /*
    You have an unsorted array of integers and a function
string getCategory(integer), which deterministically returns 1 of three possible strings:
"low", "medium", or "high", depending on the input integer. You need to output an array with
 all the "low" numbers at the bottom, all the "medium" numbers in the middle,
 and all the "high" numbers at the top. This is basically a partial sort.
 Within each category, the order of the numbers does not matter.

For example, you might be give the array [5,7,2,9,1,14,12,10,5,3].
For input integers 1 - 3, getCategory(integer) returns "low", for 4 - 10 it returns "medium,"
and for 11 - 15 it returns "high".

You could output an array (or modify the given array) that
 looks like this: [3,1,2,5,5,9,7,10,14,12]

     */

    @Test
    public void ex1() {
        int[] arr = {5, 7, 2, 9, 1, 14, 12, 10, 5, 3};
        Assert.assertEquals(threePoints(arr), new int[]{3, 1, 2, 5, 5, 9, 7, 10, 14, 12});
    }

    @Test
    public void ex2() {
        int[] arr = {10, 4, 6, 9};
        Assert.assertEquals(threePointsDutchFlag(arr), new int[]{4, 6, 9, 10});
    }

    /*
PseudoCode-
checking condition values
low = 1-3
medium = 4 - 10
high = 11- 15
1.Initialize low=0, middle=0 and high=arr.length-1
2.If the arr[middle] is <= 3, swap middle-low, increment both
3.If the arr[middle] is >=4 && <=10, increment middle
4.If the arr[middle] is >=11 && <=15, swap middle - high , decrement high
5.when middle<=high or when middle > high break loop

     */

    public int[] threePointsDutchFlag(int[] arr) {

        int low = 0, middle = 0, high = arr.length - 1;
        int temp = 0;
        while (middle <= high) {
            if (arr[middle] >= 1 && arr[middle] <= 3) {
                temp = arr[middle];
                arr[middle++] = arr[low];
                arr[low++] = temp;
            } else if (arr[middle] >= 4 && arr[middle] <= 10) {
                middle++;
            } else {
                temp = arr[middle];
                arr[middle] = arr[high];
                arr[high--] = temp;
            }
        }
        System.out.println(arr);
        return arr;
    }

    //not working
    public int[] threePoints(int[] arr) {
        int low=0, middle=0, high=arr.length-1;
        String str="", a="", b="", c="";
        for (int i = 0; i < arr.length; i++) {

            if(arr[i]<=3){
                a+=arr[i]+" ";
            } else if (arr[i]>10) {
                b+=arr[i]+" ";
            }else {
                c+=arr[i]+" ";
            }
        }
        int[] r = Stream.of(a+c+b.trim().split(" "))
                .mapToInt(Integer::parseInt).toArray();
      return r;
    }
}
