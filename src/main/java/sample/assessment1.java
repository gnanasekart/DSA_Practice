package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assessment1 {

/*
https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

 */
@Test
public void example1(){
int n =2;
Assert.assertEquals(sumoftwo(n), new int[]{1,1});
}

@Test
public void example2(){
int n =11;
Assert.assertEquals(sumoftwo(n), new int[]{2,9});
}

@Test
public void example3(){
int n =100;
Assert.assertEquals(sumoftwo(n), new int[]{1,99});
}
/*
logic-
1. considering two for loop
2. first loop with start iterating from i = n-1 to i from larger to small
3. second loop iterate from 1 to n smaller to larger
4. sum both the i and j value
5. return both the value if equals to target
*/

    public int[] sumoftwo(int n) {
        if(n<2) return new int[]{0,1};

        int[] arr = new int[2];
        for(int i=1; i<n; i++){
            for(int j=n-1; j>0; j--){
                if(j+i==n){
                    arr[0]=j;
                    arr[1]=i;

                    break;
                }
            }
        }
        return arr;
    }
}
