package HackerEarth_Daily_Practice.IV.Good_Citizen;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoodCitizen {
    @Test
    public void ex1() {
        int[] num = {3, 1, 4, 5, 2};
        Assert.assertEquals(goodCitizen(num), 3);
    }

    @Test
    public void ex2() {
        int[] num = {1, 8, 5, 11, 7};
        Assert.assertEquals(goodCitizen(num), 3);
    }

    private int goodCitizen1(int[] num) {
        int count = 0, val = 0, left = -1, point = 0,  right = point+1;
        while (right <= num.length) {
            if (left == -1 || right == num.length) {
                if (left == -1 && (num[point] > (0 + num[right])/2)) {
                    count++;
                } else if (right == num.length && (num[point] > (num[left] + 0)/2)) {
                    count++;
                }
                left++;
            } else {
                if (num[point] > (num[left] + num[right])/2) {
                    count++;
                }
                left++;
            }
            point = left + 1;
            right = point + 1;
        }
        return count;
    }

    private int goodCitizen(int[] num) {
        int count=0,previous=0, next=0;

        for (int i=0; i< num.length-1; i++){
            if(i==0) previous=0;
            else previous=num[i-1];

            if(next==num.length) next=0;
            else next=num[i+1];

            if(num[i] > (previous+next)/2)
                count++;
        }
        return count;
    }
}
