package datastructures;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList {
  Node head = null;
  Node tail = null;
  int size;
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(new Node(1));
    list.add(new Node(2));
    list.add(new Node(3));
    list.add(new Node(4));
    list.add(new Node(5));
   
    list.print();

    System.out.println("Middle node is " + list.findMiddleNode(list.head).value);
    
    list.head = list.deleteAtTail(list.head);
    System.out.println("After deleted at the tail:");
    list.print();
    
    list.head = list.deleteAtHead(list.head);
    System.out.println("After deleted at the head:");
    list.print();
  }
  
  public int size() {
    return size;
  }
  
  // Add at the end of the list.
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
  
  public Node deleteAtHead(Node head) {
     return head == null ? null :head.next;
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
  
  /**
   * Given a Singly-Linked List, write a method - findMiddleNode that 
   * finds and returns the middle node of the list in a single pass.
   * 
   * Examples:
   * 1 ==> 1
   * 1->2 ==> 1
   * 1->2->3->4 ==> 2
   * 1->2->3->4->5 ==> 3
   */
  public Node findMiddleNode(Node head) {
     HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
     Node node = head;
     int i = 1;
     while(node != null) {
        nodes.put(i++, node);
        node = node.next;
     }
     
     return(nodes.get(i/2));
  }
  
  /**
   * Reverse linked list.
   * 
   * Asked by: Yelp
   */  
  public void reverseIterative() {
  	Node n1 = head;
  	Node n2 = n1.next;
  	
  	n1.next = null;
  	while(n1 != null && n2 != null) {
  		Node temp = n2.next;
  		n2.next = n1;
  		n1 = n2;
  		n2 = temp;
  	}
  	
  	head = n1;
  }
  
  public Node reverseRecursive(Node n) {
  	if(n == null || n.next == null) {
  		head = n;
  		return n;
  	}
  	
  	Node n2 = n.next;
  	n.next = null;
  	
  	Node n3 = reverseRecursive(n2);
  	n2.next = n;
  	
  	return n3;
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
  
  /**
   * Given a singly-linked list, write a method to delete its last node and return the head.
   * 1->2->3->4 => 1->2->3
   */
  private Node deleteAtTail(Node root) {
  	if(root.next == null) {
  		root = null;
  		return null;
  	}
  	else {
	  	Node n = root;
	  	
	  	while(n.next.next != null) {
	  		n = n.next;
	  	}
	  	
	  	n.next = null;
	  	return root;
  	}
  }
  
  public void print() {
  	if(head == null) {
  		System.out.println("NULL");
  	}
  	else {
	    Node n = head;
	    while(n.next != null) {
	      System.out.print(n.value + "->");
	      n = n.next;
	    }
	    System.out.println(n.value);
	  }  
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

/*

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
    
    System.out.println("Reversed iteratively");
    list.reverseIterative();
    list.print();

    System.out.println("Reversed recursively");
    list.reverseRecursive(list.head);
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
*/