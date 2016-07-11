package datastructures;

/**
 * Queue uses FIFO order.
 */
public class Queue {
  LinkedList data = new LinkedList();
  
  public void enqueue(int value) {
    data.insert(data.new Node(value));
  }
  
  public int dequeue() {
    int value = data.tail.value;
    data.delete(value);
    return value;
  }
}
