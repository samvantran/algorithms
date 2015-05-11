package Week2;

/**
 * Created by svt on 5/10/15.
 *
 * Selection sort iterates through array, finds the index of the smallest entry
 * and swaps it with the current index.
 * */
public class SelectionSort extends Sorter {

  public static void sort(Comparable[] a) {

    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }
}
