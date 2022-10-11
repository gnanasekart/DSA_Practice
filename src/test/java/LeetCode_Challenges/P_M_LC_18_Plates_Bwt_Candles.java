package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_LC_18_Plates_Bwt_Candles {

    //https://leetcode.com/problems/plates-between-candles/

    @Test
    public void example1(){
        String[] arr={"**|**|***|"};
        int[][] query={{2,5}, {5,9}};
        Assert.assertEquals(findPlates(arr, query), new int[] {2,3});
        }


    @Test
    public void example2(){
        String[] arr={"***|**|*****|**||**|*"};
        int[][] query={{1,17}, {4,5}, {14,17}, {5,11}, {15,16}};
        Assert.assertEquals(findPlates(arr, query), new int[] {9,0,0,0,0});
    }

    private Object[] findPlates(Object[] arr, int[][] query) {

    return arr;
    }

}
