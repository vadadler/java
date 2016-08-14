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
 * which is {{3,2,1},{6,5,4},{9,8,7}} 
 * 
 * converted to
 * 
 * {{3,2,1},{6,5,4},{9,8,7}}
 *
 */
public class FlipHorizontally {
   public static void main(String[] args) {
      int[][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
      int[][] m2 = {{1,0,0},{0,0,1}};
      int[][] m3 = {{1,0},{}};
      int[][] m4 = {{1},{}};
      
      System.out.println("Before flip");
      printArray(m3);
      flipHorizontallyInPlace(m3);
      System.out.println("After flip");
      printArray(m3);
   }
   
   private static void flipHorizontallyInPlace(int[][] m) {
      for(int[] a : m) {
         for(int i = 0, j = a.length - 1; i < a.length - 1 && i != j; i++, j--) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
         }
      }
   }
   
   private static void printArray(int[][] arr) {
      for(int[] a : arr) {
         System.out.println(Arrays.toString(a));
      }      
   }
}
