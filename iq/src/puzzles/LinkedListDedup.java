package puzzles;

import java.util.HashMap;

/**
 * Remove duplicates from an unsorted linked list.
 */
public class LinkedListDedup {
  public static void main(String[] args) {
  	// Construct linked list.
    Node n = new Node(2);
    n.next = new Node(2);
    n.next.next = new Node(4);
    n.next.next.next = new Node(3);
    n.next.next.next.next = new Node(2);
    n.next.next.next.next.next = new Node(4);
    
    print(n);
    dedup(n);
    print(n);
  }
  
  /**
   * Use helper HashMap object.The keys in the HashMap are the
   * values of the nodes. If node's value already exists in the
   * HashMap adjust next pointer and move one.
   * @param n head node of the list.
   */
  private static void dedup(Node n) {
    HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
    hash.put(n.value, 1);
    
    Node curr = n.next;
    Node prev = n;
    while(curr != null) {
      if(hash.containsKey(curr.value)) {
        prev.next = curr.next;
      }
      else {
        hash.put(curr.value, 1);
        prev = curr;
      }
      
      curr = curr.next;
    }
  }
  
  private static void print(Node root) {
    Node n = root;
    while(n != null) {
      System.out.print(n.value + "->");
      n = n.next;
    }
    System.out.println("NULL");
  }
}

class Node {
  int value;
  Node next;
  
  public Node(int v) {
    value = v;
    next = null;
  }
}
