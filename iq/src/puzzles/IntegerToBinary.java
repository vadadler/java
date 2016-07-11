package puzzles;

/**
 * Write a program that takes a positive integer N (in decimal) 
 * from the command line and prints out its binary representation
 *
 */
public class IntegerToBinary {
  public static void main(String[] args) {
    convert(127);
  }
  
  private static void convert(int i) {
    if(i == 0) return;
    convert(i/2);
    System.out.print("" + i%2);
  }
}
