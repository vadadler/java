package puzzles;

import java.util.HashMap;

/**
 * In combinatorics C(n,m) = C(n-1,m) + C(n-1,m-1)
 *          1
 *        1   1
 *      1   2   1
 *    1   3   3   1
 *   1   4   6   4   1
 *  1  5  10  10  5   1
 *  
 * Each row begins and ends with the number one. The remaining numbers are obtained by summing 
 * the two numbers that lie directly above that number on the previous row and the number that 
 * follows it. Number of elements in a row equals the number of the row.
 *
 */
public class PascalTriangle {

  public static void main(String[] args) {
    int arr[][];
    AppPascal app = new AppPascal(4);
    app.pascalIterative();
    app.printPascal();
    
    app = new AppPascal(4);
    app.pascalRecursive();
    
    app = new AppPascal(4);
    app.pascalCache();
  }
}

class AppPascal {
  int arr[][];
  int size;
  HashMap<String, Integer> cache;
  
  public AppPascal(int n) {
    arr = new int[n][n];
    size = n;
    cache = new HashMap<String,Integer>();
  }
  
  public void printPascal() {
    for(int i= 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  /**
   * j - rows
   * i - columns
   */
  public void pascalIterative() {
    for(int j= 0; j < size; j++) {
      for(int i = 0; i < j + 1; i++) {
        if(i == 0 || i == size - 1 || i == j) {
          arr[j][i] = 1;
        }
        else {
          if(i > 0 && j > 0)
            arr[j][i] = arr[j - 1][i] + arr[j - 1][i - 1];
        }
      }
    }
  }
  
  public void pascalRecursive() {
    for(int j = 0; j < size; j++) {
      for(int i = 0; i < j + 1; i++) {
        System.out.print(pascalRecursive(j, i));    
      }
      System.out.println();
    }
  }
  
  private int pascalRecursive(int row, int col) {
    if(col == 0 || col == row) 
      return 1;
    else
      return (pascalRecursive(row - 1, col) + pascalRecursive(row - 1, col - 1));
  }
  
  public void pascalCache() {
    for(int j = 0; j < size; j++) {
      for(int i = 0; i < j + 1; i++) {
        System.out.print(pascalCache(j, i));
      }
      System.out.println();
    }
  }
  
  private int pascalCache(int row, int col) {
    if(cache.containsKey("" + row + col)) return cache.get("" + row + col);
   
    int value = pascalRecursive(row, col);
    cache.put("" + row + col, value);
    return value;
  }
  
  // You can use custom key for cache. The Key object
  // must @Override Object's equals() and hashCode().
  class Key {
    public int row, col;
    public Key(int r, int c) {
      row = r;
      col = c;
    }
  }
}
