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

    /*
1. start iterating from i=0
2. get the first prod value
3. check the product value is >= k
4. if >= k value means divide the prod value from first index
5. and get the count for every iteration
     */

    private int SubArrayProd(int[] w, int target){
        if(w.length<2 && w[0]<target) return 1;
        int count=0, prod=1, ni=0;
        for(int i=0; i<w.length; i++){//O(n)
            prod=prod*w[i];//no of iteration increase by prod

//            while(prod>=target)
//                prod=prod/w[ni++];
//            count=count+i-ni+1;

            if(prod<target)
                count+=i-ni+1;
            else{
                while(prod>=target)
                    prod=prod/w[ni++];
                count+=i-ni+1;
            }
        }
        return count;
    }

    //self
    private int SubArrayProdBF(int[] w, int k){
        if(w.length<2 && w[0]<k) return 1;

        int left=0, len= w.length, right=len, count=0, sum=1, leftIndex=1;

        while(left<w.length && right>0){
            while(right<=w.length){

                while(left<right && sum<k) sum=sum*w[left++];

                if(sum<k) count++;

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
