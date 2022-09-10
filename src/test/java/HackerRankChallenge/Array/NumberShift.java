package HackerRankChallenge.Array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberShift {
	public static void main(String[] args) throws IOException {
		int[] arr = {1, 2, 3, 4, 5};
		int l=4;
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		for(int i=0, j=0; j<l; j++) {
			int firstValue = list.get(i), firstIndex = list.indexOf(firstValue);
			int lastIndex = list.size();
			list.add(lastIndex, list.get(firstIndex));
			list.remove(list.get(firstIndex));
			System.out.println(list);
		}
		
	}
}