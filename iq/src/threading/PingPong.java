package threading;

public class PingPong {
   public static void main(String[] args) {
      Object lock = 0;
      int MAX_PING_PONG = 10;

      Thread ping = new Thread(new Runnable() {
         @Override
         public void run() {
            int cnt = 1;
            try {
               while(cnt <= MAX_PING_PONG) {
                  synchronized(lock) {
                     System.out.println("ping " + cnt++);
                     lock.notify();
                     lock.wait();

                  }
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      Thread pong = new Thread(new Runnable() {
         @Override
         public void run() {
            int cnt = 1;
            try {
               while(cnt <= MAX_PING_PONG) {
                  synchronized(lock) {
                     System.out.println("pong " + cnt++);
                     lock.notify();
                     lock.wait();

                  }
               }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      });

      ping.start();
      pong.start();
   }
}
