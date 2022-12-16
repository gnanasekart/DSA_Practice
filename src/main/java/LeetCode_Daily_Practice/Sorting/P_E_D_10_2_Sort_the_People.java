package LeetCode_Daily_Practice.Sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_D_10_2_Sort_the_People {

/*
leetcode.com/problems/sort-the-people/
You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.


 */

    @Test
    public void ex1(){
        String[] names = {"Alice","Bob","Bob"};
        int[] heights = {155,185,150};
        Assert.assertEquals(sortPeople(names, heights), new String[]{"Bob","Alice","Bob"});
    }

    @Test
    public void ex3(){
        String[] names = {"Mary","mary","Harry"};
        int[] heights = {180,165,170};
        Assert.assertEquals(sortPeople(names, heights), new String[]{"Mary","Harry","mary"});
    }

    @Test
    public void ex4(){
        String[] names = {"Mary"};
        int[] heights = {1};
        Assert.assertEquals(sortPeople(names, heights), new String[]{"Mary"});
    }


    public String[] sortPeople1(String[] names, int[] heights) {
        if(heights.length==1) return names;
        Map<Integer, String> map = new HashMap();
        for(int i=0; i<heights.length; i++){
            map.put(heights[i], names[i]);
        }

        int p=0, j=0, k=0, temp=0;
        for(j=0; j<heights.length; j++){
            p=j;
            for(k=j+1; k<heights.length; k++){
                if(heights[p]<heights[k]){
                    p=k;
                }
            }
            if(p!=j){
                temp=heights[p];
                heights[p]=heights[j];
                heights[j]=temp;
            }
            //Arrays.stream(heights).forEach( System.out::println);
        }

        ArrayList<String> list = new ArrayList();
        for(int height: heights){
            list.add(map.get(height));
        }

        return list.toArray(new String[0]);
    }

        public String[] sortPeople2(String[] names, int[] heights) {

            String[] res = new String[names.length];
            int[] indexOfNames = new int[100001];

            for(int i = 0; i < heights.length; i++){
                indexOfNames[heights[i]] = i;
            }

            Arrays.sort(heights);

            for(int i = 0; i < heights.length; i++){
                res[heights.length - i - 1] = names[indexOfNames[heights[i]]];
            }

            return res;
        }

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<names.length; i++){
            map.put(heights[i], names[i]);
        }
        return map.values().toArray(new String[0]);
    }
}
