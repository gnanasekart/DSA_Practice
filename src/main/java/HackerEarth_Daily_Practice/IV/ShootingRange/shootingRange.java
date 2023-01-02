package HackerEarth_Daily_Practice.IV.ShootingRange;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class shootingRange {

    @Test
    public void ex1(){
        int arr = 7;
        Assert.assertEquals(shooting(arr), 24);
    }

    @Test
    public void ex2(){
        int arr = 22;
        Assert.assertEquals(shooting(arr), 24);
    }

    @Test
    public void ex3(){
        int arr = 4;
        Assert.assertEquals(shooting(arr), 6);
    }

    private int shooting(int arr) {
        int sum=0;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=arr; i++){
            list.add(i+1);
        }

        for(int i=0; i<list.size(); i++){
            for (int j = 0; j < list.size(); j++) {
                if(list.size()==1) return sum;
                sum+=list.remove(j);
            }
        }
        return sum;
    }
}
