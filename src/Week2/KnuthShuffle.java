package Week2;

import java.util.Random;

/**
 * Created by svt on 5/10/15.
 */
public class KnuthShuffle extends Sorter {

  public static void shuffle(Object[] a) {
    int N = a.length;

    for (int i = 0; i < N; i++) {
      int r = new Random().nextInt(i + 1);
      exch((Comparable[]) a, i, r);
    }
  }
}
