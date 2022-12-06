package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N4_1_Colors_And_Rods {
    /*
https://leetcode.com/problems/rings-and-rods/

There are n rings and each ring is either red, green, or blue.
The rings are distributed across ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings
that are placed onto the rods. Every two characters in rings forms a color-position pair
that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0'to'9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3,
a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.

Input: rings = "B0B6G0R6R0R6G9"
Output: 1
Explanation:
- The rod labeled 0 holds 3 rings with all colors: red, green, and blue.
- The rod labeled 6 holds 3 rings, but it only has red and blue.
- The rod labeled 9 holds only a green ring.
Thus, the number of rods with all three colors is 1.


Constraints -
rings.length == 2 * n
1 <= n <= 100
rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
rings[i] where i is odd is a digit from '0' to '9' (0-indexed).

*/

    @Test
    public void example1() {
        String ring = "B0R0G0R9R0B0G0";
        Assert.assertEquals(ringandRodsString(ring), 1);
    }

    @Test
    public void example2() {
        String ring = "G4";
        Assert.assertEquals(ringandRodsHM(ring), 0);
    }

    @Test
    public void example3() {
        String ring = "B0R1G2";
        Assert.assertEquals(ringandRodsSet(ring), 0);
    }

    @Test
    public void example4() {
        String ring = "B0B0B0G0G0G0R0";
        Assert.assertEquals(ringandRodsHM(ring), 1);
    }

/*
Pseudocode
base condition
- check if length%2==0
- check if ring[0].isDigit and ring[1].isAlphabetic
- if ring.length<5 means return 0
1. create a string array for index 0-9
2. get the char and index value and store in respective array
3. if the char is not present then append with existing string
4. else if present then avoid appending string
5. check every array with count == 3
6. return the number of rod with count 3
*/

    private int ringandRods(String ring) {
        if (!Character.isDigit(ring.charAt(1)) && !Character.isLetter(ring.charAt(0)))
            return 0;
        if (ring.length() % 2 != 0 || ring.length() < 5) return 0;

        String[] str = new String[10];
        Arrays.fill(str, "".toString());
        int count = 0, index = 0;
        String s = "";

        for(int i=0; i<ring.length(); i+=2){
            s = String.valueOf(ring.charAt(i));
            index = ring.charAt(i + 1) - '0';
            if (!str[index].contains(s))
                str[index] += s;
            i = i + 2;
        }
        for (String word : str) {
            if (word.length() == 3)
                count++;
        }
        return count;
    }

    private int ringandRodsHM(String ring) {
        if (!Character.isDigit(ring.charAt(1)) && !Character.isLetter(ring.charAt(0)))
            return 0;
        if (ring.length() % 2 != 0 || ring.length() < 5) return 0;
        Map<Integer, String> map = new HashMap<>();

        //for set concept
        //Map<Integer, Set<String>> mapset = new HashMap<>();

        int count = 0, i = 0, index = 0;
        String s = "";

        while (i < ring.length()) {
            s = String.valueOf(ring.charAt(i));
            index = ring.charAt(i + 1) - '0';

            //map.put(index, map.getOrDefault(index, "")+s);
            if (map.containsKey(index)) {
                if (!map.get(index).contains(s)) {
                    s += map.get(index);
                    map.put(index, s);
                }
            }else
                map.put(index, s);
            i = i + 2;
        }
        for (Map.Entry<Integer, String> word : map.entrySet()) {
            if (word.getValue().length()==3)
                count++;
        }
        return count;
    }

    private int ringandRodsSet(String ring) {
        Set<Integer> r= new HashSet<>(), g=new HashSet<>(), b=new HashSet<>();
        int count=0;
        for(int i=0; i<ring.length(); i+=2){
            if(ring.charAt(i)=='B')
                b.add(ring.charAt(i+1)-'0');
            else if (ring.charAt(i)=='G')
                g.add(ring.charAt(i+1)-'0');
            else
                r.add(ring.charAt(i+1)-'0');
            }

        for(int i=0; i<ring.length();i++){
            if(r.contains(i) && b.contains(i) && g.contains(i))
                count++;
        }
        return count;
    }

    private int ringandRodsString(String ring) {
        int count=0;
        for (int i = 0; i < ring.length(); i++) {
            if(ring.contains("B"+String.valueOf(i)) &&
                    ring.contains("G"+String.valueOf(i)) &&
                        ring.contains("R"+String.valueOf(i))){
                count++;
            }
        }
        return count;
    }
}
