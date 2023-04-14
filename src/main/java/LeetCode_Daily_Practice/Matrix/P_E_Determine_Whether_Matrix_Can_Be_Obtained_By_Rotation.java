package LeetCode_Daily_Practice.Matrix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_E_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

    /*
Constraints:
n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.

     */

    @Test
    public void ex1(){
        int[][] mat = {{0,1},{1,0}}, target = {{1,0},{0,1}};
        Assert.assertEquals(rotate(mat, target), true);
    }

    @Test
    public void ex2(){
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}}, target = {{1,1,1},{0,1,0},{0,0,0}};
        Assert.assertEquals(rotate(mat, target), true);
    }

    @Test
    public void ex3(){
        int[][] mat = {{0,1},{1,1}}, target = {{1,0},{0,1}};
        Assert.assertEquals(rotate(mat, target), false);
    }

    @Test
    public void ex4(){
        int[][] mat = {{0}}, target = {{1}};
        Assert.assertEquals(rotate(mat, target), false);
    }

    @Test
    public void ex5(){
        int[][] mat = {{0,0},{0,1}}, target = {{0,0},{1,0}};
        Assert.assertEquals(rotate(mat, target), true);
    }
//0 0   0 0
//0 1   1 0

/*
90 degree means transpose and rotate or flipping matrix

transform

1 2 3   1 4 7   1 4 7    1 4 7
4 5 6   2       2 5 8    2 5 8
7 8 9   3       3 6      3 6 9

rotate

1 4 7   7 4 1
2 5 8   8 5 2
3 6 9   9 6 3

 */

    private boolean rotate1(int[][] mat, int[][] target){
            //     360/90 = 4
        for(int i=0; i<4; i++) {
            if (check(mat, target)) {
                return true;
            }
            rotateMatrix(mat);
        }
        return false;
    }

    public static boolean check(int[][] mat, int[][]  target){
        for(int i=0; i<mat.length; i++){
            if(!Arrays.equals(mat[i], target[i])) {
                return false;
            }
        }
        return true;
    }

    private void rotateMatrix(int[][] mat) {
        transform(mat);
        int left=0, right=mat.length-1;
        for(int i=0; i<mat.length; i++){
            while(left<right){
               int temp=mat[i][left];
                mat[i][left]=mat[i][right];
                mat[i][right]=temp;
            }
        }
    }

    public void transform(int[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }




















    /*
    Some explanation, suppose we are at index i, j, let us find a relation of this position with it's position in various rotations
    i. e
0deg rotation : i, j will point to i, j
90deg rotation : i, j will point to j, n - i - 1
            180deg rotation : i, j will point to n - i - 1, n - j - 1
            270deg rotation : i, j will point to n - j - 1, i

    We denote these rotations by boolean variables, initially we assume all these rotations are valid, so we set them all to true
    here c[0] denotes 0deg rotation, c[1] -> 90deg, c[2] -> 180 deg, c[3] -> 270deg

    Then, we loop over all elements and check if that particular rotation is valid or not. If not, we turn it to false.
    In the end, we simply check if any of the rotations is still possible or not.

    This same code can also be used to find out the valid rotation, i,e 0deg / 90deg / 180 deg/ 270 deg by checking the boolean value in c[0], c[1]. c[2], c[3] respectively.
*/
        public boolean rotate(int[][] mat, int[][] target) {
            boolean[] c = new boolean[4];
            for(int i=0;i<4;i++)
            {
                c[i]=true;
            }
            int n=mat.length;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(mat[i][j]!=target[i][j]) c[0]=false;
                    if(mat[i][j]!=target[n-j-1][i]) c[1]=false;
                    if(mat[i][j]!=target[n-i-1][n-j-1]) c[2]=false;
                    if(mat[i][j]!=target[j][n-i-1]) c[3]=false;
                }
            }
            return c[0]||c[1]||c[2]||c[3];
        }
    }


