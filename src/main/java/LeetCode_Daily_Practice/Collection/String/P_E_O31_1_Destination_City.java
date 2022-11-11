package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class P_E_O31_1_Destination_City {
    /*
https://leetcode.com/problems/destination-city/

You are given the array paths, where paths[i] = [cityAi, cityBi]
means there exists a direct path going from cityAi to cityBi. Return the destination city,
that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore,
there will be exactly one destination city.

 Example:
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Constraints:
1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
*/

    @Test
    public void example1() {
        String[][] str = {{"London","New York"}, {"New York","Lima"}, {"Lima","Sao Paulo"}};
        List<List<String>> list = new ArrayList();
        for(String[] s: str)
            list.add(List.of(s));

        Assert.assertEquals(destinationCity(list), "Sao Paulo");
    }

    @Test
    public void example2() {
        String[][] str = {{"B","C"}, {"D","B"}, {"C","A"}};
        List<List<String>> list = new ArrayList();
        for(String[] s: str)
            list.add(List.of(s));
        Assert.assertEquals(destinationCity(list), "A");
    }

    @Test
    public void example3() {
        String[][] str = {{"A","Z"}};
        List<List<String>> list = new ArrayList();
        for(String[] s: str)
            list.add(List.of(s));
        Assert.assertEquals(destinationCity(list), "Z");
    }

    @Test
    public void example4(){
        String[][] str = {{"pYyNGfBYbm","wxAscRuzOl"}, {"kzwEQHfwce","pYyNGfBYbm"}};
        List<List<String>> list = new ArrayList();
        for(String[] s: str)
            list.add(List.of(s));
        Assert.assertEquals(destinationCity(list), "wxAscRuzOl");
    }

/*
1. get the value of first loop path[0][1] value
2. iterate in a for loop to get the path[0][1] value in path[i][]th value
3. then return the path[i][1] value
*/

    public String destinationCity(List<List<String>> path){
        if(path.size() == 1) return path.get(0).get(1);
        String destination="";
        Map<String, String> map = new HashMap<>();
        path.stream().forEach(str -> map.put(str.get(0), str.get(1)));

        for(Map.Entry<String, String> entry: map.entrySet()){
            if(!map.containsKey(entry.getValue()))
                destination = entry.getValue();
        }
        return destination;
    }
}
