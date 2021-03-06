package matricies;

import java.util.Arrays;

/**
 * You are given an m x n 2D image matrix where each integer represents a pixel. 
 * Flip it in-place along its vertical axis.
 * 
 * 1,2,3
 * 4,5,6
 * 7,8,9
 * 
 * which is {{1,2,3},{4,5,6},{7,8,9}} 
 * 
 * converted to {{7,8,9},{4,5,6},{1,2,3}}
 *
 */
public class FlipHorizontally {
   public static void main(String[] args) {
      int[][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
      int[][] m2 = {{1,0,0},{0,0,1}};
      int[][] m3 = {{1,0},{}};
      int[][] m4 = {{1},{}};
      
      System.out.println("Before flip");
      printArray(m1);
      flipHorizontallyInPlace(m1);
      System.out.println("After flip");
      printArray(m1);
   }
   
   private static void flipHorizontallyInPlace(int[][] m) {
      for(int j = 0,  i = m.length - 1; i > 0 && i != j; i--, j++) {
         int[] temp = new int[m[j].length];
         temp = m[j];
         m[j] = m[i];
         m[i] = temp;
      }
   }
   
   private static void printArray(int[][] arr) {
      for(int[] a : arr) {
         System.out.println(Arrays.toString(a));
      }      
   }
}
