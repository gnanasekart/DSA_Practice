package sample;

import java.util.HashMap;
import java.util.Map;

public class sample {

    public static void main(String[] args) {
//         String a = "ABCDCDC";
//         String b = "CDC";
//         String str = "";
//        int l=0;
//         //output=2
//        int count=0;
//        for(int i=0; i<a.length()-b.length()+1; i++){
//            l=i+b.length();
//            if(b.equals(a.substring(i, l)))
//                count++;
//        }


//        int left=b.length()-1, right=left-b.length()+1;
//         while(right<a.length()){
//             if(b.equals(a.substring(left, right++)))
//                 count++;
//         }
//         System.out.println(count);
//        int[] aa = {1,2,0,1,2};
//        int left=0, right=1;
//        while(left<aa.length&&right<aa.length){
//            if(aa[left]<aa[right]){
//                right++;
//            }else if(aa[left]>aa[right]){
//                int temp = aa[left];
//                aa[left++]= aa[right];
//                aa[right++]=temp;
//            }else left++;
//        }


        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<5; i++){
            map.put(i, i+1);
        }
        for(Map.Entry<Integer, Integer> i: map.entrySet()){
            map.get(i);
        }

    }
}
