package sorting;

public class BubbleSort {
  int[] arr = {4,1,3,5,2};
  
  public BubbleSort() {};
  
  public BubbleSort(int[] data) {
    arr = data;
  }
  
  public void setData(int[] data) {
    arr = data;
  }
  
  /**
   * Reset sorted array back to unsorted state.
   */
  public void reset() {
    arr = new int[] {4,1,3,5,2};
  }
  
  public void print() {
    for(int i=0; i< arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }
  
  public void sort() {
    for(int i = arr.length; i > 0; i--) {
      for(int j = 1; j < i; j++) {
        if(arr[j - 1] > arr[j]) {
          int tmp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = tmp;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    BubbleSort s = new BubbleSort();
    s.print();
    s.sort();
    s.print();
  }
}
