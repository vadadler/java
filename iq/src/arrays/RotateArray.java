package arrays;

import java.util.Arrays;

public class RotateArray {
   public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6,7};
      int k = 3;   // How many elements to rotate.

      RotateArray ra = new RotateArray();
      ra.rotate(arr, k);
   }

   private void rotate(int[] arr, int k) {
      System.out.println("Before rotate:" + Arrays.toString(arr));

      int last = arr.length - 1;

      for(int i = 0; i < k; i++) {
         int temp = arr[i];
         arr[i] = arr[last];

         for(int ii = i + k; ii <= last; ii++) {
            int temp2 = arr[ii];
            arr[ii] = temp;
            temp = temp2;
         }
      }

      System.out.println("After rotate:" + Arrays.toString(arr));
   }
}
