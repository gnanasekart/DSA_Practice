package Recursion;

import org.testng.annotations.Test;

public class Factorial {

	/*
	 Rules to handle the recursion problems
		1. Identify the simplest/smallest possible input(base case) -> 1! = 1
		2. Build test data to visualize (2! =? 2x1!, 4! => 4x3! => 4x3x2! => 4x3x2x1!
		3. Break harder cases into simpler cases ==> 10! = 10x9!
		4. Generalize the pattern n! --> n*(n-1)!
		5. Finally, write the code to combine the pattern.
	 * 
	 */

    @Test
    public void example1() {
        System.out.println(factorial(5));
    }

    @Test
    public void example2() {
        System.out.println(factorial(-2));
    }

    @Test
    public void example3() {
        System.out.println(factorial(5));
    }

    private int factorial(int i) {
        if(i<=0) return -1;
        if (i == 1) return 1;

        int n = i * factorial(i-1);
        return n;
    }
}