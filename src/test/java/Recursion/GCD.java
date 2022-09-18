package Recursion;

import org.testng.annotations.Test;

public class GCD {

    /*
    Euclidean algorithms
    gcd(48, 18)
    48/18=2 remainder 12
    18/12=1 remainder 6
    12/6=2 remainder 0

    gcd(a, 0) = a
    gcd(a, b) = gcd(b, a mod b)
     */
    @Test
    public void example1() {
        System.out.println(gcdNumber(8, 4));
    }

    @Test
    public void example3() {
        System.out.println(gcdNumber(8, -4));
    }

    @Test
    public void example2() {
        System.out.println(gcdNumber(4, 9));
    }

    private int gcdNumber(int a, int b) {
        if(a<0 || b<0) return -1;
        if (b == 0) return a;
        return gcdNumber(b, a % b);
    }
}
