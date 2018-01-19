package strings;

import java.util.Arrays;

/**
 * Print all permutations of a string.
 *
 */
public class Permutations {

  public static void main(String[] args) {
    Permutations p = new Permutations();
    p.perm("", "abc");

    String one = "abc", two = "cab";

    System.out.println("is " + one + " a permutation of " + two +  " ? " + isPermutation(one, two));

  }
    
  private void perm(String prefix, String str) {
  	System.out.println(prefix + ":" + str);
  	
    int len = str.length();
    if(len == 0) {
      System.out.println(prefix);
    }
    else {
      for(int i = 0; i < str.length(); i++) {
        perm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len));
      }
    }
  }

  /**
   * Given two strings write a method which decides if one string is a permutation of another.
   */
  static boolean isPermutation(String one, String two) {
    if(one.length() != two.length()) return false;

    char[] aOne = one.toLowerCase().toCharArray();
    char[] aTwo = two.toLowerCase().toCharArray();

    Arrays.sort(aOne);
    Arrays.sort(aTwo);
    return Arrays.compare(aOne, aTwo) == 0;
  }
}


