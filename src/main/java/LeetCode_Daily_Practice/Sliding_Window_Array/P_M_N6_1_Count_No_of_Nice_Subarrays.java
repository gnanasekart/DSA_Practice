package LeetCode_Daily_Practice.Sliding_Window_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class P_M_N6_1_Count_No_of_Nice_Subarrays {
    /*
    leetcode.com/problems/count-number-of-nice-subarrays/
Given an array of integers nums and an integer k. A continuous subarray is called nice
if there are k odd numbers on it.
Return the number of nice sub-arrays.

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Constraints:
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length


leetcode.com/problems/count-number-of-nice-subarrays/discuss/1665666/Java-Simple-Sliding-Window-Solution
leetcode.com/problems/count-number-of-nice-subarrays/discuss/419317/Java-Sliding-window-Two-Pointers-O(n)

     */

    @Test
    public void ex(){
        int[] nums = {1,1,2,1,1};
        int k=3;
        Assert.assertEquals(countnicesubarrayPrefixSum(nums, k), 2);
    }

    @Test
    public void ex1(){
        int[] nums = {2,4,6};
        int k=1;
        Assert.assertEquals(countinuesubarray(nums, k), 0);
    }

    @Test
    public void ex2(){
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        Assert.assertEquals(countnicesubarrayPrefixSum(nums, k), 16);
    }

    /*
    Brute force
    1. consider two for loop
    2. first traversal starts from i = 0 to n
    3. second traversal starts from j = i to n
    4. if we met num%2==1 means we get the odd count
    5. then if we met odd==k numbers then get the count
    6. return number of countOut==k count
     */

    //BF time limit exceed
    public int countinuesubarrayBF(int[] nums, int k) {
        int m=0, count=0;
        for(int i=0; i<nums.length; i++){
                count=0;
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2!=0)
                    count++;

                if(count==k)
                    m++;
            }
        }
        return m;
    }

    /*
    1. consider the HashMap for prefix sum
    2. here we change the even numbers to 0 and odd numbers to 1
    3. Initially value in map we can key 0 as 1 occurrence or increment count when sum==k
    4. first sum the value with prefix index value
    sum +x = k
    sum-k = x => x means sum and its occurrence
    5. second check the sum-k value is present as map key
    6. if present then get the sum and occurrence count from map like map.get(sum-k);
    7. else add the x value into hash table like map.put(sum, 1);
    8. increment the occurrence for more than once using getOrDefault
    9. return the count
     */

    //using prefix sum
    public int countnicesubarrayPrefixSum(int[] nums, int k) {
        int count=0,sum=0,prefixSum=0,j=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i]%2==1 ? 1 : 0;

        map.put(0,1);
        while(j< nums.length){
            sum+=nums[j++];

            //if(sum==k) count++;
            prefixSum=sum-k;
            if(map.containsKey(prefixSum))
                count+=map.get(prefixSum);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    //2 pointers
    public int countinuesubarray2Pointers(int[] nums, int k) {
        int oddCount=0, odd=0, totalOddCount=0;
        int right=0, left=0;

        while(right<nums.length){
            if(nums[right++]%2!=0){
                odd++;
                oddCount=0;
            }
            while(odd==k){
                oddCount++;
                if(nums[left++]%2!=0)
                    odd--;
            }
            totalOddCount+=oddCount;
        }
        return totalOddCount;
    }

    public int countinuesubarray(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        map.put(0,1);

        for(int i = 0;i<nums.length ; i++){
            if( nums[i]%2 != 0 )
                count++;
            res += map.getOrDefault( count - k , 0 );
            map.put( count , map.getOrDefault( count , 0 ) + 1 );
        }
        return res;
    }

}
