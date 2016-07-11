package puzzles;

public class Permutations {

  public static void main(String[] args) {
    String str = "ABC";
    char[] arr = {'A','B','C'};
    
    perm11("abc");
    //perm3("", "abc");
  }
  
  // print n! permutation of the characters of the string s (in order)
  public  static void perm1(String s) { perm1("", s); }
  public  static void perm11(String s) { perm11("", s, 0, s.length()); }
  
  private static void perm1(String prefix, String s) {
    System.out.println(prefix + ":" + s);
    int n = s.length();
    if (n == 0) System.out.println(prefix);
    else {
      for (int i = 0; i < n; i++)
       perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
    }
  }

  private static void perm11(String prefix, String s, int ii, int nn) {
    System.out.println(prefix + ":" + s + " i=" + ii + " n=" + nn);
    int n = s.length();
    if (n == 0) System.out.println(prefix);
    else {
      for (int i = 0; i < n; i++) {
       //System.out.println("BEFORE: " + prefix + s.charAt(i) + ":" + s.substring(0, i) + s.substring(i+1, n) + " i=" + i + " n=" + n);
       perm11(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), i, n);
      // System.out.println("AFTER: " + prefix + ":" + s + " " + prefix + s.charAt(i) + ":" + s.substring(0, i) + s.substring(i+1, n) + " i=" + i + " n=" + n);
      }
    }
  }

  //print n! permutation of the characters of the string s (not in order)
  public static void perm2(String s) {
    char[] a = new char[s.length()];
    for(int i = 0; i < a.length; i++) {
      a[i] = s.charAt(i);
    }
    
    perm2(a, s.length()); 
  }
  
  // Does not work yet.
  public static void perm2(char[] a, int n) {
    if(n == 1) {
      System.out.println(a);
      return;
    }
    
    for(int i = 0; i < n; n++) {
      swap(a, i, n-1);
      perm2(a, n-1);
      swap(a, i, n-1);
    }
  }
  
  public static void swap(char[]a, int i, int j) {
    char tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
  
  public static void perm3(String prefix, String str) {
    int len = str.length();
    if(len == 0) {
      System.out.println(prefix);
    }
    else {
      for(int i = 0; i < str.length(); i++) {
        perm3(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len));
      }
    }
  }
}


