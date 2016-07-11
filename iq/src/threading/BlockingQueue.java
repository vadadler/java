package threading;

/**
 * A blocking queue is a queue that blocks when you try to dequeue from it 
 * and the queue is empty, or if you try to enqueue items to it and the queue 
 * is already full. A thread trying to dequeue from an empty queue is blocked 
 * until some other thread inserts an item into the queue. A thread trying to 
 * enqueue an item in a full queue is blocked until some other thread makes space 
 * in the queue, either by dequeuing one or more items or clearing the queue completely.
 * 
 * more info http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */

public class BlockingQueue {
  private int limit = 7;
  private java.util.LinkedList<Object> queue = new java.util.LinkedList<Object>();
  
  public synchronized void enqueue(Object item) throws InterruptedException {
    while(queue.size() == limit) {
      System.out.println("Enqueue: Queue is full");
      wait();
    }
    
    if(queue.size() == 0) {
      System.out.println("Enqueue: Queue is empty");
      notifyAll();
    }
    
    System.out.println("Enqueue: " + item);
    queue.add(item);
  }
  
  public synchronized Object dequeue() throws InterruptedException{
    while(queue.size() == 0) {
      System.out.println("Dequeue: Queue is empty");
      wait();
    }
    
    if(queue.size() == limit) {
      System.out.println("Dequeue: Queue is full");
      notifyAll();
    }
    
    System.out.println("Dequeue: " + queue.peek());
    return queue.remove(0);
  }
}
