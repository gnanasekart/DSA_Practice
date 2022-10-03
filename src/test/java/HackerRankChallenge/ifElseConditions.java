package HackerRankChallenge;
import org.junit.Assert;
import org.junit.Test;

public class ifElseConditions {

	/*
	 * Task
Given an integer, perform the following conditional actions:

If  is odd, print Weird
If  is even and in the inclusive range of  to , print Not Weird
If  is even and in the inclusive range of  to , print Weird
If  is even and greater than, print Not Weird
Complete the stub code provided in your editor to print whether or not  is weird.

Input Format

A single line containing a positive integer, .

Constraints
1<= n <= 100

Output Format

Print Weird if the number is weird; otherwise, print Not Weird.
	 * 
	 */


	@Test //+ve
	public void example1() {
		int n = 3;
		String output = "Weird";
		Assert.assertEquals(output, ifElseStmt(n));
	}

	@Test //edge
	public void example2() {
		int n = 24;
		String output = "Not Weird";
		Assert.assertEquals(output, ifElseStmt(n));
	}

	@Test //-ve
	public void example3() {
		int n = 0;
		String output = null;
		Assert.assertEquals(output, ifElseStmt(n));
	}


	private String ifElseStmt(int n) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		if(n%2!=0){
			return "Weird";
		}else if(n%2==0 && (n>=2 && n<=5)){
			return "Not Weird";
		}else if(n%2==0 && (n>=6 && n<=20)){
			return "Weird";
		}else if(n%2==0 && n>=20){
			return "Not Weird";
		}
		return null;
	}
}
