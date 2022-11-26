package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;

public class P_E_N26_3_Crawler_Log_Folder {
    /*
        https://leetcode.com/problems/crawler-log-folder/
        The Leetcode file system keeps a log each time some user performs a change folder operation.
        The operations are described below:
         "../" : Move to the parent folder of the current folder.
                (If you are already in the main folder, remain in the same folder).
         "./" : Remain in the same folder.
         "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
        You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

        The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.

        Input: logs = ["d1/","d2/","../","d21/","./"]
        output = ["d1/","d21/"]
        Output: 2
        Explanation: Use this change folder operation "../" 2 times and go back to the main folder.

   Constraints:
        1 <= logs.length <= 10^3
        2 <= logs[i].length <= 10
        logs[i] contains lowercase English letters, digits, '.', and '/'.
        logs[i] follows the format described in the statement.
        Folder names consist of lowercase English letters and digits.

    */
    @Test
    public void ex1() {
        String[] s = {"d1/", "d2/", "../", "d21/", "./"};
        Assert.assertEquals(minOperations(s), 2);
    }

    @Test
    public void ex2() {
        String[] s = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        Assert.assertEquals(minOperations(s), 3);
    }

    @Test
    public void ex3() {
        String[] s = {"d1/", "../", "../", "../"};
        Assert.assertEquals(minOperations(s), 3);
    }

    @Test
    public void ex4() {
        String[] s = {"../", "../", "../"};
        Assert.assertEquals(minOperations(s), 0);
    }

    @Test
    public void ex5() {
        String[] s = {"./", "../", "./"};
        Assert.assertEquals(minOperations(s), 0);
    }

    @Test
    public void ex6() {
        String[] s = {"../"};
        Assert.assertEquals(minOperations(s), 0);
    }

    @Test
    public void ex7() {
        String[] s = {"d1"};
        Assert.assertEquals(minOperations(s), 1);
    }

/*
Logic
create a new stack
check if stack is empty then check it is folder or not
    if folder then push
    else move to next
if new one is ../ means pop the last pushed one
if ./ means continue
finally return stack size
*/


    public int minOperations(String[] logs) {

        Stack<String> st = new Stack();

        for (String l : logs) {
            if (st.isEmpty() || !l.equals("../") && !l.equals("./")) st.push(l);
            else if (l.equals("../") && !st.isEmpty()) st.pop();
            else if (l.equals("./") && !st.isEmpty()) continue;
            else if (!l.equals("../") && !l.equals("./")) st.push(l);
        }
        return st.size();
    }
}
