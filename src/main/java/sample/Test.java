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

//
//        int[] arr = {0,6};
//        int k = 6;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = 0;
//            for (int j = i; j < arr.length && i!=j; j++) {
//                sum += arr[j];
//                if (sum % k == 0) {
//                    System.out.println(true);
//                    break;
//                }
//            }
//        }
//        System.out.println(false);

        int AA =5;
        int AB = 0;
        int BB = 2;
        solution(AA, AB, BB);



    }

    public static String solution(int AA, int AB, int BB) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < AA; i++) {
            s1.append("AA");
        }
        for (int i = 0; i < AB; i++) {
            s1.append("AB");
        }
        for (int i = 0; i < BB; i++) {
            s2.append("BB");
        }

        StringBuilder result = new StringBuilder();

        while (s1.length() > 0 && s2.length() > 0) {
            if (s1.length() > s2.length()) {
                result.append(s1.substring(0, 2));
                s1.delete(0, 2);
            } else {
                result.append(s2.substring(0, 2));
                s2.delete(0, 2);
            }

//            if (result.length() >= 3) {
//                if (result.substring(result.length() - 3).equals("AAA")) {
//                    result.delete(result.length() - 2, result.length());
//                    s1.insert(0, "AA");
//                } else if (result.substring(result.length() - 3).equals("BBB")) {
//                    result.delete(result.length() - 2, result.length());
//                    s2.insert(0, "BB");
//                }
//            }
        }

        if (s1.length() > 0) {
            result.append(s1);
        } else if (s2.length() > 0) {
            result.append(s2);
        }

        return result.toString();
    }
}
