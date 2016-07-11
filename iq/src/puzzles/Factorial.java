package puzzles;

import java.util.HashMap;

/**
 * F(N) = N*(N-1)*(N-2)*...1 
 *
 */

public class Factorial {
  public static void main(String[] args) {
    int n = 4;
    
    AppFactorial app = new AppFactorial();
    System.out.println(app.factorialIterative(n));
    System.out.println(app.factorialRecursive(n));
    System.out.println(app.factorialCache(n));
  }
}

class AppFactorial {
  HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
  
  public int factorialIterative(int n) {
    int result = 1;
    
    for(int i = n; i > 0; i--) {
      result = result * i;
    }
    
    return result;
  }
  
  public int factorialRecursive(int n) {
    if(n == 1) return 1;
    return n * factorialRecursive(n - 1);
  }
  
  public int factorialCache(int n) {
    if(cache.containsKey(n)) return cache.get(n);
    
    int result = n * factorialRecursive(n - 1);
    cache.put(n, result);
    return result;
  }
}