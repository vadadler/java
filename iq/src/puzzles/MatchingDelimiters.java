package puzzles;

import java.util.HashSet;
import java.util.Stack;

/**
 * Write an algorithm to determine if all of the delimiters in an expression are 
 * matched and closed.{(abc)22}[14(xyz)2] should pass. [ { ] } should fail
 * { (x) } [ should fail
 */
          
public class MatchingDelimiters {
  public static final char curlyOpen = '{';
  public static final char curlyClose = '}';
  public static final char squareOpen = '[';
  public static final char squareClose = ']';
  public static final char roundOpen = '(';
  public static final char roundClose = ')';
  
  private static final HashSet<Character> delims = new HashSet<Character>();
  static {
    delims.add(curlyOpen);
    delims.add(curlyClose);
    delims.add(squareOpen);
    delims.add(squareClose);
    delims.add(roundOpen);
    delims.add(roundClose);
  }
  
  public static void main(String[] args) {
    String input1 = "{(abc)22}[14(xyz)2]";
    String input2 = "{sb(rd)}{";
    
    System.out.println(input1 + " " + verify(input1));
    System.out.println(input2 + " " + verify(input2));
  }
  
  public static boolean verify(String input) {
    Stack<Character> buffer = new Stack<Character>();
    
    for(int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if(delims.contains(ch)) {
        if((ch == curlyClose && buffer.peek() == curlyOpen) || 
            (ch == squareClose && buffer.peek() == squareOpen) ||
            (ch == roundClose && buffer.peek() == roundOpen)) {
          buffer.pop();
        }
        else {
          buffer.push(ch);
        }
      }
    }
    
    return buffer.isEmpty() ? true : false;
  }
}
