package sorting;

public class SelectionSort {
  int[] arr;
  
   public SelectionSort(int[] data) {
     arr = data;
   }
   
   public void sort() {
     for(int i = 0; i < arr.length; i++) {
       for(int j = 1; j < arr.length; j++) {
         if(arr[j-1] > arr[j]) {
           int tmp = arr[j];
           arr[j] = arr[j-1];
           arr[j-1] = tmp;
         }
       }
     }
   }
}
