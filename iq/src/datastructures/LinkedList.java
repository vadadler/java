package datastructures;

import java.util.HashSet;

import datastructures.LinkedList.Node;

public class LinkedList {
  Node head = null;
  Node tail = null;
  int size;
  
  public static void main(String[] args) {
    AppLinkedList app = new AppLinkedList();
    app.ceateList();
    //app.delete(3);
  }
  
  public int size() {
    return size;
  }
  
  // Add to the end of the list.
  public void add(Node n) {
    if(head == null) { 
      head = n; 
      tail = null;
    }
    else if(tail == null) {
      head.next = n;
      tail = n;
    }
    else {
      tail.next = n;
      tail = n;
    }
    size++;
  }
  
  // Insert at the beginning of the list.
  public void insert(Node n) {
    n.next = head;
    head = n;
    size++;
  }
    
  // Delete a node.
  public void delete(Node n) {
    if(find(n) != null) {
      n = n.next;
      size--;
    }
  }
  
  // Delete a node based on value.
  public void delete(int n) {
    Node node = find(n);
    if(node != null) {
      node.value = node.next.value;
      node.next = node.next.next;
      
      if(node.next == null) {
        tail = node;
      }
    }
  }
  
  // Reverse linked list.
  public void reverse() {
    Node current = head;
    Node previous = null;
    Node next = null;
    while(current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    head = previous;
  }
  
  /**
   * Find nth element from the last using recursion.
   * When it hits the end return 0 and then each
   * parent calls add 1. Compare with nth. 
   */
  public int nthToLast(Node node, int nth) {
    if(node == null) return 0;
    
    int i = nthToLast(node.next, nth) + 1;
    if(i == nth) {
      System.out.println(nth + " element to Last is " + node.value);
    }
    return i;
  }
  
  /**
   * Use a temp storage HashSet to store elements of the
   * list while walking the list. If duplicate found 
   * skip that node by adjusting pointers.
   */
  public void dedup() {
    HashSet<Integer> nodes = new HashSet<Integer>();
    Node node = head;
    Node previous = head;
    while(node != null) {
     if(nodes.contains(node.value)) {
       previous.next = node.next;
     }
     else {
       nodes.add(node.value);
       previous = node;
     }
     
     node = node.next;
    }
  }
  
  /**
   * Use two nested pointers to scan for duplicates. One is slow (outer)
   * and the other fast (inner).
   * Memory complexity O(1). Time complexity O(N^2).
   */
  public void dedupInplace() {
    Node node = head;
    while(node != null) {
      Node temp = node.next;
      Node previous = node;
      while(temp != null) {
        if(temp.value == node.value) {
          previous.next = temp.next;
        }
        previous = temp;
        temp = temp.next;
      }
      node = node.next;
    }
  }
  
  public Node find(int n) {
    Node node = head;
    while(node.next != null) {
      if(node.value == n)
        return node;
      else
        node = node.next;
    }
    return null;
  }
  
  public Node find(Node n) {
    Node node = head;
    while(node.next != null) {
      if(node.value == n.value)
        return node;
    }
    return null;
  }
  
  /**
   * Check if list has a loop.
   * Use two pointers: slow runner (1 step at a time) and fast runner (2 steps at a time)
   * If there is loop these pointers will meet.
   * How to prove that they will meet: 
   * Assuming P2 passed P1 by 1, that is P1 = i, P2 = i+1 then previous steps would
   * be P1 = i-1 and P2 = i+1-2 = i-1. That is they meet. 
   */
  public boolean isLoop() {
    Node n = head;
    
    int v1 = -1, v2 = -1;
    
    while(n != null) {
      v1 = n.value;
      if(n.next != null)
        v2 = n.next.value;
      
      if(v1 == v2)
        return true;
      
      n = n.next;
    }
    
    return false;
  }
  
  public void print() {
    Node n = head;
    while(n.next != null) {
      System.out.print(n.value + "->");
      n = n.next;
    }
    System.out.println(n.value);
  }
  
  class Node {
    int value;
    Node next;
    
    public Node(int v) {
      value = v;
      next = null;
    }
  }
}

class AppLinkedList {
  LinkedList list;
  public void ceateList() {
    list = new LinkedList();
    
    Node n1 = list.new Node(1);
    Node n2 = list.new Node(2);
    Node n3 = list.new Node(3);
    Node n4 = list.new Node(4);
    Node n5 = list.new Node(5);
    
    list.add(n1);
    list.add(n2);
    list.add(n3);
    list.add(n4);
    list.add(n5);
    list.add(list.new Node(3));
    
    System.out.println("List");
    list.print();
    
    System.out.println("Deduped list");
    list.dedupInplace();
    list.print();
    
    System.out.println("Added at the head");
    list.insert(list.new Node(6));
    list.print();
    
    System.out.println("Reversed");
    list.reverse();
    list.print();
    
    System.out.println("Deleted node " + 3);
    list.delete(3);
    list.print();
    
    System.out.println("What is 2nd element from last");
    list.nthToLast(list.head, 2);
    
  }
  
  public void delete(int n) {
    list.delete(n);

  }
}