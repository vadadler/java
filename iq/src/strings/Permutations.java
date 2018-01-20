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

    p.permutate(one, "");

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

  private void permutate(String src, String chosen) {
     //System.out.println("permutation(" + src + ", " + chosen + ")");
     if(src.length() == 0) {
        System.out.println(chosen);
     }
     else {
        StringBuilder sbSrc = new StringBuilder(src);
        StringBuilder sbChosen = new StringBuilder(chosen);

        // Looping through all letters in src.
        for(int i = 0; i < src.length(); i++) {
           // Choose.

           Character c = src.charAt(i);
           // Remove character from i position.
           sbSrc.deleteCharAt(i);

           // Add character to the end of already chosen chars.
           sbChosen.append(c);

           // Explore.
           permutate(sbSrc.toString(), sbChosen.toString());

           // Unchoose/Undo. Put back as it was before.

           // Insert character at i position.
           sbSrc.insert(i, c);

           // Delete last character, added when we did choose.
           sbChosen.deleteCharAt(sbChosen.length() - 1);

           //src = sbSrc.toString();
           //chosen = sbChosen.toString();
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


