package HackerRankChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class FrequencySort {

	/*

	   Given an array of n item values, sort the array in ascending order, 
	   first by the frequency of each value, teh by the values themselves.

		items=[4, 5, 6, 5, 4, 3]

		- 2 values = [3, 6]
		- 2 values = [4, 4, 5, 5]
		result = [3, 6, 4, 4, 5, 5]
	 */

	@Test
	public void example1() {
		Integer[] arr = {4, 5, 6, 5, 4, 3};

		frequencySort(arr);
		//frequencySortByComparator(arr);
	}

	private void frequencySortByComparator(Integer[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer a: arr) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}

		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		//Inbuild method
		//Collections.sort(list, Map.Entry.comparingByValue());

		//custome method
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue() > o2.getValue()) return 1;
				else if(o1.getValue() < o2.getValue()) return -1;
				return 0;
			}
		});

		for(Entry<Integer, Integer> entry: list) {
			Integer freq = entry.getValue();
			while(freq>0) {
				System.out.println(entry.getKey());
				freq--;
			}
		}
	}

	private void frequencySort(Integer[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer a: arr) {
			map.put(a, map.getOrDefault(a, 0)+1);
		}

		List<Integer> list = new ArrayList<Integer>();
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		Collections.sort(list);

		int index=0;
		for(int i=0; i<list.size(); i++) {
			for(Entry<Integer, Integer> entry : map.entrySet()) {
				if(list.get(i) == entry.getValue()) {
					int freq = entry.getValue();
					while(freq>0) {
						arr[index++]=entry.getKey();
						freq--;
					}
					map.put(entry.getKey(), 0);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}