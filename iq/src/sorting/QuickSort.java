package sorting;

/**
 * Divide and conquer algorithm. Follow these 3 steps recursively.
 * 1. Find pivot that divides array in two halves.
 * 2. Quick sort left partition.
 * 3. Quick sort right partition.
 */
public class QuickSort {
  int[] arr;
  
  public QuickSort(int[] data) {
    arr = data;
  }
  
  public void sort() {
    quickSort(arr, 0, arr.length - 1);
  }
  
  private int partition(int[] data, int left, int right) {
    int pivot = data[(right + left) / 2];
    
    while(left <= right) {
      while(data[left] < pivot) left++;
      while(data[right] > pivot) right--;
      
      if(left <= right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        left++;
        right--;
      }
    }
    
    return left;
  }
  
  private void quickSort(int[] data, int left, int right) {
    int pivot = partition(data, left, right);
    
    if(left < pivot - 1) {
      quickSort(data, left, pivot - 1);
    }
    
    if(pivot < right) {
      quickSort(data, pivot, right);
    }
  }
}
