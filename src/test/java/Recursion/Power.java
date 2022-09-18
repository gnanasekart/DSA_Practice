package Recursion;

import org.testng.annotations.Test;

public class Power {

    @Test
    public void example1(){
        System.out.println(powerNumber(2,2));
    }

    @Test
    public void example2(){
        System.out.println(powerNumber(2,-2));
    }

    private int powerNumber(int base, int exp) {
        if(exp < 0) return -1;
        if(exp==0 || exp==1) return base;

        return base * powerNumber(base, exp-1);
    }
}
