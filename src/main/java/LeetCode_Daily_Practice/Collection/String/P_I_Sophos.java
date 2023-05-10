package LeetCode_Daily_Practice.Collection.String;

import io.cucumber.java.sl.In;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class P_I_Sophos {
/*

Given comma seperated words you have to sort words based on frequency in descending ordeer,
if word frequency are same then sort based on alphabet in ascending order.

String input = "Mango,Orange,Mango,Apple,Orange,Mango"
Output :
Mango : 3
Orange :2
Apple :1

 */

    @Test
    public void ex3(){
        String input = "Mango,Orange,Apple";
        fruits(input);
    }


    @Test
    public void ex2() {
        String input = "Mango,Orange,Mango,Apple,Orange,Mango";
    fruits(input);
    }

    @Test
    public List fruits(String input){
        String[] in = input.split(",");
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(in).forEach(a -> map.put(a, map.getOrDefault(a, 0)+1));

        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        boolean flag = false;
        for(Map.Entry<String, Integer> ent : map.entrySet()){
            if(ent.getValue()>1){
                flag=true;
            }
        }
        List list = new LinkedList(map.entrySet());
        if(flag){
           Collections.sort(list, new Comparator<>() {
               public int compare(Object o1, Object o2) {
                   return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
               }
           });
        }
        return list;
    }

    @Test
    public void ex1(){
        String str = "aaaabbccdddddeeeaabb";
        String output = "4a2b2c5d3e2a2b";
        Assert.assertEquals(exampleProgram(str), output);
    }


    @Test
    public String exampleProgram(String str){

        StringBuilder sb = new StringBuilder();

        int left=0, right=1, count=1;
        while(right<str.length()){

            if(str.charAt(right)==str.charAt(right-1)){
                right++;
                count++;
            }else if(str.charAt(right)!=str.charAt(right-1)){
                sb.append(count);
                sb.append(str.charAt(left));
                left=right;
                right++;
                count=1;
            }
        }
        sb.append(count);
        sb.append(str.charAt(left));

        return sb.toString();
    }
}
