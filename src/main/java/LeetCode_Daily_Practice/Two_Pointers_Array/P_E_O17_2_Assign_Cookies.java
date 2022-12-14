package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
public class P_E_O17_2_Assign_Cookies {

    /*
    leetcode.com/problems/assign-cookies/
Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie
that the child will be content with; and each cookie j has a size s[j].
If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
will be content. Your goal is to maximize the number of your content children
and output the maximum number.

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1,
you could only make the child whose greed factor is 1 content.
You need to output 1.

Constraints:

1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1
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

    private int assignCookies(int[] child, int[] size) {
        if(child.length<1 && size.length<1) return 0;
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
