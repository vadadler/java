package strings;

/**
 * Print all permutations of a string.
 *
 */
public class Permutations {

  public static void main(String[] args) {
    perm("", "abc");
  }
    
  public static void perm(String prefix, String str) {
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
}


