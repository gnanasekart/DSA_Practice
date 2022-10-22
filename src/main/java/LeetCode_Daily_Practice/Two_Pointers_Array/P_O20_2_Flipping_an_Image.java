package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_O20_2_Flipping_an_Image {
/*
    leetcode.com/problems/flipping-an-image/

    Given an n x n binary matrix image,
    flip the image horizontally,
    then invert it,
    and return the resulting image.

    To flip an image horizontally means that each row of the image is reversed.

    For example, flipping [1,1,0] horizontally results in [0,1,1].

    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

    For example, inverting [0,1,1] results in [1,0,0].

    Example 1:

    Input: image = [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

    Constraints:

    n == image.length
    n == image[i].length
1 <= n <= 20
    images[i][j] is either 0 or 1.
*/
    @Test
    public void example1(){
        int[][] image={{1,1,0},{1,0,1},{0,0,0}};
        int[][] out ={{1,0,0},{0,1,0},{1,1,1}};
        Assert.assertEquals(flipImage(image), out);
    }

    @Test
    public void example2(){
        int[][] image={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] out ={{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
        Assert.assertEquals(flipImage(image), out);
    }

    @Test
    public void example3(){
        int[][] image={{1},{0},{0},{1}};
        int[][] out ={{0},{1},{1},{0}};
        Assert.assertEquals(flipImage(image), out);
    }

    @Test
    public void example4(){
        int[][] image={{1,1,1,1,1,1},{0,0,0,0,0,0}};
        int[][] out ={{0,0,0,0,0,0},{1,1,1,1,1,1}};
        Assert.assertEquals(flipImage(image), out);
    }

    /*
1. traversal to get the first array 0,0 to n*n
2. first reverse the digit position in place
3. then change the operator sign in place
4. return the fliped image array
*/

    private int[][] flipImage(int[][] image){
        int n[][] = new int[image.length][image[0].length];
        int i=0;
        for(int[] arr : image) {
            int[] rev = reverseImage(arr);
            n[i++] = invertImage(rev);
        }
        return n;
    }

        public int[] reverseImage(int[] img){
        int left=0, right=img.length-1;
        while(left<right){
            img[left]=img[left]+img[right];
            img[right]=img[left]-img[right];
            img[left]=img[left++]-img[right--];
        }
        return img;
   }

        public int[] invertImage(int[] rev){
        int j=0;
        while(j<rev.length){
            if(rev[j]==1 || rev[j]==0){
                if(rev[j]==1) rev[j++]=0;
                else rev[j++]=1;
            }
        }
        return rev;
   }
}
