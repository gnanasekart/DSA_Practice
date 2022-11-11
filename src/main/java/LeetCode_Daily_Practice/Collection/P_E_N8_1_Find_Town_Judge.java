package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N8_1_Find_Town_Judge {
    /*

    https://leetcode.com/problems/find-the-town-judge/

In a town, there are n people labeled from 1 to n.
There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi]
representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified,
or return -1 otherwise.

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
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2,4}, {4, 3}};
        int n = 4;
        Assert.assertEquals(townJudgeHM(trust, n), 3);
    }

    @Test
    public void ex5() {
        int[][] trust = {};
        int n = 1;
        Assert.assertEquals(townJudge(trust, n), 1);
    }

    @Test
    public void ex6() {
        int[][] trust = {};
        int n = 2;
        Assert.assertEquals(townJudge(trust, n), -1);
    }

    @Test
    public void ex7() {
        int[][] trust = {{1, 2}, {2, 3}};
        int n = 3;
        Assert.assertEquals(townJudge1(trust, n), -1);
    }

/*
pseudocode

1. create an array n+1 length to store trusting person arr[i][0] index
2. create an array n+1 length to store trustedBy person arr[i][1] index
3. add the array values into array
4. check for both the condition to satisfy
    - from trusting array judge trusting value will be 0 so check i == 0
5. with the above judge value, confirm it is judge
    - check the above value as index of trustedBy array to find judge trust count  == n-1
6. return judge
7. else return -1

{{1, 3}, {1, 4}, {2, 3}, {2,4}, {4, 3}}
trusting = | 0 | 1 | 2 | 3 | 4 |
                 2   2   0   1

trustedBy = | 0 | 1 | 2 | 3 | 4 |
                          3   2
*/

    //using two array
    public int townJudge1(int[][] trust, int n){

        int[] trusting = new int[n+1];
        int[] trustedby = new int[n+1];
        trusting[0]=0;
        trustedby[0]=0;
        int judge=0;
        for(int[] t : trust){
            trusting[t[0]]++;
            trustedby[t[1]]++;
        }
        for (int i = 1; i < trusting.length; i++) {
            if (trusting[i] == 0 && trustedby[i]==n-1)
                judge = i;
        }

//        for (int i = 1; i < trusting.length; i++) {
//            if (trusting[i] == 0)
//                judge = i;
//        }
//        if(trustedby[judge] == n-1)
//            return judge;

        return -1;
    }

    //using single array
    public int townJudge(int[][] trust, int n){

        int[] trusting = new int[n+1];
        int judge=0;
        for(int[] t : trust){
            trusting[t[0]]--;
            trusting[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trusting[i] == n-1)
                return i;
        }
        return -1;
    }

    public int townJudgeHM(int[][] trust, int n) {
        if (n < 1) return -1;
        if (n == 1) return 1;
        if (trust.length <= 0) return -1;

        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        //if(trust.length==1) map.put(trust[0][1], 1);
        for (int[] t : trust) {
            map1.put(t[0], map1.getOrDefault(t[0], 0) + 1);
            map2.put(t[1], map2.getOrDefault(t[1], 0) + 1);
        }
//        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//            if (entry.getValue() == n - 1)
//                return entry.getKey();
//        }

        for(int i: map2.keySet()){
            if(map2.get(i)==n-1 && !(map1.containsKey(map1.get(i)))){
                return i;
            }
        }
        return -1;
    }


//    public int townJudge2(int[][] trust, int n) {
//        if(trust.length==0 && n==1) return 1;
//        int judge=0;
//        Map<Integer, Integer> map = new HashMap();
//        for(int[] t : trust){
//            map.put(t[1], map.getOrDefault(t[1], 0)+1);
//        }
//        int isJudge=-1;
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//            if(entry.getValue()==n-1){
//                int key = entry.getKey();
//                for(int[] t : trust){
//                    if(t[0]==key){
//                        break;
//                    }else
//                        isJudge=entry.getKey();
//                }
//            }
//        }
//        return isJudge;
//    }
}

