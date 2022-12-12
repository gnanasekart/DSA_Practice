package Sorting;

import org.testng.annotations.Test;

public class Bubblesort {

    @Test
    public void example1() {
        int arr[] = {-2, 0, 12, -4, 13, 8, 11};
        bubbleSort(arr);
    }

    //@Test
    public void example2() {
        int arr[] = {1, 2, 3, 4};
        bubbleSort(arr);
    }

    //@Test
    public void example3() {
        int arr[] = {4, 4, 4, 4, 4};
        bubbleSort(arr);
    }

    //time comp - O(n^2)
    //Space comp - O(1)
    private void bubbleSort(int[] arr) {
        int n = arr.length;
//        for (int i = 0; i < n; i++) { //----> O(n)
//            for (int j = i + 1; j < n; j++) {//----> O(n)
//                if (arr[i] > arr[j]) {
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//            System.out.print(arr[i] + " ");
//        }
        int temp = 0, i=0, j=0;
//        for (i = 0; i < arr.length; i++) {
//
//                if (arr[i] > arr[i+1]) {
//                    temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//
//            }
//        System.out.print(arr[i]);


        for( i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

            for(j=i; j>0; j--){
                if(arr[j]>arr[j-1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

        }

    }
