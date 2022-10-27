package sample;
public class sample {

    public static void main(String[] args) {
         String a = "ABCDCDC";
         String b = "CDC";
         String str = "";
        int count=0;
        int left=b.length()-1, right=left-b.length()+1;
         while(right<a.length()){
             if(b.equals(a.substring(left, right++)))
                 count++;
         }
         System.out.println(count);
    }
}
