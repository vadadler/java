package sorting;

import java.util.Arrays;

/**
 * Divide and conquer algorithm.
 * 
 * Recursively divide array in halves until arrays contain 1 element.
 * Merge resulting arrays.
 * 
 * Time complexity O(nlog(n)) 
 */
public class MergeSort {
  int[] arr;
  int[] tmp;
  
  public static void main(String[] args) {
  	int[] a = {1,4,5,2,8,7};
  	
  	System.out.println("Array before sort: " + Arrays.toString(a));
  	
  	MergeSort ms = new MergeSort(a);
  	ms.sort();
  	
  	System.out.println("Array after sort: " + Arrays.toString(a));
  }
   
  public MergeSort(int[] data) {
  	arr = data;
    tmp = new int[arr.length];
  }
   
   public void sort() {
  	 mergeSort(0, arr.length - 1);
   }
   
   /**
    * Recursively call itself until there is only one element
    * in array.
    * @param low beginning of the array.
    * @param high end of the array.
    */
   public void mergeSort(int low, int high) {
     // Check if low is smaller then high, if not then the array is sorted.
     if(low < high) {
       int middle = (low + high) / 2;
       mergeSort(low, middle);        // Sort left side.
       mergeSort(middle + 1, high);   // Sort right side.
       merge(low, middle, high);      // Merge.
     }
   }
   
   /**
    * Do the merge.
    * @param low beginning of the left array.
    * @param middle end of left array.
    * @param high end of right array.
    */
   public void merge(int low, int middle, int high) {
     // Copy data into helper array.
     for(int i = low; i <= high; i++) {
       tmp[i] = arr[i];
     }
     
     System.out.println(Arrays.toString(tmp));
     
     int left = low;
     int right = middle + 1;
     int current = left;
     
     // Copy smallest value from either side into original array.
     while(left <= middle && right <= high) {
       if(tmp[left] <= tmp[right]) {	// Left element is smaller.
         arr[current] = tmp[left];
         left++;
       }
       else {													// Right element is smaller.
      	 arr[current] = tmp[right];
      	 right++;
       }
       current++;
     }
     
     // Copy the rest of the left side.
     int remaining = middle - left;
     for(int i = 0; i < remaining; i++) {
    	 arr[current + i] = tmp[left + i];
     }
     
     // Copy the rest of the right side.
     remaining = high - middle -1;
     //for(int i = 0; i < remaining; i++) {
    //	 arr[current + i] = tmp[left + 1];
     //}

     //System.out.println(Arrays.toString(arr));
   }
}
