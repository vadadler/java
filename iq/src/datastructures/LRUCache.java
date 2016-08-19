package datastructures;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should 
 * support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key 
 *            exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the 
 *                   cache reached its capacity, it should invalidate the least recently 
 *                   used item before inserting a new 
 *
 * Implementation: The LRU cache is a hash table of keys and double linked nodes. 
 *                 The hashtable makes the time of get() to be O(1). The list of double 
 *                 linked nodes make the nodes adding/removal operations O(1).
 */
public class LRUCache {
   // Maximum values to stored in cache.
   public static final int MAX_CAPACITY = 10;

   HashMap<Integer, Node> mValues = new HashMap<Integer, Node>();
   Node mHead=null;
   Node mEnd=null;

   public void setHead(Node n) {
      n.next = mHead;
      n.previous = null;

      if(mHead!=null) {
          mHead.previous = n;
      }

      mHead = n;

      if(mEnd == null) {
          mEnd = mHead;
      } 
   } 

   /**
    * Get value from cache.
    * @param key of the value.
    * @return value or -1 if element does not exist.
    */
   public int get(int key) {
       if(mValues.containsKey(key) == true) {
           Node node = mValues.get(key);
           remove(node);
           setHead(node);
           return node.mValue;
       }

       return -1;
   }

   
   public void remove(Node n) {
       if(n.previous != null) {
           n.previous.next = n.next;
       }
       else {
           mHead = n.next;
       }

       if(n.next!=null) {
           n.next.previous = n.previous;
       }
       else {
           mEnd = n.previous;
       }
   }

   public void set(int key, int value) {
       if(mValues.containsKey(key) == true) {
           Node node = mValues.get(key);
           node.mValue = value;
           remove(node);
           setHead(node);
       }
       else {
           Node node = new Node(key, value);
           if(mValues.size() >= MAX_CAPACITY){
               mValues.remove(node.mKey);
               remove(node);
               setHead(node);

           }
           else {
               setHead(node);
           }    

           mValues.put(key, node);
       }
   }
   
   private class Node {
      int mKey;
      int mValue;
      Node next;
      Node previous;
      
      public Node(int k, int v) {
         mKey = k;
         mValue = v;
      }
   }
}
