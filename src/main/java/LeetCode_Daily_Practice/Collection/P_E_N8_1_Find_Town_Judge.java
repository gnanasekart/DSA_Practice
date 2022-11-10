package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N8_1_Find_Town_Judge {
    /*

    https://leetcode.com/problems/find-the-town-judge/

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Constraints:

1 <= n <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n

*/

    @Test
    public void ex1() {
        int[][] trust = {{1, 2}};
        int n = 2;
        Assert.assertEquals(townJudge(trust, n), 2);
    }

    @Test
    public void ex2() {
        int[][] trust = {{1, 3}, {2, 3}};
        int n = 3;
        Assert.assertEquals(townJudge(trust, n), 3);
    }

    @Test
    public void ex3() {
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;
        Assert.assertEquals(townJudge(trust, n), -1);
    }

    @Test
    public void ex4() {
        int[][] trust = {{1, 2}};
        int n = 1;
        Assert.assertEquals(townJudge(trust, n), -1);
    }

    @Test
    public void ex5() {
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2,4}, {4, 3}};
        int n = 4;
        Assert.assertEquals(townJudge(trust, n), 3);
    }

    @Test
    public void ex6() {
        int[][] trust = {};
        int n = 1;
        Assert.assertEquals(townJudge(trust, n), 1);
    }

    @Test
    public void ex8() {
        int[][] trust = {};
        int n = 2;
        Assert.assertEquals(townJudge(trust, n), -1);
    }

    @Test
    public void ex7() {
        int[][] trust = {{1, 2}, {2, 3}};
        int n = 3;
        Assert.assertEquals(townJudge(trust, n), -1);
    }




/*
pseudocode

1. check if the n length is < 1
2. check trust length < 0
3. get the first array and check a != b, and a[b] != a[a]
4. if not found repeat for all array
5. if found then return a[a]
6. else return -1
*/

    public int townJudge1(int[][] trust, int n) {
        if(n<1) return -1;
        if(trust.length <= 0) return -1;

        Map<Integer, Integer> map = new HashMap();
        //if(trust.length==1) map.put(trust[0][1], 1);
        for(int[] t : trust) {
                map.put(t[1], map.getOrDefault(t[1], 0)+1);
            }
        for(int[] t: trust) {
            if (map.containsKey(t[1]) && map.get(t[1]) == n - 1) {
                return t[1];
            }
        }
        return -1;
    }


    public int townJudge(int[][] trust, int n) {
        if(trust.length==0 && n==1) return 1;
//        Map<Integer, Integer> map = new HashMap();
//        int key=0, key2=0;
//        for(int[] t : trust){
//            key=t[0];
//
//            map.put(key, map.getOrDefault(key, 0) -1);
//            //System.out.println("map1 = "+map);
//        }
//
//        for(int[] t : trust){
//            key2=t[1];
//            map.put(key2, map.getOrDefault(key2, 0) +1);
//           // System.out.println("map2 = "+map);
//        }
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue()==n-1){
//                return entry.getKey();
//            }
//        }
//        return -1;

        int judge=0;
        Map<Integer, Integer> map = new HashMap();
        for(int[] t : trust){
            map.put(t[1], map.getOrDefault(t[1], 0)+1);
        }
        int isJudge=-1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()==n-1){
                int key = entry.getKey();
                for(int[] t : trust){
                    if(t[0]==key){
                        break;
                    }else
                        isJudge=entry.getKey();
                }
            }
        }
        return isJudge;
    }
}

