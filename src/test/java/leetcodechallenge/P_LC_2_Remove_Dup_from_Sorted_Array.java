package leetcodechallenge;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_LC_2_Remove_Dup_from_Sorted_Array {

    //0,0,1,1,1,2,2,3,3,4

    @Test
    public void example1(){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int k = 5;
        Assert.assertEquals(DupArray(arr), k);
    }

    private int DupArray(int[] arr) {
        int left=0, right=1, k=0;
        while(left<arr.length-1 && right<arr.length-1){
            if(arr[left]==arr[right] && arr[right]!=arr[right+1]){
                arr[k++]= arr[right];
                left++;
            } else if (arr[right]!=arr[right+1]) {
                right++;
            }else right++;
        }


        return 0;
    }
}
