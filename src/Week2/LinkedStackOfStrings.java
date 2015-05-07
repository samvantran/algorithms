package Week2;

/**
 * Created by svt on 5/6/15.
 *
 * Linked-list implementation for a Stack
 *
 * Every operation costs O(1) time
 * With N elements, a stack uses ~40N bytes per stack node
 */
public class LinkedStackOfStrings {

  private Node first = null;

  public boolean isEmpty() {
    return first == null;
  }

  public String pop() {
    String item = first.item;   // save item to return
    first = first.next;         // delete first node
    return item;                // return saved item
  }

  public void push(String word) {
    Node oldfirst = first;  // save a link to the list
    first = new Node();     // create new node for the beginning
    first.item = word;      // set the instance variables in the new node
    first.next = oldfirst;
  }

  // inner class
  private class Node {
    String item;
    Node next;
  }
}
