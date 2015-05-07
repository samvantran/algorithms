package Week2;

/**
 * Created by svt on 5/6/15.
 *
 * Fixed array implementation of Generic Stacks
 *
 */
public class GenericFixedArrayStack<Item> {

  private Item[] s;
  private int N = 0;

  public GenericFixedArrayStack(int capacity) {
    s = (Item[]) new Object[capacity];      // must cast bc Java doesn't allow generic array creation
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(Item item) {
    s[N++] = item;
  }

  public Item pop() {
    Item item = s[--N];
    s[N] = null;
    return item;
  }
}
