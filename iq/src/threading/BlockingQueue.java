package threading;

/**
 * Usage: A BlockingQueue is typically used to have one thread produce objects, which another thread consumes.
 *
 * A blocking queue is a queue that blocks when you try to dequeue from it 
 * and the queue is empty, or if you try to enqueue items to it and the queue 
 * is already full. A thread trying to dequeue from an empty queue is blocked 
 * until some other thread inserts an item into the queue. A thread trying to 
 * enqueue an item in a full queue is blocked until some other thread makes space 
 * in the queue, either by dequeuing one or more items or clearing the queue completely.
 * 
 * more info http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 *
 * The Object class in java contains three final methods that allows threads to communicate about the lock status
 * of a resource: wait(), notify() and notifyAll().
 *
 * wait()
 * Object wait methods has three variance, one which waits indefinitely for any other thread to call notify or notifyAll
 * method on the object to wake up the current thread. Other two variances puts the current thread in wait for specific
 * amount of time before they wake up.
 *
 * notify()
 * notify method wakes up only one thread waiting on the object and that thread starts execution. So if there are multiple
 * threads waiting for an object, this method will wake up only one of them. The choice of the thread to wake depends on
 * the OS implementation of thread management.
 *
 * notifyAll()
 * notifyAll method wakes up all the threads waiting on the object, although which one will process first depends on
 * the OS implementation.
 */

public class BlockingQueue {
  private int limit = 3;
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

class Producer implements Runnable {
   protected BlockingQueue queue = null;

   public Producer(BlockingQueue q) {
      queue = q;
   }

   @Override
   public void run() {
      try {
         queue.enqueue(1);
         Thread.sleep(1000);

         queue.enqueue(2);
         Thread.sleep(1000);


         queue.enqueue(3);
         Thread.sleep(1000);

         queue.enqueue(4);
         Thread.sleep(1000);

//         queue.enqueue(5);
//         Thread.sleep(1000);
//
//         queue.enqueue(6);
//         Thread.sleep(1000);
//
//         queue.enqueue(7);
//         Thread.sleep(1000);
//
//         queue.enqueue(8);
//         Thread.sleep(1000);


      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}

class Consumer implements Runnable {
   protected BlockingQueue queue = null;

   public Consumer(BlockingQueue q) {
      queue = q;
   }

   @Override
   public void run() {
      try {
         queue.dequeue();
         Thread.sleep(1000);
         queue.dequeue();
         Thread.sleep(1000);
         queue.dequeue();
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}