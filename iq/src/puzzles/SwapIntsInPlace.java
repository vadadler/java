package puzzles;

public class SwapIntsInPlace {
  public static void main(String[] args) {
    int a = 9;
    int b = 5;
    
    System.out.println("a=" + a + " b=" + b);
    
    a = a - b;  // 4
    b = b + a;  // 9
    a = b - a;  // 5
    
    System.out.println("a=" + a + " b=" + b);
    
    // Using bit manipulation (XOR).
    a = a ^ b; // 1001^0101=1100
    b = b ^ a; // 0101^1100=1001 == 9
    a = b ^ a; // 1001^1100=0101 == 5
    
    System.out.println("a=" + a + " b=" + b);
  }
}
