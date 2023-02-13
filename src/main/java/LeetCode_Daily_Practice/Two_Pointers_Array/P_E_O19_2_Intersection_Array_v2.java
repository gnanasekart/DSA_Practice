package LeetCode_Daily_Practice.Two_Pointers_Array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_E_O19_2_Intersection_Array_v2 {

    /*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays
and you may return the result in any order.

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you
cannot load all elements into the memory at once?
*/

    @Test
    public void example1(){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        Assert.assertEquals(intersectBS(nums1, nums2), new int[]{2,2});
    }

    @Test
    public void example5(){
        int[] nums1={1,2,2,1,2};
        int[] nums2={2,2,2};
        Assert.assertEquals(intersectArrayMaxAppear1(nums1, nums2), new int[]{2,2,2});
    }

    @Test
    public void example2(){
        int[] nums1={4,9,5};
        int[] nums2={9,4,9,8,4};
        Assert.assertEquals(intersectBS(nums1, nums2), new int[]{9,4});
    }

    @Test
    public void example3(){
        int[] nums1={4,9,5,3,2,1};
        int[] nums2={6,7,8};
        Assert.assertEquals(intersectArrayMaxAppearBF(nums1, nums2), new int[]{});
    }

    @Test
    public void example4(){
        int[] nums1={2,2,2,2,2,2,4};
        int[] nums2={1,4};
        Assert.assertEquals(intersectArrayMaxAppearBF(nums1, nums2), new int[]{4});
    }

/*
- check the condition for empty
- create an arraylist
- consider two pointers for both the array
- if both the array value matches then add into arraylist
- else increment one array pointer
- return the arraylist from new array
*/

    public int[] intersectArrayMaxAppearBF(int[] nums1, int[] nums2) {
        ArrayList<Integer>l=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    l.add(nums2[j]);
                    nums2[j]=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        //return l.stream().mapToInt(i -> i).toArray();
        int k=0;
        int arr[]= new int [l.size()];
        for(int m: l)
            arr[k++]=m;
        return arr;
    }

    //time = O(n)+O(n)+O(nlog n)+O(nlog n) =
    //space = O(n)arraylist + O(n)array => O(n)
    private int[] intersectArrayMaxAppear1(int[] n1, int[] n2){
        if(n1.length<1 && n2.length<1) return new int[]{};
        int left=0, right=0, i=0;
        Arrays.sort(n1);//O(nlog n)
        Arrays.sort(n2);//O(nlog n)

        ArrayList<Integer> list = new ArrayList<>();
        while( left<n1.length && right<n2.length){//=> O(n)
            if(n1[left] < n2[right]) left++;
            else if(n1[left] > n2[right]) right++;
            else {
               // list.add(n1[left]);//extra space
                n1[i++]=n1[left]; //in space
                left++;
                right++;
            }
        }
            return Arrays.copyOfRange(n1, 0, i);
//        return list.stream().mapToInt(n->n).toArray();
    }

    //time = O(n)+O(n)+O(n)+O(nlog n)+O(nlog n) =
    //space = O(n)arraylist +O(n)hashmap + O(n)array => O(n)
    private int[] intersectArrayMaxAppear(int[] n1, int[] n2){

        if(n2.length < n1.length){
            return intersect(n2, n1);
        }

        if(n1.length<1 && n2.length<1) return new int[]{};
        int left=0, right=0, i=1;;
        Arrays.sort(n1);//O(nlog n)
        Arrays.sort(n2);//O(nlog n)

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        while( left<n1.length && right<n2.length){//=>O(n)
            if(n1[left] < n2[right]) left++;
            else if(n1[left] > n2[right]) right++;
            else {
                map.put(n1[left], map.getOrDefault(n1[left], 0)+1);
                left++;
                right++;
            }
        }

        for(int l: n2){//O(n)
            if(map.containsKey(l) && map.get(l)>0){
                list.add(l);
                map.put(l, map.get(l)-1);
            }
        }
//------
        int[] arr=new int[list.size()];
        int j=0;
        for(Integer a: list)//=>O(n)
            arr[j++]=a;
        return arr;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int arr[]=new int[1001];
        int ans[]=new int[1001];
        int count=0;
        for(int i:nums1){
            arr[i]++;
        }
        for(int i :nums2){
            if(arr[i]>0){
                ans[count++]=i;
                arr[i]--;
            }
        }
        return Arrays.copyOfRange(ans,0,count);
    }

    public int[] intersectBS(int[] n1, int[] n2){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(n1);
        Arrays.sort(n2);
        int left=0;
        for(int n : n1){
            int index = binarySearchOf(n2, n, left);
            if(index!=-1){
                list.add(index);
                left=index+1;
            }
        }
        return list.stream().mapToInt(u -> u).toArray();
    }

    private int binarySearchOf(int[] n1, int n, int left) {

        int mid=0, right=n1.length-1, ind=-1;
        while(left<=right){
            mid=(right+left)/2;
            if(n1[mid]==n) {
                return mid;
            }
            else if(n1[mid]<n) left=mid+1;
            else if(n1[mid]>n) right=mid-1;
        }
        return ind;
    }
}
