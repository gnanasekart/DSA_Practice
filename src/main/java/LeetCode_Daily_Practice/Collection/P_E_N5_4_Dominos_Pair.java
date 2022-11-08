package LeetCode_Daily_Practice.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_N5_4_Dominos_Pair {
	/*
leetcode.com/problems/number-of-equivalent-domino-pairs/
    Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
    if and only if either (a == c and b == d), or
(a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
Return the number of pairs (i, j)
for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

*/
	@Test
	public void ex1() {
		int[][] dom = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
		Assert.assertEquals(dominoesArray(dom), 1);
	}

	@Test
	public void ex2() {
		int[][] dom = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
		Assert.assertEquals(dominoesArray(dom), 3);
	}

	/*
    logic
    base condition
    - check array length is less than 1
    - check inner array length ==2

    1. consider the array value as key
    2. get the occurrance of key and store in value
    3. get the count of each key by getting the value in probability combination
    */
	public int dominoesArray1(int[][] arr) {
		Map<String, Integer> map = new HashMap();

		for (int[] pair : arr) {
			int a = pair[0] < pair[1] ? pair[0] : pair[1];
			int b = pair[0] > pair[1] ? pair[0] : pair[1];
			map.put(a+","+b, map.getOrDefault(a+","+b, 0) + 1);
		}

		//The formula is n!/ (k! * (n-k)!)
		//As n! can be very large, use the short version of it; (n * (n-1)) / 2
		int count=0;
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			int n = entry.getValue();
			count+= n*(n-1)/2;
		}
		return count;
	}

	public int dominoesArrayAL(int[][] arr) {

		Map<ArrayList<Integer>, Integer> map = new HashMap<>();

		for(int[] a : arr){
			Arrays.sort(a);
			ArrayList<Integer> list = new ArrayList<>();
			list.add(a[0]);
			list.add(a[1]);
			map.put(list, map.getOrDefault(list, 0)+1);
		}

		int count=0;
		for(Map.Entry<ArrayList<Integer>, Integer> entry : map.entrySet()) {
			if(entry.getValue()>1){
				int size=1;
				while(size<entry.getValue()){
					count+=size;
					size++;
				}
			}
		}
		return count;
	}

	public int dominoesArray(int[][] dominoes) {
		int ans = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < dominoes.length; i++) {
			int min = Math.min(dominoes[i][0], dominoes[i][1]);
			int max = Math.max(dominoes[i][0], dominoes[i][1]);

			int key = min * 10 + max;
			ans += map.getOrDefault(key, 0);
			map.put(key, 1 + map.getOrDefault(key, 0));
		}

		return ans;
	}

	public int dominoesArray2darray(int[][] dominoes) {
		// using the 10 by 10 table due to dominoes range [1,9]
		int [][] table = new int[10][10];

		for(int[] p : dominoes) {
			if(table[p[0]][p[1]] > 0) {
				table[p[0]][p[1]]++;
			} else if (table[p[1]][p[0]] > 0) {
				table[p[1]][p[0]]++;
			} else {
				table[p[0]][p[1]]++;
			}
		}

		int res = 0;
		for(int i=1; i<10; i++){
			for(int j=1; j<10; j++) {
				if(table[i][j] <= 1) {
					continue;
				}
				// calculate permutation
				res += (table[i][j] * (table[i][j]-1) / 2);
			}
		}

		return res;
	}
}
