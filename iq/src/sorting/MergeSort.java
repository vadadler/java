package sorting;

/**
 * Divide and conquer algorithm.
 * 
 * Recursively divide array in halves until arrays contain 1 element.
 * Merge resulting arrays.
 * 
 * Worse case time complexity O(nlog(n)) 
 *
 */
public class MergeSort {
  int[] arr;
  int[] tmp;
  
   public MergeSort(int[] data) {
     arr = data;
     tmp = new int[arr.length];
   }
   
   public void sort() {
     mergesort(0, arr.length - 1);
   }
   
   public void mergesort(int low, int high) {
     // Check if low is smaller then high, if not then the array is sorted.
     if(low < high) {
       int middle = (low + high) / 2;
       mergesort(low, middle);        // Sort left side.
       mergesort(middle + 1, high);   // Sort right side.
       merge(low, middle, high);      // Merge.
     }
   }
   
   public void merge(int low, int middle, int high) {
     // Copy data into helper array.
     for(int i = low; i <= high; i++) {
       tmp[i] = arr[i];
     }
     
     int i = low;
     int k = middle + 1;
     int j = high;
     
     // Copy smallest value from either side into original array.
     while(i <= middle && j <= high) {
       if(tmp[i] > tmp[j]) {
         
       }
     }
   }
}
