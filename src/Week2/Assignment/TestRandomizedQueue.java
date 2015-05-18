package Week2.Assignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRandomizedQueue {

  @Test
  public void testIsEmpty() throws Exception {
    RandomizedQueue rQ = new RandomizedQueue();
    assertTrue(rQ.isEmpty());

    rQ.enqueue("Hello, world!");
    assertFalse(rQ.isEmpty());
  }

  @Test
  public void testSize() throws Exception {
    RandomizedQueue rQ = new RandomizedQueue();
    assertTrue(rQ.size() == 0);

    rQ.enqueue(1);
    assertTrue(rQ.size() == 1);
  }

  @Test
  public void testEnqueue() throws Exception {
    RandomizedQueue rQ = new RandomizedQueue();
    rQ.enqueue(0);
    rQ.enqueue(1);
    rQ.enqueue(2);

    assertTrue(rQ.size() == 3);
  }

  @Test
  public void testDequeue() throws Exception {
    RandomizedQueue rQ = new RandomizedQueue();
    rQ.enqueue(0);
    rQ.enqueue(1);
    rQ.enqueue(2);

    rQ.dequeue();
    rQ.dequeue();

    assertTrue(rQ.size() == 1);
  }

  @Test
  public void testSample() throws Exception {
    RandomizedQueue rQ = new RandomizedQueue();
    rQ.enqueue(0);
    rQ.enqueue(1);
    rQ.enqueue(2);

    int sample = (Integer) rQ.sample();
    assertTrue(sample == 0 || sample == 1 || sample == 2);
  }
}