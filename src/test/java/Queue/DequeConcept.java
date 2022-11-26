package Queue;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeConcept {

    @Test
    public void ex(){
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(1);
        deque.addFirst(0);
        deque.addLast(10);//0, 1,10

        deque.offer(12);
        deque.offerFirst(11);
        deque.offerLast(20);//11,12,20

        System.out.println(deque);//11,0,1,10,12,20
    }
}
