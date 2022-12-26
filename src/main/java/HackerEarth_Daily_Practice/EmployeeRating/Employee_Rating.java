package HackerEarth_Daily_Practice.EmployeeRating;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Employee_Rating {
    //find the longest sub array which is greater than target value
    @Test
    public void ex1(){
        int[] arr = {2,3,7,8,7,6,3,8,12,11,12,10};
        int target = 6;
        Assert.assertEquals(rating(arr, target), 5);
    }

    private int rating(int[] arr, int target) {
        int n = arr.length, result=0, right=0, left=0;

       while(right<arr.length){
            if(arr[right]>target){
                result=Math.max(right-left+1, result);
                right++;
            }else {
                right++;
                left=right;
            }
        }
        return result;
    }
}
