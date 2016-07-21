package puzzles;

public class BinaryToInt {
  public static void main(String[] args) {
    String b = "1000";
    int result = 0;
    
    for(int j = 0, i = b.length() - 1; i >= 0; i--, j++) {
      if(b.charAt(i) == '1') {
        result += Math.pow(2, j);
      }
    }
    
    System.out.println("Binary " + b + " is decimal " + result);
  }
}
