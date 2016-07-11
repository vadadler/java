package puzzles;

/**
 * Euclid's algorithm finds greatest common divisor (GCD)of two numbers.
 * GCD is the largest number that divides both numbers without a remainder.
 *  
 * https://en.wikipedia.org/wiki/Euclidean_algorithm
 */

public class Euclid {
  public static void main(String[] args) {
    int v1 = 246, v2 = 12;
    System.out.println(gcd_recursive(v1, v2));
    System.out.println(gcd_iterative(v1, v2));
  }
  
  private static int gcd_recursive(int v1, int v2) {
    if(v2 == 0) return v1;
    return gcd_recursive(v2, v1%v2);
  }
  
  private static int gcd_iterative(int v1, int v2) {
    int temp = 0;
    while(v2 != 0) {
      temp = v2;
      v2 = v1 % v2;
      v1 = temp;
    }
    
    return v1;
  }
}
