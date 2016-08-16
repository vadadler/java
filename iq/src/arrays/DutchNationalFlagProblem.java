package arrays;

import java.util.Arrays;

public class DutchNationalFlagProblem {
   public static void main(String[] args) {
      int[] arr = {2,1,4,6,3,7,8};
      
      DutchNationalFlagProblem dnp = new DutchNationalFlagProblem();
      System.out.println("Array before sorting: " + Arrays.toString(arr));
      dnp.oddBeforeEven(arr);
      System.out.println("Array after sorting: " + Arrays.toString(arr));
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
         while((arr[left] % 2) == 0) left++;
         while((arr[right] % 2) != 0) right--;
         
         if(left < right) {
            int tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
         }
      }
   }
}
