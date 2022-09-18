package Recursion;

import org.testng.annotations.Test;

public class FibboncciSeries {

    @Test
    public void example1() {
        System.out.println(fibroncci(5));
    }

    @Test
    public void example2() {
        fibprint(5);
    }

    @Test
    public void example3() {
        System.out.println(fibboncciRecursive(-1));
    }

    private int fibroncci(int n) {
        int fib = 0;
        int f1 = 0, f2 = 1;
        if (n < 2) return 1;
        for (int i = 0; i < n; i++) {
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
            System.out.print(f1 + " ");
        }
        return fib;
    }

    private void fibprint(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibboncciRecursive(i) + " ");
        }
    }

    private int fibboncciRecursive(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int value = fibboncciRecursive(n - 1) + fibboncciRecursive(n - 2);
        return value;
    }
}
