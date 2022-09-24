package Sorting;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    @Test
    public void example1() {
        int[] arr = {2, 4, 6, 8, 1, 3, 5, 7, 9};
        Bucketsort(arr);
    }

    //print array
    public void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }

    // Print Buckets
    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("\nBucket#" + i + ":");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }

    //time comp = O(n log n)
    //space comp = O(n)
    private void Bucketsort(int[] arr) {
        //no_of_bucket=roundOf(sqrt(array.length))
        //bucket=ceil(value*no_of_bucket)/maxValue

        //identify no of buckets
        int NumberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > maxValue) maxValue = value;
        }

        //creating buckets
        ArrayList<Integer>[] buckets = new ArrayList[NumberOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        //adding value in to buckets
        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(((float) value * NumberOfBuckets) / (float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("\n\nprint before sorting");
        printBucket(buckets);

        for (ArrayList<Integer> bucket : buckets) Collections.sort(bucket);//--> O(log n)

        System.out.println("\n\nprint after sorting");
        printBucket(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) arr[index++] = value;
        }
    }
}
