package sorting;

public class Main {
  public static void main(String[] args) {
    App app = new App();
   
    app.print();
    app.bubbleSort();
    app.print();
    
    app.reset();
    app.print();
    app.selectionSort();
    app.print();
    
    app.reset();
    app.print();
    app.insertSort();
    app.print();
    
    app.reset();
    app.print();
    app.quickSort();
    app.print();

  }
}

class App {
  int[] arr = {4,1,3,5,2};
  
  void print() {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("");
  }
  
  void bubbleSort() {
    BubbleSort bubble = new BubbleSort(arr);
    bubble.sort();
  }
  
  void selectionSort() {
    SelectionSort selection = new SelectionSort(arr);
    selection.sort();
  }
  
  void insertSort() {
    InsertSort insert = new InsertSort(arr);
    insert.sort();
  }
  
  void quickSort() {
    QuickSort quick = new QuickSort(arr);
    quick.sort();
  }
  
  void reset() {
    arr = new int[] {4,1,3,5,2};
  }
}