package arrays;

import java.util.Arrays;

public class FindLargestInteger {
   public static void main(String[] args) {
      int[] array = {5, 7, 8, 6, 3};

      FindLargestInteger fli = new FindLargestInteger();
      int max = fli.findLargest(array,0, array[0]);
      System.out.println("In " + Arrays.toString(array) + " max is " + max);

   }

   // Recursively find largest element in array.
   int findLargest(int[] a, int index, int max) {
      if (index == a.length - 1) {
         return max;
      }

      if(a[index] > max) {
         max = a[index];
      }

      return findLargest(a, index + 1, max);
   }
}
