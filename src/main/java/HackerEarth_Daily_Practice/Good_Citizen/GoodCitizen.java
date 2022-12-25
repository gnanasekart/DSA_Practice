package HackerEarth_Daily_Practice.Good_Citizen;

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

    private int goodCitizen(int[] num) {
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
}
