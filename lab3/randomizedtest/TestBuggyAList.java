package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
    public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      correct.addLast(5);
      correct.addLast(10);
      correct.addLast(15);

      broken.addLast(5);
      broken.addLast(10);
      broken.addLast(15);

      assertEquals(correct.size(), broken.size());

      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
  }

  @Test
    public void randomizedTest() {
      AListNoResizing<Integer> correct  = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              correct.addLast(randVal);
              broken.addLast(randVal);
              System.out.println("correct: addLast(" + randVal + ")");
              System.out.println("broken: addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              System.out.println("correct size: " + correct.size());
              System.out.println("broken size: " + broken.size());
          } else if (correct.size() > 0) {
              if (operationNumber == 2) {
                  //getLast
                  System.out.println("correct: getLast(" + correct.getLast() + ")");
                  System.out.println("broken: getLast(" + broken.getLast() + ")");
              } else if (operationNumber == 3) {
                  //removeLast
                  System.out.println("correct: removeLast(" + correct.removeLast() + ")");
                  System.out.println("broken: removeLast(" + broken.removeLast() + ")");
              }
          }
      }

  }
}
