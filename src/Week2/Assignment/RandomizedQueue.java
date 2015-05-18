package Week2.Assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by svt on 5/17/15.
 *
 * A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random
 * from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:
 *
 * Corner cases.
 * The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must
 * maintain its own random order. Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there
 * are no more items to return.
 *
 * Performance requirements. Your randomized queue implementation must support each randomized queue operation
 * (besides creating an iterator) in constant amortized time and use space proportional to the number of items
 * currently in the queue. That is, any sequence of M randomized queue operations (starting from an empty queue)
 * should take at most cM steps in the worst case, for some constant c. Additionally, your iterator implementation
 * must support operations next() and hasNext() in constant worst-case time; and construction in linear time; you
 * may use a linear amount of extra memory per iterator.

 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size = 0;
    private Random random = new Random();

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (size + 1 >= queue.length) {
            resizeQueue(queue.length * 2);
        }

        if (size == 0) {
            queue[size] = item;
        } else {
            int r = random.nextInt(size);
            Item firstItem = queue[r];
            queue[r] = item;
            queue[size] = firstItem;
        }
        size++;
    }

    // remove and return a random item
    public Item dequeue() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        int r = random.nextInt(size);
        Item item = queue[r];
        size--;
        queue[r] = queue[size];
        queue[size] = null;

        if (size > 0 && size <= queue.length / 4) {
            resizeQueue(queue.length / 2);
        }
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        int r = random.nextInt(size);
        return queue[r];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing
    public static void main(String[] args) {
        RandomizedQueue queue = new RandomizedQueue();

        for (int i = 0; i < 30; i += 5) {
            queue.enqueue(i);
        }

        queue.forEach(item -> System.out.println(item));

        System.out.println("Sampled: " + queue.sample());

        if (queue.isEmpty()){
            System.out.println("Queue is empty!");
        } else {
            System.out.printf("Queue has %d items%n", queue.size());
        }

        System.out.println("Removing items");
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
        }

        System.out.printf("Queue has %d items%n", queue.size());
        queue.forEach(item -> System.out.println(item));
    }

    private class ListIterator implements Iterator<Item> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return queue[count] != null;
        }

        @Override
        public Item next() {
            return queue[count++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resizeQueue(int size) {
        Item[] copy = queue;
        queue = (Item[]) new Object[size];

        for (int i = 0; i < copy.length; i++) {
            queue[i] = copy[i];
        }
    }
}
