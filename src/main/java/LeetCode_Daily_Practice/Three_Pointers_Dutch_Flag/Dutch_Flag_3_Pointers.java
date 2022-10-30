package LeetCode_Daily_Practice.Three_Pointers_Dutch_Flag;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dutch_Flag_3_Pointers {
    @Test
    public void example1() {
        int[] arr = {1, 2, 0, 1, 2};
        Assert.assertEquals(dutchFlagAscending(arr), new int[]{0, 1, 1, 2, 2});
    }

    @Test
    public void example3() {
        int[] arr = {2,0,2,1,1,0};
        Assert.assertEquals(dutchFlagAscending(arr), new int[]{0,0,1,1,2,2});
    }

    @Test
    public void example6() {
        int[] arr = {0,1,1,2,0};
        Assert.assertEquals(dutchFlagAscending(arr), new int[]{0,0,1,1,2});
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 0, 1, 2};
        Assert.assertEquals(dutchFlagDecending(arr), new int[]{2,2,1,1,0});
    }

    @Test
    public void example4() {
        int[] arr = {2,0,2,1,1,0};
        Assert.assertEquals(dutchFlagDecending(arr), new int[]{2,2,1,1,0,0});
    }

    @Test
    public void example5() {
        int[] arr = {0,1,1,2,0};
        Assert.assertEquals(dutchFlagDecending(arr), new int[]{2,1,1,0,0});
    }

    @Test
    public void example7() {
        int[] arr = {0,0,1,1,0,1,2};
        Assert.assertEquals(dutchFlagDecending(arr), new int[]{2,1,1,1,0,0,0});
    }

    /*
Condition
1.Initialize low=0, middle=0 and high=arr.length-1
2.If the arr[middle] is 0, swap middle and low values and increment both pointer
3.If the arr[middle] is 1, increment middle pointer
4.If the arr[middle] is 2, swap middle and high values and decrement high pointer
5.Break the loop when middle<=high or when middle > high
 */

    private int[] dutchFlagAscending(int[] arr) {
        int low = 0, middle = 0, high = arr.length - 1;
        int temp;
        while (middle <= high) {
            if (arr[middle] == 0) {
                temp = arr[low];
                arr[low++] = arr[middle];
                arr[middle++] = temp;
            } else if (arr[middle] == 1) {
                middle++;
            } else {
                temp = arr[high];
                arr[high--] = arr[middle];
                arr[middle] = temp;
            }
        }
        return arr;
    }

    /*
Condition
1.Initialize low=arr.length-1, middle=arr.length=1 and high=0
2.If the arr[middle] is 2, swap middle and high values and high++ pointer
3.If the arr[middle] is 1, decrement middle pointer
4.If the arr[middle] is 0, swap middle and low values and low--, middle-- pointer
5.Break the loop when high<=middle or when middle > high
 */
    private int[] dutchFlagDecending(int[] arr) {
        int high = 0, middle = arr.length-1, low = arr.length-1;
        int temp;
        while (middle >= high) {
            if (arr[middle] == 2) {
                temp = arr[high];
                arr[high++] = arr[middle];
                arr[middle] = temp;
            } else if (arr[middle] == 1) {
                middle--;
            } else {
                temp = arr[low];
                arr[low--] = arr[middle];
                arr[middle--] = temp;
            }
        }
        return arr;
    }
}
