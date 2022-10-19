package LeetCode_Daily_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
public class P_O17_2_Assign_Cookies {

    /*
    leetcode.com/problems/assign-cookies/
Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie
that the child will be content with; and each cookie j has a size s[j].
If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
will be content. Your goal is to maximize the number of your content children
and output the maximum number.

*/

    @Test
    public void example1(){
        int[] g={1,2,3};
        int[] s={1,1};
        Assert.assertEquals(assignCookies(g, s), 1);
    }

    @Test
    public void example2(){
        int[] g={1,2,3};
        int[] s={1,2};
        Assert.assertEquals(assignCookies(g, s), 2);
    }

    @Test
    public void example3(){
        int[] g={1,2,3};
        int[] s={1,2,2,3,5};
        Assert.assertEquals(assignCookies(g, s), 3);
    }

    @Test
    public void example4(){
        int[] g={1};
        int[] s={1,2};
        Assert.assertEquals(assignCookies(g, s), 1);
    }

    @Test
    public void example5(){
        int[] g={1};
        int[] s={};
        Assert.assertEquals(assignCookies(g, s), 0);
    }

    @Test
    public void example6(){
        int[] g={1,2,2,3};
        int[] s={1,2,3};
        Assert.assertEquals(assignCookies(g, s), 3);
    }

    @Test
    public void example7(){
        int[] g={10,9,8,7};
        int[] s={5,6,7,8};
        Assert.assertEquals(assignCookies(g, s), 2);
    }

/*
logic
1. check if cookie array is empty or not
2. consider two array with two pointer
3. traversal cookie array to each child to match size of cookie >= child can content
	- if child can content then get the count and move next
	- else move to next cookie
4. then return the content cookie count
*/

    private int assignCookies1(int[] child, int[] size){
        if(child.length<1 && size.length<1) return 0;
//        Arrays.sort(child);
//        Arrays.sort(size);
        int count=0;
        int left=0, right=size.length-1;
        while(left<child.length-1){
            if(size[right]>=child[left] && right>0){
                count++;
                right--;
            }
            left++;
        }
        return count;
    }


    private int assignCookies(int[] child, int[] size) {
        Arrays.sort(child);
        Arrays.sort(size);
        int i=0, j=0;
        while(i<child.length && j<size.length){
            if(size[j]>=child[i])
                i++;
            j++;
        }
    return i;
    }

}
