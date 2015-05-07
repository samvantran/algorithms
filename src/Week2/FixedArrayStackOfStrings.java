package Week2;

/**
 * Created by svt on 5/6/15.
 *
 * Array implementation of Stacks
 *
 */
public class FixedArrayStackOfStrings {

  private String[] s;
  private int N = 0;

  public FixedArrayStackOfStrings(int capacity) {  // cheating by forcing client to specify array size
    s = new String[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(String item) {
    s[N++] = item;
  }

  public String pop() {
    String item = s[--N];
    s[N] = null;           // avoid 'loitering' by setting reference to null
    return item;           // so garbage collection can reclaim memory if there are no outstanding references
  }
}
