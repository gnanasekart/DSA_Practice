package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O15_Parity_Check_Even_Num {

    @Test
    public void example1(){
        int[] arr={3,1,2,4,6,5};
        int[] out={6,4,2,1,3,5};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example2(){
        int[] arr={2,4,6,8};
        int[] out={2,4,6,8};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example3(){
        int[] arr={2,1};
        int[] out={2,1};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example4(){
        int[] arr={1,3,5};
        int[] out={1,3,5};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example5(){
        int[] arr={1};
        int[] out={1};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example6(){
        int[] arr={};
        int[] out={};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

    @Test
    public void example7(){
        int[] arr={1,2,3,4,5,6,6,5,3,3,2,1};
        int[] out={2,2,6,4,6,5,3,5,3,3,1,1};
        Assert.assertEquals(swapTwoPointer(arr), out);
    }

/*
1. take two pointers left and right
2. left is slow mover
3. right pointer will check even values if it is not right--
4. if right is even then swap with left value and right--, left++
5. return array
*/

    private int[] swapTwoPointer(int[] arr){
        if(arr.length<2) return arr;
        int left=0, right=arr.length-1;

        while(left<right){
            if(arr[right]%2==0 && arr[left]%2!=0){
                arr[left]= arr[left]+arr[right];
                arr[right]=arr[left]-arr[right];
                arr[left]=arr[left++]-arr[right--];
            } else if (arr[right]%2 != 0)
                right--;
            else
                left++;
        }
        return arr;
    }
}
