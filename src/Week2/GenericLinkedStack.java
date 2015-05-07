package Week2;

/**
 * Created by svt on 5/6/15.
 *
 * Linked-list implementation for a Generic Stack
 */
public class GenericLinkedStack<Item> {

  private Node first = null;

  public boolean isEmpty() {
    return first == null;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    return item;
  }

  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
  }

  // inner class
  private class Node {
    Item item;
    Node next;
  }
}
