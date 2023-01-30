package LeetCode_Daily_Practice.Collection.Array;

import org.testng.annotations.Test;

import java.util.*;

public class P_I_Descending_Ord_Num_Frequecy {
    /*
    Write a java code to display in the following order
input - [2,5,2,8,5,6,8,8]
output - [8,8,8,2,2,5,5,6]
     */

    public static void main(String[] args) {
        int[] input = {2, 5, 2, 8, 5, 6, 8, 8};
        Arrays.sort(input);
        int[] output = new int[input.length];
        int index = input.length - 1;
        for (int i = 0; i < input.length; i++) {
            if (i > 0 && input[i] == input[i - 1]) {
                continue;
            }
            for (int j = i; j < input.length; j++) {
                if (input[i] == input[j]) {
                    output[index--] = input[i];
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void main() {
        int[] input = {2, 5, 2, 8, 5, 6, 8, 8};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : input) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> output = new LinkedList<>();
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    int count = e.getValue();
                    while (count > 0) {
                        output.add(e.getKey());
                        count--;
                    }
                });
        System.out.println(output);
    }
}

