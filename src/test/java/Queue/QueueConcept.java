package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.testng.annotations.Test;

public class QueueConcept {


	@Test
	public void queueConcept() {

		ArrayDeque<Integer> q = new ArrayDeque<>();
		Queue<Integer> qq = new ConcurrentLinkedQueue<>();

		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		deque.push(10);
		deque.push(11);
		deque.push(12);
		deque.push(13);
		System.out.println(deque);//13,12,11,10
		System.out.println(deque.offer(1));
		System.out.println(deque);//13,12,11,10,1
		System.out.println(deque.add(-1));//true
		System.out.println(deque);//13, 12, 11, 10,1,-1
		System.out.println(deque.pop());//13
		System.out.println(deque.peek());//12


		ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();
		deque1.offer(10);
		deque1.offer(11);
		deque1.offer(12);
		deque1.offer(13);
		System.out.println(deque1);//10, 11, 12, 13
		System.out.println(deque1.poll());//10
		System.out.println(deque1.element());//11
	}
}
