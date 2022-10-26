package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_O25_Subarray_Prod_Less_Than_K {

    @Test
    public void ex1(){
        int[] w1 = {10,5,2,6};
        int k = 100;
        Assert.assertEquals(SubArrayProd(w1, k), 8);
    }

    @Test
    public void ex2(){
        int[] w1 = {1,2,3};
        int k = 0;
        Assert.assertEquals(SubArrayProd(w1, k), 0);
    }

    @Test
    public void ex3(){
        int[] w1 = {1,1,1,1,1,1};
        int k = 2;
        Assert.assertEquals(SubArrayProd(w1, k), 21);
    }

    @Test
    public void ex4(){
        int[] w1 = {10};
        int k = 100;
        Assert.assertEquals(SubArrayProd(w1, k), 1);
    }

    @Test
    public void ex5(){
        int[] w1 = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        Assert.assertEquals(SubArrayProd(w1, k), 18);
    }

    private int SubArrayProd(int[] w, int target){
        if(w.length<2 && w[0]<target) return 1;

        int k= w.length, right=k-1, left=right-k+1, count=0, sum=1, leftIndex=1;

        while(left<w.length && right>0){
            while(right<=w.length){

                while(left<right && sum<target)
                    sum=sum*w[left++];

                if(sum<target)
                    count++;

                left=leftIndex++;
                right++;
                sum=1;
            }
            leftIndex=1;
            left=0;
            right=--k;
        }
        return count;
    }


    private int SubArrayProd1(int[] w, int k){
        if(w.length<2 && w[0]<k) return 1;

        int left=0, len= w.length, right=len, count=0, sum=1, leftIndex=1;

        while(left<w.length && right>0){
            while(right<=w.length){

                while(left<right && sum<k)
                    sum=sum*w[left++];

                if(sum<k)
                    count++;

                left=leftIndex++;
                right++;
                sum=1;
            }
            leftIndex=1;
            left=0;
            right=--len;
        }
        return count;
    }
}
