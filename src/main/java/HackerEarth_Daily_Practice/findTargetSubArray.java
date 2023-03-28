package HackerEarth_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class findTargetSubArray {

    @Test
    public void exx() {
        int[] input = {11, 9, 8, 7, 13, 5, 17, 3, 5};
        int sum = 25;
        Assert.assertEquals(sumvalue(input, sum), new int[]{7, 13, 5});
    }


    public int[] sumvalue(int[] a, int sum) {
        if (a.length <= 1) return new int[]{0};
        ArrayList<Integer> list = new ArrayList<>();
        int val = 0;
        for (int i = 0; i < a.length; i++) {
            val = 0;
            list.clear();
            for (int j = i; j < a.length; j++) {
                val += a[j];
                list.add(a[j]);

                if (sum == val)
                    return list.stream().mapToInt(x -> x).toArray();
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
