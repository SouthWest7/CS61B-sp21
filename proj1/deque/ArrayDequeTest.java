package deque;

import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic array tests. */
public class ArrayDequeTest {
    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);


        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
    }
}
