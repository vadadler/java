package puzzles;

public class StringReverse {

  public static void main(String[] args) {
    String inStr = "abcdef";
    System.out.println(inStr);
    System.out.println(reverseIterative(inStr));
    System.out.println(inStr);
    System.out.println(reverseRecursive(inStr));
  }
  
  static String reverseIterative(String strIn) {
    String strOut = "";
    
    for(int i = 0, j = strIn.length() - 1; j >= 0; i++, j--) {
      strOut = strOut.concat("" + strIn.charAt(j));
    }
    
    return strOut;
  }
  
  static String reverseRecursive(String inStr) {
    if(inStr.length() == 1) return "" + inStr.charAt(0);
    return reverseRecursive(inStr.substring(1, inStr.length())) + inStr.charAt(0);
  }
}
