package LeetCode_Challenges;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_E_LC_5_Plus_One {

    @Test
    public void example1(){
        int[] nums={1,2,3};
        Assert.assertEquals(plusOne(nums), new int[] {1,2,4});
    }

    @Test
    public void example2(){
        int[] nums={4,3,2,1};
        Assert.assertEquals(plusOne(nums), new int[] {4,3,2,2});
    }

    @Test
    public void example3(){
        int[] nums={9};
        Assert.assertEquals(plusOne(nums), new int[] {1,0});
    }

    @Test
    public void example4(){
        int[] nums={0};
        Assert.assertEquals(plusOne(nums), new int[] {1});
    }

    @Test
    public void example5(){
        int[] nums={9,9};
        Assert.assertEquals(plusOne(nums), new int[] {1,0,0});
    }

    private int[] plusOne1(int[] nums) {
        int total =0, count=0;
        if(nums.length>1){
            for (int i = 0; i < nums.length; i++){
                total=(total+nums[i])*10;
                count++;
            }

            total=(total/10)+1;
        }else if(nums[nums.length-1] == 9) {
            int arr[] = new int[nums.length+1];
            total=nums[0]+1;
            arr[1]=total%10;
            arr[0]= total/10;
            return arr;
        }else{
            total=nums[0]+1;
            nums[0]=total%10;
            return nums;
        }
        int i = nums.length;
        while(i>count){
            nums[i--]=total%10;
            total=total/10;
        }
        return nums;
    }


    private int[] plusOne(int[] nums) {
        int i=nums.length-1;
        while(i>=0 && nums[i]==9)
            i--;

        if(i==-1){
            int[] arr = new int[nums.length+1];
            arr[0]=1;
            return arr;
        }
        int[] arr = new int[nums.length];

        arr[i] = nums[i] + 1;
        for (int j = 0; j < i; j ++)
            arr[j] = nums[j];
        return arr;
    }
}
