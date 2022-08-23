package basicPractice;

import org.testng.annotations.Test;

public class FibonacciSeries extends baseTestNG {
	int total = 10;
	@Test
	public void type1() {
		int n1=0, n2=1, n3;
		
		
		for(int i=2; i<=total; i++) {
			n3 = n1+n2;
			System.out.println(n3+" ");
			n1=n2;
			n2=n3;
		}
	}
	
	@Test
	public void type2() {
		int n=1, t1=0, t2=1;
		while(n<=total) {
			int sum=t1+t2;
			
			System.out.println(t1+" ");
			t1=t2;
			t2=sum;
			n++;
		}
	}

}
