package searching;

import java.util.Vector;

/**
 * Print all possible outcomes of rollin N number of dice.
 */

public class Dice {
   public static void main(String[] args) {
      Dice dr = new Dice();
      int n = 2;
      dr.diceRoll(n, new Vector<Integer>(n));
   }

   private void diceRoll(int n, Vector<Integer> chosen) {
      System.out.println("diceRoll(" + n + ", " + chosen.toString() + ")");

      // Base case
      if(n == 0) {
         System.out.println(chosen.toString());
      } else {
        // Some dice left to roll. Handle each side (total of 6).
         for(int i = 1; i <= 6; i++) {
            // Choose.
            chosen.add(i);

            // Explore.
            diceRoll(n - 1, chosen);

            // Unchoose.
            chosen.remove(chosen.size() - 1);
         }
      }
   }
}
