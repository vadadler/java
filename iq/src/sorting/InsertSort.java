package sorting;

public class InsertSort {
  int[] arr;
  
  public InsertSort(int[] data) {
    arr = data;
  }
  
  public void sort() {
    for(int i = 0; i < arr.length; i++) {
      for(int j = 1; j < arr.length; j++) {
        if(arr[i] > arr[j]) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }
}
