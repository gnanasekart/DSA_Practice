package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LongestSubstring {

	@Test
	public void example1() {
		String s = "bacabcbb";
		int k = 3;
		//longestSubStringMap(s, k);
		//longestSubStringSet(s);
		lengthOfLongestSubstring(s);
	}

	@Test
	public void example2() {
		String s = "bbbbb";
		int k = 1;
		// longestSubStringMap(s, k);
		longestSubStringSet(s);
	}

	@Test
	public void example3() {
		String s = "pwwkew";
		int k = 3;
		// longestSubStringMap(s, k);
		longestSubStringSet(s);
	}

	private void longestSubStringMap(String s, int k) {
		int size = 0, max = 0, left = 0;

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();

		for (int right = 0; right < s.length(); right++) {
			sMap.put(s.charAt(right), 1);

			if (right >= k) {
				if (sMap.containsKey(s.charAt(right))) {
					sMap.remove(s.charAt(left));
					sMap.put(s.charAt(right), 1);
				}
				size = right - left;
				max = size;
				left++;
			}
		}
		System.out.println(sMap.toString() + " = " + max);
	}

	/*
	 * 
	 * Alg- Sliding window / Hashing Alg
	 * 
	 * 1. two pointers - equi - left, right=0
	 * 2. Create hashset
	 * 3. right > Fast pointer > move to every char
	 * 4. Check if that char exist in the set
	 * a. reset your right with left, increment before reset
	 * b. clear your set
	 */

	private void longestSubStringSet(String s) {
		int right = 0, left = 0, maxCount = 0;
		HashSet<Character> hset = new HashSet<Character>();

		while (right < s.length()) {
			if (hset.add(s.charAt(right++))) {
				maxCount = Math.max(maxCount, hset.size());
			} else {
				right = ++left;
				hset.clear();
			}
		}
		System.out.println(maxCount);
	}

	private int lengthOfLongestSubstring(String s) {
		int answer=0;
		Map<String,Integer> map=new HashMap<String, Integer>();
		List<String> list=new LinkedList<String>();
		for (int i = 0; i < s.length(); i++) {
			String k=s.substring(i, i+1);
			if (map.get(k) != null) {
				int n=map.get(k)-map.get(list.get(0))+1;
				for (int j = 0; j < n; j++) {
					map.remove(list.get(0));
					list.remove(0);
				}
			}
			map.put(k, i);
			list.add(k);
			if (list.size()>answer) {
				answer=list.size();
			}
		}
		return answer;
	}
}