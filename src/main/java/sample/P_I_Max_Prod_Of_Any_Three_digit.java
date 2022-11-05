package sample;

public class P_I_Max_Prod_Of_Any_Three_digit {

    public static void main(String[] args) {

        int max = Integer.MIN_VALUE, prod=1;
        int[] arr = {3,5,-6,1,2,0,-8,4};
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i]>=0 && arr[j]>=0 && arr[k]>=0){
                        prod = arr[i]*arr[j]*arr[k];
                        max=prod>max?prod:max;
                    }
                }
            }
        }
    }
}
