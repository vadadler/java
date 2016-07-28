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
  	int[] a = {5,1,4,2};
  	
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
     if(low == high) {
    	 return;	// Single element array. No need to sort.
     }
     else {
    	 System.out.println("mergeSort: " + low + ":" + high);
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
  	 System.out.println("low=" + low + " middle=" + middle + " high=" + high);
     // Copy data into helper array.
     for(int i = low; i <= high; i++) {
       tmp[i] = arr[i];
     }
     
     int left = low;
     int right = middle + 1;
     int current = low;	// Index into temp array.
     
     // Copy smallest value from either side into original array.
     while(left <= middle && right <= high) {
       if(tmp[left] <= tmp[right]) {	// Left element is smaller.
         arr[current++] = tmp[left++];
       }
       else {													// Right element is smaller.
      	 arr[current++] = tmp[right++];
       }
     }
     
     // Copy the rest of the left side. Right side is already sorted due to
     // the fact that left side is shorter or equal to the right side. 
     // When merging two arrays starting with the smaller array (left) by the
     // time merging logic runs out of left elements the right array will be sorted.
     int remaining = middle - left;
     System.out.println("remaining=" + remaining + " middle=" + middle + " left=" + left);
     for(int i = 0; i <= remaining; i++) {
    	 arr[current + i] = tmp[left + i];
     }
   }   
   
   public void merge2(int low, int middle, int high) {
     int left = low;
     int right = middle + 1;
     int current = low;	// Index into temp array.
     
     // Copy smallest value from either side into original array.
     while(left <= middle && right <= high) {
       if(tmp[left] <= tmp[right]) {	// Left element is smaller.
         tmp[current++] = arr[left++];
       }
       else {													// Right element is smaller.
      	 tmp[current++] = arr[right++];
       }
     }
     
     // Copy the rest of the left side.
     while(left <= middle) {
    	 tmp[current++] = arr[left++];
     }
     
     // Copy the rest of the right side.
     while(middle <= high) {
    	 tmp[current++] = arr[middle++];
     }
     
     // Copy elements from temp array.
     for(int i = 0; i < (high - low + 1); i++) {
    	 arr[low + i] = tmp[i];
     }
   }
}
