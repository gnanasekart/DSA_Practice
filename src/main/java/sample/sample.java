package sample;
public class sample {

    public static void main(String[] args) {
         String a = "ABCDCDC";
         String b = "CDC";
         String str = "";
        int l=0;
         //output=2
        int count=0;
        for(int i=0; i<a.length()-b.length()+1; i++){
            l=i+b.length();
            if(b.equals(a.substring(i, l)))
                count++;
        }


//        int left=b.length()-1, right=left-b.length()+1;
//         while(right<a.length()){
//             if(b.equals(a.substring(left, right++)))
//                 count++;
//         }
         System.out.println(count);
    }
}
