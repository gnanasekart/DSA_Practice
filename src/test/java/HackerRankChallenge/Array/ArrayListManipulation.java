package HackerRankChallenge.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ArrayListManipulation {
	//hackerrank.com/challenges/java-list/problem?isFullScreen=true
	/*
	 * 
	 * input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

output - 0 1 78 12 23

	 */
	@Test
	public void example1() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			list.add(sc.nextInt());
		}

		int func = sc.nextInt();
		for(int j=0; j<func; j++) {
			String o = sc.next();
			if(o.equals("Insert")) {
				int index = sc.nextInt();
				int value = sc.nextInt();
				list.add(index, value);
			}else if(o.equals("Delete")) {
				int index = sc.nextInt();
				list.remove(index);
			}
		}
		list.forEach(x -> System.out.print(x+" "));
	}
}
