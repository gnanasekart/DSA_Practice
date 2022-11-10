package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_M__O28_Longest_Subarray_of_1_After_Deleting_One_Ele {
    /*
leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's
in the resulting array. Return 0 if there is no such subarray.

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
*/

    @Test
    public void example1(){
        int[] num={1,1,0,1};
        Assert.assertEquals(longestSubarrayone(num), 3);
    }

    @Test
    public void example2(){
        int[] num={0,1,1,1,0,1,1,0,1};
        Assert.assertEquals(longestSubarrayone(num), 5);
    }

    @Test
    public void example3(){
        int[] num={1,1,1};
        Assert.assertEquals(longestSubarrayoneSD(num), 2);
    }

    @Test
    public void example4(){
        int[] num={1};
        Assert.assertEquals(longestSubarrayone(num), 0);
    }

    @Test
    public void example5(){
        int[] num={0,0,0,0};
        Assert.assertEquals(maXOneSlidingWindow(num), 0);
    }

    @Test
    public void example6(){
        int[] num={0,0,1,0,0};
        Assert.assertEquals(maXOneSlidingWindow(num), 1);
    }

/*
Brute force
1. A single loop start from 0 to array length
2. if i value is 1 then getting the count
3. if i value is 0 for first time then decrementing 0 value
4. if reaching to the second zero value then exit the loop

*/

    //mine - debug
    private int longestSubarrayone(int[] num){
        int count=0, left=0, right=0, max=Integer.MIN_VALUE;
        int zero=1;
        if(num.length==1) return 0;

        for(left=0; left<num.length; left++) {
            count=0;
            zero = 1;
            for(right=left; right<num.length; right++) {
                if (num[right] == 0) {
                    if (zero > 0) {
                        zero--;
                    } else {
                        max =count>max?count:max;
                        count = 0;
                        zero = 1;
                    }
                } else if (num[right] == 1) {
                    count++;
                    max =count>max?count:max;
                }
            }
        }

        if(num.length==max) return max-1;
        else return max;
    }

    //sliding window
    private int longestSubarrayoneSD(int[] num){
        int max = Integer.MIN_VALUE;
        int k=1;
        for (int i = 0, left = 0; i < num.length; i++) {
            if (num[i] == 0) k--;

            while (k < 0) {
                if (num[left] == 0)
                    k++;
                left++;
            }
            max = Math.max(max, i - left);
        }
        return max;
    }

    public int maXOneSlidingWindow(int[] num){
        int left=0, right=0, k=1;
        while(right<num.length){
            k-=(num[right++]==0)?1:0;

            if(k<0) k+=(num[left++]==0)?1:0;
        }
        return right-left-1;
    }

}
