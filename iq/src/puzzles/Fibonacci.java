package puzzles;

import java.util.HashMap;

public class Fibonacci {
  public static void main(String[] args) {
    App app = new App();
    int n = 8;
    System.out.println("Number: " + n);
    System.out.println("Iterative: " + app.fibIterative(n));
    System.out.println("Recursive: " + app.fibRecurse(n));
    System.out.println("Multithreaded: " + app.fibMultithreaded(n));
    System.out.println("DP Memoized: " + app.fibMemoized(n));
    System.out.println("DP Bottom up: " + app.fibBottomUp(n));
  }
}

class App {
  HashMap<Integer, Integer> fibCache = new HashMap<Integer, Integer>();
  
  public int fibIterative(int n) {
    if(n == 0) return 0; 
    if(n < 3) return 1;
    
    int n1 = 1;
    int n2 = 1;
    int sum = 0;
    for(int i = 3; i <= n; i++) {
      sum = n1 + n2;
      n2 = n1;
      n1 = sum;
    }
    return sum;
  }
  
  public int fibRecurse(int n) {
    if(n == 0) return 0; 
    if(n < 3) return 1;

    return (fibRecurse(n - 2) + fibRecurse(n - 1));
  }
  
  public int fibMultithreaded(int n) {
    FibMultithreaded fib = new FibMultithreaded(n);
    fib.start();
    try {
      fib.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    return fib.result;
  }
  
  /**
   * Dynamic programming (DP) approach. Store (memoize, not a misspell) results of sub-problems
   * so that they don't have to be solved again (like in recursive approach). 
   */
  public int fibMemoized(int n) {
    int f = 0;
    if(fibCache.containsKey(n)) 
      return fibCache.get(n);
    else {
      //if(n == 0) fibCache.put(0, 0);
      if(n <= 2) f = 1;

      f = fibRecurse(n - 2) + fibRecurse(n - 1);
      fibCache.put(n, f);
      return f;
    }
  }
    
  /**
   * Another DP approach - bottom up.
   * Saves space.
   */
  public int fibBottomUp(int n) {
    int f = 0;
    for(int i = 1; i <= n; i++) {
      if(i <= 2) {
        f = 1;
      }
      else {
        f = fibCache.get(i - 1) + fibCache.get(i - 2);
      }
      fibCache.put(i, f);
    }
    return f;
  }
}

class FibMultithreaded extends Thread {
  int result;
  int n;
  
  public FibMultithreaded(int num) { n = num; }
  
  public void run() {
    if(n == 0) result = 0;
    if(n < 3) result = 1;
    else {
      FibMultithreaded t1 = new FibMultithreaded(n - 2);
      FibMultithreaded t2 = new FibMultithreaded(n - 1);
      
      t1.start();
      t2.start();
      
      try {
        t1.join();
        t2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      result = t1.result + t2.result;
    }
  }
}