package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_13_Guess_Num_Hgher_Lower {
    //https://leetcode.com/problems/guess-number-higher-or-lower/

    @Test
    public void example1(){
        Assert.assertEquals(guessNumber2(10), 6);
    }
    @Test
    public void example2(){
        Assert.assertEquals(guessNumber(2), 1);
    }
    @Test
    public void example3(){
        Assert.assertEquals(guessNumber(1), 1);
    }

    @Test
    public void example4(){
        Assert.assertEquals(guessNumber(45678), 45);
    }

    private int guessNumber(int n) {
        int first=0, end=n, mid=0;
            if(n==1) return n;
        while(first<=end){
            mid=first+(end-first)/2;
            if(guess(mid)==-1) end=mid-1;
            else if (guess(mid)==1) first=mid+1;
            else break;
        }
    return mid;
    }

    private int guessNumber1(int n) {
        int first=0, end=n, mid=0;
        if(n==1) return n;
        while(first<=end){
            mid=(first+end)/2;
            if(guess(mid)==-1) end=mid-1;
            else if (guess(mid)==1) first=mid+1;
            else break;
        }
        return mid;
    }

    //ternary search
    public int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    public int guess(int num){
        int pick=6;
        if(num>pick) return -1;
        else if (num<pick) return 1;
        else return 0;
    }
}
