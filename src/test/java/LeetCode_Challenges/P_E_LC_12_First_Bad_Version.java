package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_12_First_Bad_Version {
    //leetcode.com/problems/first-bad-version/

    @Test
    public void example1(){
        Assert.assertEquals(badversion(5), 4);
    }

    @Test
    public void example2(){
        Assert.assertEquals(badversion(3), 1);
    }

    @Test
    public void example3(){
        Assert.assertEquals(badversion(0), 0);
    }

    @Test
    public void example4(){
        Assert.assertEquals(badversion(99), 4);
    }

    private int badversion(int n) {
        int first=0, last=n, mid=0;
            while(first<last){
                mid=first+(last-first)/2;
                if(isBadVersion(mid)) {
                    break;
                }else if(mid>n) last=mid-1;
                else first=mid+1;
            }
        return mid;
    }

    private int badversion1(int n) {

        int start = 0;
        int end = n;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid - 1;
                ans = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }

    public boolean isBadVersion(int i){
        if(i==1){
            return true;
        }
        return false;
    }
}
