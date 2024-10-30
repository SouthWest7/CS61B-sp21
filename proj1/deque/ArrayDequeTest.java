package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Performs some basic array tests. */
public class ArrayDequeTest {
    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> ad  = new ArrayDeque<>();

        int N = 100;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // add
                int randVal = StdRandom.uniform(0, 100);
                int forl = StdRandom.uniform(0, 2);
                if (forl == 0) {
                    ad.addFirst(randVal);
                    System.out.println("addFirst(" + randVal + ")");
                } else {
                    ad.addLast(randVal);
                    System.out.println("addLast(" + randVal + ")");
                }
            } else if (operationNumber == 1) {
                // size
                System.out.println("size: " + ad.size());
            } else if (ad.size() > 0) {
                if (operationNumber == 2) {
                    //get
                    int index = StdRandom.uniform(0, ad.size());
                    System.out.println("get(" + ad.get(index) + ")");
                } else if (operationNumber == 3) {
                    //remove
                    int forl = StdRandom.uniform(0, 2);
                    if (forl == 0) {
                        System.out.println("removeFirst(): " + ad.removeFirst());
                    } else {
                        System.out.println("removeLast(): " + ad.removeLast());
                    }
                }
            }
        }

    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> ad  = new ArrayDeque<>();
        int N = 5;
        for (int i = 0; i < N; i++) {
            int randVal = StdRandom.uniform(0, 100);
            int forl = StdRandom.uniform(0, 2);
            if (forl == 0) {
                ad.addFirst(randVal);
                System.out.println("addFirst(" + randVal + ")");
            } else {
                ad.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            }
        }
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> ad  = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3);
        ad.addLast(4);

        Iterator<Integer> it = ad.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
