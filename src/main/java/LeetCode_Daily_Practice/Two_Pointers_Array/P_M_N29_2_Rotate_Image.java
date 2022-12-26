package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P_M_N29_2_Rotate_Image {
    /*
    rotate 90 degree only - leetcode.com/problems/rotate-image/submissions/865731408/


You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.
Input: matrix = [
[1,2,3]
[4,5,6]
[7,8,9]]
Output: [
[7,4,1]
[8,5,2]
[9,6,3]]

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

     */


    @Test
    public void ex1() {
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] target = {{7,4,1}, {8,5,2}, {9,6,3}};
        Assert.assertEquals(nintydegreeRotate(arr, target), true);
    }

    private boolean nintydegreeRotate(int[][] arr, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if(checkIt(arr, target)){
                return true;
            }
            rotate(arr);
        }
        return false;
    }

    private boolean checkIt(int[][] arr, int[][] target) {
        for(int i=0; i<arr[0].length; i++){
            if(!Arrays.equals(arr[i], target[i])){
                return false;
            }
        }
        return true;
    }

    private int[][] rotate(int[][] arr){
        transpose(arr);
        for(int i=0; i<arr.length; i++){
            int start=0, end=arr[0].length-1;
            while(start<end){
                int temp = arr[i][start];
                arr[i][start++]=arr[i][end];
                arr[i][end--]=temp;
            }
        }
        return arr;
    }

    public int[][] transpose(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        return arr;
    }
}
