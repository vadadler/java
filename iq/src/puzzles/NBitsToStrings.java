package puzzles;

/**
 * Generate all strings of n bits.
 * n = 2 : 00, 01, 10, 11
 * 
 * Recur­sion is key here.
 * 1. Cre­ate a inte­ger array of size n.
 * 2. Now if we think of every bit, it can take 2 val­ues, 0 and 1.
 * 3. start­ing from the end of the string, set the bit 0 and 1 and make recur­sive calls
 *
 * Complexity: O(2^n)
 */
public class NBitsToStrings {
   static int[] arr;

   public static void main(String[] args) {
      int n = 2;
      arr = new int[n];
//      nBitsString(n);
//      printBinary(3, "");
      printDecimal(2, "");
   }

   private static void nBitsString(int n) {
      if (n <= 0) {
         System.out.println(java.util.Arrays.toString(arr));
      } else {
         arr[n - 1] = 0;
         nBitsString(n - 1);
         arr[n - 1] = 1;
         nBitsString(n - 1);
      }
   }

   /**
    * Print every binary number that has exactly the given number or digits.
    *
    * @param n
    * @param prefix
    */
   private static void printBinary(int n, String prefix) {
      System.out.println("printBinary(" + n + ", " + prefix + ")");
      if (n == 0) {
         System.out.println(prefix);
      } else {
         printBinary(n - 1, prefix + "0");
         printBinary(n - 1, prefix + "1");
      }
   }

   /**
    * Print all decimal (base 10) numbers that has exactly the same number of digits.
    */
   private static void printDecimal(int n, String prefix) {
      System.out.println("printDecimal(" + n + ", " + prefix + ")");
      if (n == 0) {
         System.out.println(prefix);
      } else {
         for (int i = 0; i < 10; i++) {
            printDecimal(n - 1, prefix + i);
         }
      }
   }
}
