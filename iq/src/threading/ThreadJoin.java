package threading;

/**
 * You have thread T1, T2 and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
 * Use Thread.join() method
 */

public class ThreadJoin {
   public static void main(String[] args) {
      //ThreadJoin tj = new ThreadJoin();
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               System.out.println("Thread: " + Thread.currentThread().getName());
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("In t1");
         }
      });

      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               System.out.println("Thread: " + Thread.currentThread().getName());
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("In t2");
         }
      });

      Thread t3 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               System.out.println("Thread: " + Thread.currentThread().getName());
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("In t3");
         }
      });

      try {
         System.out.println("Thread: " + Thread.currentThread().getName());
         t1.start();
         t1.join();

         t2.start();
         t2.join();

         t3.start();
         t3.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
