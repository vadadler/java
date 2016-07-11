package puzzles;

public class StringToInt {

  public static void main(String[] args) {
    String str = "123";
    int result = 0;
    
    for(int i = 0; i < str.length(); i++) {
      result = (result * 10) + Character.getNumericValue(str.charAt(i));
      System.out.println("" + result);
    }
  }
}
