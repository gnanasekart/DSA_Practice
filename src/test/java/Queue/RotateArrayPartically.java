package Queue;

import java.util.ArrayDeque;
import java.util.Stack;

import org.testng.annotations.Test;

public class RotateArrayPartically {

	@Test
	public void example1() {
		int[] num = {4, 6, 8, 11, 10, 18};//8, 6, 4, 11, 10, 18
		int k=3;
		rotate3(num, k);
	}

	@Test
	public void example2() {
		int[] num = {10, 10, 60, 40, 20, 10, 50};//40, 60, 10, 10, 20, 10, 50
		int k=4;
		rotate1(num, k);
	}

	private void rotate(int[] num, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		int i=0;
		while(i<num.length) {
			while(i<k) deque.push(num[i++]);
			deque.offer(num[i++]);
		}
		System.out.println(deque);
	}

	private void rotate1(int[] num, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		for(int i=0; i<num.length; i++) {
			if(i<k) deque.push(num[i]);
			else deque.offer(num[i]);
		}
		System.out.println(deque);
	}

	/*
	 * Ds- Stack and queues
		Iterate every element in the array
		1. for the first k elements - push it to stack
		2. for the rest of elements - offer in to queues

		retrive the item from the stack(pop) and add to queue(poll)
	 */

	private void rotate3(int[] num, int k) {
		Stack<Integer> stack = new Stack<>();
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		for(int i=0; i<num.length; i++) {
			if(i<k) stack.push(num[i]);
			else deque.offer(num[i]);
		}

		for(int i=0; i<k; i++) deque.offer(stack.pop());

		for(int i=0; i<num.length-k; i++) deque.offer(deque.poll());
		System.out.println(deque);
	}
}
