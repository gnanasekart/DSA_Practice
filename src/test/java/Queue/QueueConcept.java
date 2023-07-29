package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.testng.annotations.Test;

public class QueueConcept {


	public int minOperations(String[] logs) {

		Stack<String> st = new Stack();

		for(String l : logs){
			if(st.isEmpty() && !st.equals("../") && !st.equals("./"))
				st.push(l);
			else if(l.equals("../"))
				st.pop();
			else if(l.equals("./"))
				continue;
			else st.push(l);
		}
		return st.size();
	}
	@Test
	public void queueConcept() {

//		ArrayDeque<Integer> q = new ArrayDeque<>();
//		Queue<Integer> qq = new ConcurrentLinkedQueue<>();
//
//		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
//		deque.push(10);
//		deque.push(11);
//		deque.push(12);
//		deque.push(13);
//		System.out.println(deque.offer(1));
//		System.out.println(deque.add(-1));
//		System.out.println(deque);//13, 12, 11, 10
//		System.out.println(deque.pop());//13
//		System.out.println(deque.peek());
//
//
//		ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();
//		deque1.offer(10);
//		deque1.offer(11);
//		deque1.offer(12);
//		deque1.offer(13);
//		System.out.println(deque1);//10, 11, 12, 13
//		System.out.println(deque1.poll());//10
//		System.out.println(deque1.element());
//

//		int[] s = {1,1,1,0,0,1};
//		int[] sw={1,0,0,0,1,1};
//
//		countStudents(s,sw);

		String[] ss ={"d1/","d2/","./","d3/","../","d31/"};
		minOperations(ss);
	}



//	public int countStudents(int[] students, int[] sandwiches) {
//		Stack<Integer> st = new Stack();
//		for(int i=0; i<sandwiches.length; i++)
//			st.push(sandwiches[i]);
//
//
//		ArrayDeque<Integer> q = new ArrayDeque();
//		for(int sand: students)
//			q.offer(sand);
//
//
//		if(students.length!=sandwiches.length) return 0;
//
////		System.out.print(st+" ");
////		System.out.print(q+" ");
//		while(!st.isEmpty() && !q.isEmpty()){
//			if(st.peek() == q.peek()){
//
//				st.pop();
//				q.poll();
//			}else{
//				q.add(q.poll());
//			}
//		}
//		return q.size();
//	}

}
