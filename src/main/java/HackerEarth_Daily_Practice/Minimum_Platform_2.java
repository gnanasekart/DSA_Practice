package HackerEarth_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_Platform_2 {

    /*
    https://www.hackerearth.com/problem/algorithm/minimum-platforms-2/

    Given arrival and departure times of all trains that reach a railway station,
    find the minimum number of platforms required for the railway station so that no train waits.

Consider that all the trains arrive at the same day and leave on the same day.
Arrival and departure time can never be the same for a train but we can have arrival time of one train equal
to departure time of the other. At any given instance of time, same platform can not be used for both
departure of a train and arrival of another train. In such cases, we need different platforms.
   */


    @Test
    public void ex1() {
        String[] arival = {"0032", "0414"};
        String[] dep = {"1031", "0959"};
        Assert.assertEquals(platform(arival, dep), 2);
    }

    @Test
    public void ex2() {
        String[] arival = {"0219", "0255", "0051", "0449"};
        String[] dep = {"0954", "0355", "1049", "0633"};
        Assert.assertEquals(platform(arival, dep), 3);
    }

    @Test
    public void ex3() {
        String[] arival = {"0100", "0344", "0110", "0401"};
        String[] dep = {"0200", "0522", "0322", "0430"};
        Assert.assertEquals(platform(arival, dep), 2);
    }

    @Test
    public void ex4() {
        String[] arival = {"1200", "1300", "1512", "2015", "1415"};
        String[] dep = {"1400", "1400", "1515", "2121", "2200"};
        Assert.assertEquals(platform(arival, dep), 2);
    }

    /*
    logic -
    get the count as array length
    1. collect the array in 2d array or hashmap
    2. sort the array based on arrival time using comparator or array sort
    3. compare the first departure value with second arrival time,
        increment the index if matches
        else decrement the count
    4. return the train allocated count
     */

    //time  - O(n) + O(n log(n)) + O(n) => O(3n log(n)) => O(n log(n))
    //space - O(n)
    private int platform(String[] arival, String[] dep) {
        int[][] time = new int[arival.length][2]; // ----> O(n)
        for (int i = 0; i < arival.length; i++) { // O(n)
            time[i][0] = Integer.valueOf(arival[i]);
            time[i][1] = Integer.valueOf(dep[i]);
        }
        Arrays.sort(time, (a, b) -> a[0] - b[0]); //O(nlog(n))
        int left = 0, right = 1, count = arival.length;
        while (right < time.length) {//O(n)
            if (time[left][1] < time[right][0])
                count--;
            else
                left++;
            right++;
        }
        return count;
    }


    @Test
    public void exx() {
        int[] input = {11, 9, 8, 7, 13, 5, 17, 3, 5};
        int sum = 25;
        Assert.assertEquals(sumvalue(input, sum), new int[]{7, 13, 5});
    }

    @Test
    public void exx1() {
        int[] input = {5};
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
                if (sum == val) {
                    return list.stream().mapToInt(x -> x).toArray();
                }
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}

