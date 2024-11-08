package tester;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void test() {
        StudentArrayDeque<Integer> sd = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        int N = 100;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // add
                int randVal = StdRandom.uniform(0, 100);
                int forl = StdRandom.uniform(0, 2);
                if (forl == 0) {
                    sd.addFirst(randVal);
                    ads.addFirst(randVal);
                    assertEquals("addFirst(" + randVal + ")", ads.get(0), sd.get(0));
                } else {
                    sd.addLast(randVal);
                    ads.addLast(randVal);
                    assertEquals("addLast(" + randVal + ")", ads.get(ads.size() - 1), sd.get(sd.size() - 1));
                }
            } else if (operationNumber == 1) {
                // size
                assertEquals("size()", ads.size(), sd.size());
            } else if (!sd.isEmpty() && !ads.isEmpty()) {
                if (operationNumber == 2) {
                    //get
                    int index = StdRandom.uniform(0, ads.size());
                    assertEquals("get(" + index + ")", ads.get(index), sd.get(index));
                } else if (operationNumber == 3) {
                    //remove
                    int forl = StdRandom.uniform(0, 2);
                    if (forl == 0) {
                        Integer x = ads.removeFirst();
                        Integer y = sd.removeFirst();
                        assertEquals("removeFirst()", x, y);
                    } else {
                        Integer x = ads.removeLast();
                        Integer y = sd.removeLast();
                        assertEquals("removeLast()", x, y);
                    }
                }
            }
        }
    }
}
