package Week2;

/**
 * Created by svt on 5/10/15.
 *
 * Shellsort iterates through array and moves entries more than one position at a time by h-sorting
 */
public class ShellSort extends Sorter {

  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;

    while (h < N / 3) {
      h = 3 * h + 1;      // 1, 4, 13, 40 ... (3h+1 sequence)
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = 1; j >= h && less(a[j], a[j-h]); j -= h) {
          exch(a, j, j-h);
        }
      }
      h = h / 3;
    }
  }
}
