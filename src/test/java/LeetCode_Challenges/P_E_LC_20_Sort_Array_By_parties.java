package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_20_Sort_Array_By_parties {

    @Test
    public void example1(){
        int[] arr = {3,1,2,4};
        Assert.assertEquals(addTwo(arr), new int[]{2,4,3,1});
    }

    @Test
    public void example3(){
        int[] arr = {2,4,6,5};
        Assert.assertEquals(addTwo(arr), new int[]{2,4,6,5});
    }

    @Test
    public void example2(){
        int[] arr = {0};
        Assert.assertEquals(addTwo(arr), new int[]{0});
    }

    @Test
    public void example4(){
        int[] arr = {3,1,2,2};
        Assert.assertEquals(addTwo(arr), new int[]{2,2,3,1});
    }

    @Test
    public void example5(){
        int[] arr = {1,1,1,1};
        Assert.assertEquals(addTwo(arr), new int[]{1,1,1,1});
    }
    /*
    logic
    1. create a new array with same size
    2. consider two loop
    3. first loop add the value which is even
    4. second for loop add the odd value
    5. return newly created array
     */

    private int[] addTwo(int[] arr) {
        if(arr.length==0) return new int[]{0};

        int j=0;
        int[] a = new int[arr.length];
       
           for (int i = 0; i < arr.length; i++)
               if (arr[i] % 2 == 0) a[j++] = arr[i];

           for(int i=0; i<arr.length; i++)
               if (arr[i] % 2 != 0) a[j++] = arr[i];
        return a;
    }
}

