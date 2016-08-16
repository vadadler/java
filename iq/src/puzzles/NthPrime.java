package puzzles;

/**
 * Write a method to find the nth prime number.
 *
 * Asked: Meraki
 */
public class NthPrime {
   public static void main(String[] args) {
      NthPrime nP = new NthPrime();
      System.out.println("3rd prime is " + nP.nthPrime(3));
   }
   
   private int nthPrime(int nth) {
      int cnt = 0;
      int num = 1;
      int i;
      
      while(cnt < nth) {
         num++;
         for(i = 2; i <= num; i++) {
            if(num % i == 0) {
               break;
            }
         }
         
         if(i == num) {
            cnt++;
         }
      }
      
      return num;
   }
}
