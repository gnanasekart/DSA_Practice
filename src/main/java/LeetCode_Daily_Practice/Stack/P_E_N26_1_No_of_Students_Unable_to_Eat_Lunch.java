package LeetCode_Daily_Practice.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class P_E_N26_1_No_of_Students_Unable_to_Eat_Lunch {
    /*
    https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

    The school cafeteria offers circular and square sandwiches at lunch break,
    referred to by numbers 0 and 1 respectively. All students stand in a queue.
    Each student either prefers square or circular sandwiches.

    The number of sandwiches in the cafeteria is equal to the number of students.
    The sandwiches are placed in a stack. At each step:

    If the student at the front of the queue prefers the sandwich on the top of the stack,
    they will take it and leave the queue.
    Otherwise, they will leave it and go to the queue's end.
    This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

    You are given two integer arrays students and sandwiches where sandwiches[i] i
    s the type of the ith sandwich in the stack (i = 0 is the top of the stack) and students[j]
    is the preference of the jth student in the initial queue (j = 0 is the front of the queue).
    Return the number of students that are unable to eat.

    Constraints:
    1 <= students.length, sandwiches.length <= 100
    students.length == sandwiches.length
    sandwiches[i] is 0 or 1.
    students[i] is 0 or 1.

    Example 1:

    Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
    Output: 0
    Explanation:
 - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
 - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
            - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
            - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
            - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
            - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
            - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
            - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
    Hence all students are able to eat.
*/

    @Test
    public void ex1(){
        int[] students={1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        Assert.assertEquals(countStudents1(students, sandwiches), 0);
    }

    @Test
    public void ex2(){
        int[] students={1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        Assert.assertEquals(countStudents(students, sandwiches), 3);
    }

    @Test
    public void ex3(){
        int[] students={1};
        int[] sandwiches = {0};
        Assert.assertEquals(countStudents(students, sandwiches), 0);
    }

    @Test
    public void ex4(){
        int[] students={0,1,1};
        int[] sandwiches = {0,0,1};
        Assert.assertEquals(countStudents(students, sandwiches), 2);
    }

    @Test
    public void ex5(){
        int[] students={0};
        int[] sandwiches = {1};
        Assert.assertEquals(countStudents(students, sandwiches), 0);
    }

/*
1. add the student details in queue
2. consider if sandwiches matches with student preferred
	if matches then remove the sandwich and student from queue
	else move the student to queue last
3. count the no of student from the queue moves to last position
4. similarly calculate the queue size based on no of last move
5. finally return size of queue which denotes no of student did not get sandwich
*/


    public int countStudents1(int[] students, int[] sandwiches) {
        if(students.length!=sandwiches.length) return 0;

        Stack<Integer> st = new Stack();

        for(int i=sandwiches.length-1; i>=0; i--)
            st.push(sandwiches[i]);

        Queue<Integer> q = new ArrayDeque();
        for(int sand: students)
            q.offer(sand);

        while(!st.isEmpty() && !q.isEmpty()){
            if(st.peek() == q.peek()){
                st.pop();
                q.poll();
            }else{
                q.add(q.poll());
            }
        }
        return q.size();
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new ArrayDeque();
        for(int sand: students)
            q.offer(sand);
        int temp=0, i=0;

        while(temp<q.size()){
            if(sandwiches[i] == q.peek()){
                i++;
                q.poll();
                temp=0;
            }else{
                q.add(q.poll());
                temp++;
            }
        }
        return q.size();
    }

}
