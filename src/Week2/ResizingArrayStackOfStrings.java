package Week2;

/**
 * Created by svt on 5/6/15.
 *
 * Resizing array implementation of Stacks that does not require capacity specification
 *
 * For push() -- resizing array via 'repeated doubling' costs ~3N array accesses ie O(N) time
 * For pop()  -- halving array at 1/4 size is also an O(N) operation
 */
public class ResizingArrayStackOfStrings {

  private String[] s;
  private int N = 0;

  public ResizingArrayStackOfStrings() {
    s = new String[1];
  }

  public void push(String item) {
    if (N == s.length) {
      resize(2 * s.length);
    }
    s[N++] = item;
  }

  public String pop() {
    String item = s[--N];
    s[N] = null;
    if (N > 0 && N == s.length / 4) {
      resize(s.length / 2);
    }
    return item;
  }

  public void resize(int capacity) {
    String[] copy = new String[capacity];
    for (int i = 0; i < N; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }
}
