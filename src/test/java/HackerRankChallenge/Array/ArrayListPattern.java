package HackerRankChallenge.Array;

import java.util.ArrayList;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ArrayListPattern {

	//https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
	/*
	 *  5
		5 41 77 74 22 44
		1 12
		4 37 34 36 52
		0
		3 20 22 33
		5
		1 3
		3 4
		3 1
		4 3
		5 5

		output
		74
		52
		37
		ERROR!
		ERROR!
	 */
	@Test
	public void example1() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList[] arr = new ArrayList[1000];

		for(int j=0; j<n; j++) {
			arr[j]=new ArrayList();
			int firstN= sc.nextInt();
			for(int i=0; i<firstN; i++){
				int next = sc.nextInt();
				arr[j].add(next);
			}
		}

		int qry=sc.nextInt();
		for(int q=0; q<qry; q++) {
			int row=sc.nextInt();
			int col=sc.nextInt();
			try{
				System.out.println(arr[row-1].get(col-1));
			}catch(Exception e) {
				System.out.println("ERROR!");
			}
		}
	}
}