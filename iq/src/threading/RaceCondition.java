package threading;

/**
 * Race condition occurs when multiple threads modify
 * shared resource (critical section).
 * Use thread synchronization to prevent race conditions.
 * Locks and atomic variables (from java.utils.concurrent package) 
 * could be used as well.
 *
 */
public class RaceCondition {
  private int counter = 0;
  
  /**
   * If increment() is not synchronized counter will be not
   * exactly 20000.
   */
  public /*synchronized*/ void increment() {
    counter++;
  }
  public void doWork() {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        for(int i = 0; i < 10000; i++) {
          increment();
        }
      }
    });
    
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        for(int i = 0; i < 10000; i++) {
          increment();
        }
      }
    });

    t1.start();
    t2.start();
    
    try {
      t1.join();
      t2.join();
    } 
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("Counter: " + counter);
  }

  public static void main(String[] args) {
    RaceCondition th = new RaceCondition();
    th.doWork();
  }
}
