package LeetCode_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Group_Anagram {

	/*
	Given an array of strings strs, group the anagrams together. 
	You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.


    Input = str = ["eat", "tea", "ate", "nat", "bat"]

    output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

    pseudo code
	- declare a hash map to group the anagrams
	- decalre a int[] of length 26
	            - traverse the list in for loop till the length
	- for each item add it to the ascii array and convert it to string
	- check if the string exists in map
	----then add the current element to its value
	else
	----add the string and element as value to the map
	
	return the map.values
		 */

	@Test
	public void test() {
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<String> strlist = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
		List<String> list1 = Arrays.asList("bat");
		List<String> list2 = Arrays.asList("tan", "nat");
		List<String> list3 = Arrays.asList("eat", "tea", "ate");
		List<List<String>> listoutput = Arrays.asList(list2, list1, list3);
		//Assert.assertEquals(listoutput, groupAnagramASCII(strlist));
		Assert.assertEquals(listoutput, groupAnagram(str));
	}

	private List<List<String>> groupAnagramASCII(List<String> strlist) {
		if (strlist.isEmpty()) return Arrays.asList(Arrays.asList(""));

		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strlist) {
			char[] ascii = new char[26];
			for (int i = 0; i < str.length(); i++)
				ascii[str.charAt(i) - 'a']++;

			String s = String.valueOf(ascii);
			map.putIfAbsent(s, new ArrayList<>());
			map.get(s).add(str);
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagram(String[] strs) {
		HashMap<Map<Character, Integer>, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			HashMap<Character, Integer> tmap = new HashMap<>();
			for (int j = 0; j < strs[i].length(); j++) 
				tmap.put(strs[i].charAt(j), tmap.getOrDefault(strs[i].charAt(j), 0) + 1);

			//			if (map.containsKey(tmap)) map.get(tmap).add(strs[i]);
			//			else {
			//				List<String> list = new ArrayList<>();
			//				new ArrayList<>().add(strs[i]);
			//				map.put(tmap, list);
			//			}

			map.putIfAbsent(tmap, new ArrayList<>());
			map.get(tmap).add(strs[i]);
		}
		System.out.println(map.values());
		return new ArrayList<>(map.values());
	}
}