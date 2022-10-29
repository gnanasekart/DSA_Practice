package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assessment2solution {

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    logic-
            1. consider two pointer left and right
2. left will be slow pointer and right will be fast pointer
3. right will sum with left pointer and match with target
4. if match with target then return left+1 and right+1
            5. else right increment until array length
6. left increment for every right loop complete

*/
    @Test
    public void example1(){
        int[] n ={2,7,11,15};
        int target=9;
        Assert.assertEquals(targetSum(n, target), new int[]{1,2});
    }

    @Test
    public void example2(){
        int[] n ={2,3,4};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{1,3});
    }

    @Test
    public void example3(){
        int[] n ={-5,-2, 0, 1,5};
        int target=-10;
        Assert.assertEquals(targetSum(n, target), new int[]{1,5});
    }

    @Test
    public void example4(){
        int[] n ={-5,-4,-3,-2,-1};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{2,4});
    }

    @Test
    public void example5(){
        int[] n ={1,2,3,4,5,6,7,8,9};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{1,5});
    }

    @Test
    public void example6(){
        int[] n ={1,2,3,4,5,6,7,8,9};
        int target=6;
        Assert.assertEquals(targetSum(n, target), new int[]{1,5});
    }

    public int[] targetSum(int[] num, int target) {

        int[] arr = new int[2];
        int  left=0, right=num.length-1;
        int sum=0;
        while(left<right) {
                sum = num[left] + num[right];

                if (sum > target) right--;
                else if (sum == target) {
                    arr[0] = left + 1;
                    arr[1] = right + 1;
                    break;
                } else left++;
            }
        return arr;
    }
}
