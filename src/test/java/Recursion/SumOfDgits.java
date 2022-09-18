package Recursion;

import org.testng.annotations.Test;

public class SumOfDgits {
/*
10 => 10/10=1 and rem=0
54 => 54/10=5 and rem=4
112 => 112/10=11 and rem=2
		11/10=1 and rem=1

f(n) = n%10+f(n/10)
 */
    @Test
    public void example1(){
        System.out.println(sumDigit(-116));
    }

    private int sumDigit(int n) {
        if(n==0 || n==1) return n;
        return (n%10)+sumDigit(n/10);
    }
}
