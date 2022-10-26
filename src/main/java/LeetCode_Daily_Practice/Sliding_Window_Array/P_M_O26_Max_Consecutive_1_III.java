package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M_O26_Max_Consecutive_1_III {
/*
    leetcode.com/problems/max-consecutive-ones-iii/
    Given a binary array nums and an integer k, return the maximum
    number of consecutive 1's in the array if you can flip at most k 0's.
*/
    @Test
    public void example1(){
        int[] num={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        Assert.assertEquals(maxOne(num, k), 6);
    }

    @Test
    public void example2(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        Assert.assertEquals(maxOne(num, k), 10);
    }

    @Test
    public void example3(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 4);
    }

    //@Test
    public void example4(){
        int[] num={0,0,1,1,0,1,1,1,0,1,1,0,0,0,1,1};
        int k=3;
        Assert.assertEquals(maxOne(num, k), 4);
    }

    @Test
    public void example5(){
        int[] num={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=8;
        Assert.assertEquals(maxOne(num, k), num.length);
    }

    @Test
    public void example6(){
        int[] num={1,1,1,0,0,0,1,1,1,1,0};
        int k=10;
        Assert.assertEquals(maxOne(num, k), num.length);
    }

    @Test
    public void example7(){
        int[] num={1,1,1};
        int k=1;
        Assert.assertEquals(maxOne(num, k), 3);
    }

    @Test
    public void example8(){
        int[] num={0};
        int k=0;
        Assert.assertEquals(maxOne(num, k), 0);
    }

    @Test
    public void example9(){
        int[] num={0};
        int k=1;
        Assert.assertEquals(maxOne(num, k), 1);
    }

    /*
1. consider first iteration start with i=0 till the array end
2. if i==1 then count the length
3. if i!=1 then change the value, increment count and move next
4. in between if get count zero more than k
5. get the count as max value
6. reset the count and reassign default k value
7. once reaches the end then return the max value
*/




    private int zero, count, max, out;
    public int maxOne(int[] num, int k){

        for(int i=0; i<num.length; i++){
            zero =k;
            for(int j=i; j<num.length; j++){

                if(num[j]==1) {
                    count++;
                    //zero--;
                }
                //else if(num[j]==0 && count>1 && k!=0)

//                }else if(num[j]==0 && zero>0){
//                    num[j]=1;
//                    count++;
//                    zero--;
                }
            }

        return max;
    }


//    private int maxOne1(int[] arr, int k){
//         int i, j, zero, count, max, outOfBox;
//            int[] num = arr.clone();
////        for(int i=0; i<num.length; i++){
//        //zero =k;
//        for(i=0; i<num.length; i++) {
//            //count = 0;
//            zero = k;
//            for (j = i; j < num.length; j++) {
//                if(outOfBox>=k) count=0;
//
//                if (num[j] == 1)
//                    count++;
//               // else if (num[j]==0 && num[j+1]==1 || num[j+1]==1 && num[j]==0) {
//                else if (num[j]==0 && num[j+1]==1 || num[j+1]==1 && num[j]==0) {
//                    if (zero > 0) {
//                        num[j] = 1;
//                        count++;
//                        zero--;
//                    }
//                }else {
//                    outOfBox++;
//                }
//                if (count>max) max=count;
//            }
//        }
//        return max;
//    }
}
