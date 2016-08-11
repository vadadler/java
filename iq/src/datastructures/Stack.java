package datastructures;

import java.util.ArrayList;

/**
 * Stack uses LIFO ordering.
 */
public class Stack {
	int mSize = -1;
  ArrayList<Integer> mData = new ArrayList<Integer>();

  // Helper data structure to keep min value for each
  // corresponding value in the main data structure.
  ArrayList<Integer> mMinData = new ArrayList<Integer>();
  
  public void push(int v) {
  	mData.add(v);
  	
  	if(mMinData.isEmpty() == true) {
  		mMinData.add(v);
  	}
  	else {
  		int minValue = mMinData.get(mSize); 
  		if(v < minValue) {
  			mMinData.add(v);
  		}
  		else {
  			mMinData.add(minValue);
  		}
  	}
  	
  	mSize++;
  }
  
  public Integer pop() {
  	if(isEmpty() == false) {
  		int value = peek();
  		mData.remove(mSize);
  		mMinData.remove(mSize--);
  		return value;
  	}
    return null;
  }
  
  public Integer peek() {
    return mData.get(mSize - 1);
  }
  
  public Integer getMin() {
  	return mMinData.get(mSize);
  }
  
  public Boolean isEmpty() {
    return mData.size() == 0 ? true : false;
  }
  
  public void print() {
  	for(int i = mData.size() - 1; i >= 0 ; i--) {
  		System.out.println(mData.get(i) + " " + mMinData.get(i));
  	}
  }
  
  public static void main(String[] args) {
  	
  	Stack s = new Stack();
  	s.push(5);
  	s.push(7);
  	s.push(4);
  	s.push(2);
  	s.push(3);
  	s.print();
  	
  	System.out.println("Min=" + s.getMin());
  	
  	System.out.println("After 2 pops");
  	s.pop();
  	s.pop();
  	s.print();
  	System.out.println("Min=" + s.getMin());
  }
}
