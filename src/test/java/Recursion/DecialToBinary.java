package Recursion;

import org.testng.annotations.Test;

public class DecialToBinary {
/*
Steps
1. divide the number by 2
2. Get the integer quotient for the next iteration
3. Get the remainder for the binary digit
4. Repeat the steps until the quotient is equal to 0

13 = 1101

divide by 2   Quotient     remainder
13/2			6				1
6/2				3				0
3/2				1				1
1/2				0				1

f(n) = (n%2)+10*f(n/2)
 */
    @Test
    public void example1() {
        System.out.println(decToBin(13));
    }

    private int decToBin(int i) {
        if (i < 0) return -1;
        if (i == 0) return 0;
        return (i % 2) + (10 * decToBin(i / 2));
    }
}
