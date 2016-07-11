package datastructures;

/**
 * Stack uses LIFO ordering.
 */
public class Stack {
  LinkedList data = new LinkedList();
  
  public void push(int v) {
    data.add(data.new Node(v));
  }
  
  public int pop() {
    int value = data.head.value;
    data.delete(data.head.value);
    return value;
  }
  
  public int peek() {
    return data.head.value;
  }
  
  public boolean isEmpty() {
    return data.size() == 0 ? true : false;
  }
}
