package threading;

public class Main {
   public static void main(String[] args) throws Exception {
      // BlockingQueue example.
      BlockingQueue bq = new BlockingQueue();

      Producer producer = new Producer(bq);
      Consumer consumer = new Consumer(bq);

      new Thread(producer).start();
      new Thread(consumer).start();

      Thread.sleep(4000);
   }
}
