package HackerRankChallenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class FindMaxUnique {

	@Test
	public void example1() {
		int[] num = {4, 5, 2, 2, 5, 1};
		int k=3;
		findmaxUnique(num, k);
	}

	@Test
	public void example2() {
		int[] num = {4, 4, 5, 5, 2, 2};
		int k=3;
		findmaxUnique(num, k);
		findmaxUniqueQueue(num, k);
	}

	@Test
	public void example3() {
		int[] num = {4, 4, 4, 4, 4, 4};
		int k=3;
		findmaxUnique(num, k);
	}

	/*
	 * Take the first k values -> put it in to the map
		Find the max of map keys

		Loop through from k to the end
		reduce i-k(map -> remove key or update key) and add i

		finally find the max
	 */

	//average = O(n), worst=O(n*k)
	private void findmaxUnique(int[] num, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<k; i++) {
			map.put(num[i], map.getOrDefault(num[i], 0)+1);
		}

		int max = map.size();

		for(int i=k; i<num.length; i++) {
			if(map.get(num[i-k]) == 1) map.remove(num[i-k]);
			else map.put(num[i-k], map.get(num[i-k])-1);
			map.put(num[i], map.getOrDefault(num[i], 0)+1);
			max=Math.max(max, map.size());
		}
		System.out.println(max);
	}

	/*
	 * Add every element to the set and queue
		if the queue size==k
			= remove the first
			= if removed element from queue does not have any other occurances then remove it from set as well

		find max size of the set and return max
	 */

	//time = O(n*k)
	private void findmaxUniqueQueue(int[] num, int k) {
		Set<Integer> set = new HashSet<Integer>();
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		int max=1;
		for(int i=0; i<num.length; i++) {
			set.add(num[i]);
			deque.offer(num[i]);

			if(deque.size()==k) {
				max=Math.max(max, set.size());
				Integer first = deque.poll();
				if(!deque.contains(first)) set.remove(first);
			}
		}
		System.out.println(max);
	}
}