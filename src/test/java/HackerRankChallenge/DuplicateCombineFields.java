package HackerRankChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class DuplicateCombineFields {

	/*
	 * 
		You are given a complex list of n products, each with name, price, weight. 
		Find out how many duplicate products are present within the list. 
		Duplicate contain identical parameters for all fields in the list.(i.e name. price and weight)

		Example test case
		name=[ball, bat, glove, glove, glove]
		price=[2,3,1,2,1]
		weight=[2,5,1,1,1]

		name    price    weight
		ball      2        2
		bat       3        5
		glove     1        1
		glove     2        1
		glove     1        1
	 */

	@Test
	public void example1() {
		String[] name = {"ball", "bat", "glove", "glove", "glove"};
		Integer[] price = {2, 3, 1, 2, 1};
		Integer[] weight= {2,5,1,1,1};

		System.out.println(findDuplicate(name, price, weight));
	}
	
	@Test
	public void example2() {
		String[] name = {"ball", "box", "ball", "ball", "box"};
		Integer[] price = {2, 2, 2, 2, 2};
		Integer[] weight= {1, 2, 1, 1, 3};

		System.out.println(findDuplicate(name, price, weight));
	}
	

	private int findDuplicate(String[] names, Integer[] prices, Integer[] weights) {
		List<String> name = new ArrayList<String>(Arrays.asList(names));

		List<Integer> price = new ArrayList<Integer>(Arrays.asList(prices));

		List<Integer> weight = new ArrayList<Integer>(Arrays.asList(weights));

		Set<String> unique = new HashSet<String>();
		int size = name.size();

		if(price.size()!=size || weight.size()!=size)
			return -1;

		int count=0;

		for(int i=0; i<size; i++) {
			if(!unique.add(name.get(i)+"-"+price.get(i)+"-"+weight.get(i))) {
				count++;
			}
		}	
		return count;		
	}
}