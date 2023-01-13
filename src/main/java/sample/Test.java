package sample;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

//
//       int  Input: 	[0, 1, 0, 0, 1, 2, 2]
//        Output: {0, 0, 0, 1, 1, 2, 2}


//        Low = 0, midd = 1, high = input.leng-1;
//        Breaking condition middle<=high
//        inp[mid]==0 swap (mid, low)
//        inp[mid]==1 mid++
//        inp[mid]==2 swap(mid, high)


//            int[] inp1 = {0,1,0,0,1,2,2};
//            int[] inp = {1,0,1,1,2,1};
//            int low = 0, mid = 1, end = inp.length-1, temp=0;
//
//            while(mid<=end){
//                if(inp[mid]==0){
//                    temp=inp[low];
//                    inp[low++]=inp[mid];
//                    inp[mid++]=temp;
//                }else if(inp[mid]==1){
//                    mid++;
//                }else if(inp[mid]==2){
//                    temp=inp[mid];
//                    inp[mid]=inp[end];
//                    inp[end--]=temp;
//                }
//            }
//        System.out.println(Arrays.toString(inp));


//        int[] arr = {2, 4, 6,7, 9};
//        int k = 13;

//        int[] arr = {1, 10};
//        int k = 2;


        int[] arr = {0,6};
        int k = 6;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length && i!=j; j++) {
                sum += arr[j];
                if (sum % k == 0) {
                    System.out.println(true);
                    break;
                }
            }
        }
        System.out.println(false);



    }
}
