package puzzles;

public class HexToInt {
  public static void main(String[] args) {
    String hex = "FFFF";
    int result = 0;
    
    for(int i = 0, j = hex.length() - 1; j >= 0; i++, j--) {
      char ch = hex.charAt(j);
      result += Math.pow(16, i) * char2Int(ch);
    }
    
    System.out.println("Hex " + hex + " is " + result + " decimal");
  }
  
  private static int char2Int(char ch) {
    switch (ch) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
        return Character.getNumericValue(ch);
      case 'a':
      case 'A':
        return 10;
      case 'b':
      case 'B':
        return 11;
      case 'c':
      case 'C':
        return 12;
      case 'd':
      case 'D':
        return 13;
      case 'e':
      case 'E':
        return 14;
      case 'f':
      case 'F':
        return 15;
      default:
        return -1;
    }
  }
}
