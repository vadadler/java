package threading;

/**
 * Deadlock describes a situation where two or more threads are blocked 
 * forever, waiting for each other. Deadlock occurs when multiple threads 
 * need the same locks but obtain them in different order. A Java 
 * multithreaded program may suffer from the deadlock condition because 
 * the synchronized keyword causes the executing thread to block while 
 * waiting for the lock, or monitor, associated with the specified object.
 *
 */
public class Deadlock {
  public static void main(String[] args) {
    AppDeadlock app = new AppDeadlock();
    app.deadlock();
    //app.noDeadlock();
  }

}

class AppDeadlock {
  Object lock1 = new Object();
  Object lock2 = new Object();
  
  public void deadlock() {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        synchronized(lock1) {
          System.out.println("Thread1 holds lock1");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("Thread1 waiting for lock2");
          synchronized(lock2) {
            System.out.println("Thread1 holds lock1 and lock2");
          }
        }
      }
    });
    
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        synchronized(lock2) {
          System.out.println("Thread2 holds lock2");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("Thread2 waiting for lock1");
          synchronized(lock1) {
            System.out.println("Thread2 holds lock2 and lock1");
          }
        }
      }
    });

    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public void noDeadlock() {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        synchronized(lock1) {
          System.out.println("Thread1 holds lock1");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("Thread1 waiting for lock2");
          synchronized(lock2) {
            System.out.println("Thread1 holds lock1 and lock2");
          }
        }
      }
    });
    
    Thread t2 = new Thread(new Runnable() {
      public void run() {
        synchronized(lock1) {
          System.out.println("Thread2 holds lock1");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("Thread2 waiting for lock2");
          synchronized(lock2) {
            System.out.println("Thread2 holds lock2 and lock1");
          }
        }
      }
    });

    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}