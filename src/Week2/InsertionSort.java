package Week2;

/**
 * Created by svt on 5/10/15.
 *
 * Insertion sort iterates through array, finds the index of the smallest entry
 * and swaps it with each larger entry to its left
 */
public class InsertionSort extends Sorter {

  public static void sort(Comparable[] a) {
    int N = a.length;

    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0; j--) {
        if (less(a[j], a[j-1])) {
          exch(a, j, j-1);
        }
        else break;
      }
    }
  }



}
