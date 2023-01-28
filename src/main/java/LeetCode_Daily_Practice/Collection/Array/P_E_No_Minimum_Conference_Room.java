package LeetCode_Daily_Practice.Collection.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_No_Minimum_Conference_Room {
/*
Given an String array A of size N denoting time intervals of different meetings.
Find the minimum number of conference rooms required so that all meetings can be done.
 */


    @Test
    public void example1() {
        //Positive Test Data
        String[][] meetingTimes = {{"09 00", "09 45"},{"09 30", "10 30"},{"10 40", "12 00"},{"11 00", "13 00"}, {"11 45", "14 00"},{"16 00", "17 00"}};
        int expectedOutput = 3;
        Assert.assertEquals(expectedOutput, minConfRooms(meetingTimes));
    }

    @Test
    public void example2() {
        //Edge Case Test Data
        String[][] meetingTimes = {{"09 00", "09 30"},{"09 00", "09 30"},{"10 30", "11 00"},{"10 40", "11 40"}};
        int expectedOutput = 2;
        Assert.assertEquals(expectedOutput, minConfRooms(meetingTimes));
    }

    @Test
    public void example3() {
        //Negative Test Data
        String[][] meetingTimes = {{"09 00", "09 30"},{"12 00", "12 10"},{"13 30", "13 50"},{"10 40", "11 40"}};
        int expectedOutput = 1;
        Assert.assertEquals(expectedOutput, minConfRooms(meetingTimes));
    }

    private int minConfRooms(String[][] meetingTimes) {

        int[][] room = new int[meetingTimes.length][2];

        for(int i=0; i<meetingTimes.length; i++){
            room[i][0]=Integer.valueOf(meetingTimes[i][0].replace(" ", ""));
            room[i][1]=Integer.valueOf(meetingTimes[i][1].replace(" ", ""));
        }
        Arrays.sort(room, (a, b) -> a[0]-b[0]);
        int count= meetingTimes.length, left=0, right=1;
        while(right<room.length-1){
            if(room[left][1] <= room[right][0]){
                count--;
                left++;
            }
            right++;
        }
        return count;
    }


    private int minConfRooms1(String[][] meetingTimes) {

        Map<Integer, Integer> map = new HashMap<>();

         for(String[] meeting: meetingTimes){
             int first = Integer.valueOf(meeting[0].replace(" ", ""));
             int second = Integer.valueOf(meeting[1].replace(" ", ""));

             map.put(first, second);
         }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue()!=o2.getValue()) return o1.getValue()-o2.getValue();
                return o1.getKey()-o2.getKey();
            }
        });

        int count = meetingTimes.length, left=0, right=1;

        while(right<meetingTimes.length){
            if(list.get(left).getValue() <= list.get(right).getKey()){
                count--;
                left++;
            }
            right++;
        }
        return count;
    }
}
