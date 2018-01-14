package arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {
   public static void main(String[] args) {
      int[] arr = {2,1,4,6,3,7,8};
      int[] arr2 = {1,0,2,1,2,1,0};
      
      DutchNationalFlagProblem dnp = new DutchNationalFlagProblem();
      System.out.println("Array before sorting: " + Arrays.toString(arr));
      dnp.oddBeforeEven(arr);
      System.out.println("Array after sorting: " + Arrays.toString(arr));

      System.out.println("Array before sorting: " + Arrays.toString(arr2));
      dnp.dnf(arr2);
      System.out.println("Array after sorting: " + Arrays.toString(arr2));
   }
   
   /**
    * This is a variation of DNF problem.
    * Input an array of integers. 
    * Output: rearrange the integers in place such that odd 
    * integers appear before even integers.
    * 
    * Asked: Meraki
    */
   private void oddBeforeEven(int[] arr) {
      int left = 0; 
      int right = arr.length - 1;
      
      while(left < right) {
         while((arr[left] % 2) != 0) left++;
         while((arr[right] % 2) == 0) right--;
         
         if(left < right) {
            int tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
         }
      }
   }

   /**
    * Given an array A[] consisting of 0s, 1s and 2s, write a function that sorts A[]. The functions should put all
    * 0s first, then all 1s and all 2s in last.
    *
    * Example:
    * Array before sorting: [1, 0, 2, 1, 2, 1, 0]
    * Array after sorting: [0, 0, 1, 1, 1, 2, 2]
    *
    * @param arr
    */
   private void dnf(int[] arr) {
      int lo = 0, mid = 0, tmp = 0, hi = arr.length -1;

      while(mid <= hi) {
         switch (arr[mid]) {
            case 0:
               tmp = arr[lo];
               arr[lo] = arr[mid];
               arr[mid] = tmp;
               lo++;
               mid++;
               break;
            case 1:
               mid++;
               break;
            case 2:
               tmp = arr[hi];
               arr[hi] = arr[mid];
               arr[mid] = tmp;
               hi--;
               break;
         }

         System.out.println(Arrays.toString(arr));
      }
   }
}
