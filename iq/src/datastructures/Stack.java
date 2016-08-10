package datastructures;

import java.util.ArrayList;

/**
 * Stack uses LIFO ordering.
 */
public class Stack {
	int mSize = -1;
  ArrayList<Integer> mData = new ArrayList<Integer>();
  
  public void push(int v) {
  	mData.add(v);
  	mSize++;
  }
  
  public Integer pop() {
  	if(isEmpty() == false) {
  		int value = peek();
  		mData.remove(mSize--);
  		return value;
  	}
    return null;
  }
  
  public Integer peek() {
    return mData.get(mSize - 1);
  }
  
  public Boolean isEmpty() {
    return mData.size() == 0 ? true : false;
  }
  
  public void print() {
  	for(int i = mData.size() - 1; i >= 0 ; i--) {
  		System.out.println(mData.get(i));
  	}
  }
  
  public static void main(String[] args) {
  	Stack s = new Stack();
  	s.push(0);
  	s.push(1);
  	s.push(2);
  	s.push(3);
  	s.push(4);
  	s.print();
  	
  	System.out.println("After 2 pushes");
  	s.pop();
  	s.pop();
  	s.print();
  }
}
