package LeetCode_Daily_Practice.Queue;

import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class LogFileRead {

    //O(n log n)
    @Test
    public void main1() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\studies and document\\automation learning repo\\Java repo\\Java repo\\DSA_Practice\\src\\main\\java\\LeetCode_Daily_Practice\\Queue\\logFile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            int first = line.indexOf('<') + 1;
            int second = line.indexOf('>');
            String name = line.substring(first, second);
            String[] s = line.substring(line.indexOf('>') + 1).split(" ");
            int count = map.getOrDefault(name, 0) + s.length;
            map.put(name, count);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        System.out.println(list.get(0));
    }

    //O(n)
    @Test
    public void main2() throws IOException {

        String line, name, l;
        int count = 0, first, second;
        BufferedReader brr = new BufferedReader(new FileReader("C:\\studies and document\\automation learing repo\\Java repo\\Java repo\\DSA_Practice\\src\\main\\java\\LeetCode_Daily_Practice\\Queue\\logFile.txt"));
        while ((brr.readLine()) != null) count++;

        BufferedReader br = new BufferedReader(new FileReader("C:\\studies and document\\automation learing repo\\Java repo\\Java repo\\DSA_Practice\\src\\main\\java\\LeetCode_Daily_Practice\\Queue\\logFile.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<User> minHeap = new PriorityQueue<>(count, (u1, u2) -> u2.wordcount - u1.wordcount);
        while ((line = br.readLine()) != null) {
            first = line.indexOf("<") + 1;
            second = line.indexOf(">");
            String username = line.substring(first, second);
            String[] words = line.substring(second + 1).split(" ");
            int c = map.getOrDefault(username, 0) + words.length;
            map.put(username, c);
            User user = new User(username, c);
            minHeap.offer(user);
//            if (minHeap.size() < count) {
//                minHeap.offer(user);
//            } else if (minHeap.peek().wordcount < count) {
//                minHeap.poll();
//                minHeap.offer(user);
//            }
        }
        System.out.println(minHeap.peek().name+"-"+minHeap.peek().wordcount);
    }
    }

class User{
    String name;
    int wordcount;

    User(String name, int wordcount){
        this.wordcount=wordcount;
        this.name=name;
    }
}
