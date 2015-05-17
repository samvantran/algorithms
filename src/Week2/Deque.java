package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by svt on 5/10/15.
 *
 * Programming Assignment #2: Randomized Queues and Deques
 * Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement
 * elementary data structures using arrays and linked lists, and to introduce you to generics and iterators.
 *
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that
 * supports adding and removing items from either the front or the back of the data structure. Create a generic
 * data type Deque that implements the following API:
 *
 * Corner cases.
 * Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there
 * are no more items to return.
 *
 * Performance requirements.
 * Your deque implementation must support each deque operation in constant worst-case time and use space
 * proportional to the number of items currently in the deque. Additionally, your iterator implementation must
 * support each operation (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {

  private Node first, last, prev;
  private int size = 0;

  // construct an empty deque
  public Deque() {
    first = new Node();
    last = new Node();
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {

    if (item == null) {
      throw new NullPointerException();
    }

    if (first.item == null) {
      first.item = item;
      first.next = last;
      last = first;
    } else {
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.next = oldFirst;
    }
    size++;
  }

  // add the item to the end
  public void addLast(Item item) {

    if (item == null) {
      throw new NullPointerException();
    }

    if (last.item == null) {
      last.item = item;
      last.next = null;
      first = last;
    } else {
      Node oldLast = last;
      last = new Node();
      last.item = item;
      last.next = null;
      last.prev = oldLast;
      oldLast.next = last;
    }
    size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {

    if (size == 0) {
      throw new NoSuchElementException();
    }

    Node oldfirst = first;
    first = first.next;
    size--;
    return oldfirst.item;
  }

  // remove and return the item from the end
  public Item removeLast() {

    if (size == 0) {
      throw new NoSuchElementException();
    }

    Node oldLast = last;
    last = last.prev;
    last.next = null;
    size--;
    return oldLast.item;
  }

  // return an iterator over items in order from front to end
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  public static void main(String[] args) {
    Deque deque = new Deque();
    int a = 10;
    int b = 25;
    int c = 50;
    int z = 99;

    deque.addFirst(a);
    deque.addFirst(b);
    deque.addLast(c);
    deque.addLast(z);

    if (deque.isEmpty()) {
      System.out.println("This hasn't worked at all");
    } else {
      System.out.printf("The deque has %d elements.%n", deque.size());
    }

    deque.forEach(item -> System.out.println(item));

    System.out.println("Removing items now");

    deque.removeFirst();
    deque.removeLast();

    deque.forEach(item -> System.out.println(item));

  }  // unit testing

  private class Node {
    Item item;
    Node next;
    Node prev;
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() throws NoSuchElementException {
      Item item = current.item;
      current = current.next;
      return item;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
