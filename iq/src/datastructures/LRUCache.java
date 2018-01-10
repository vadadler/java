package datastructures;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should 
 * support the following operations: get and set.
 *
 * LRU is a cache that holds strong references to a limited number of values. Each time a value is accessed, it is
 * moved to the head of a queue. When a value is added to a full cache, the value at the end of that queue is evicted.
 *
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
   public static final int MAX_CAPACITY = 4;

   HashMap<Integer, Node> mValues = new HashMap<Integer, Node>();
   HashMap<Character, NodeChar> mValuesChar = new HashMap<Character, NodeChar>();

   Node mHead=null;
   Node mEnd=null;

   NodeChar mHeadChar = null;
   NodeChar mEndChar = null;


   public void printCacheChar() {
      mValuesChar.forEach((k, v) -> System.out.println("key: " + k + " value: " + v.value));
      System.out.println("");

      NodeChar node = mHeadChar;
      while(node != null) {
         System.out.println("key: " + node.key + " value: " + node.value);
         node = node.next;
      }

   }

   private void setHead(Node n) {
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

   
   private void remove(Node n) {
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

   public void set(char key, char value) {
      NodeChar n = new NodeChar(key, value);
      if(mValuesChar.size() >= MAX_CAPACITY) {
         NodeChar temp = mEndChar;
         mHeadChar = mHeadChar.next;
         mHeadChar.prev = null;
         mEndChar.next = n;
         mEndChar = n;
         mEndChar.prev = temp;

         mValuesChar.remove(temp.key);
      }
      else {
         if(mHeadChar == null) {
            mHeadChar = n;
            mEndChar = mHeadChar;
         }
         else if(mEndChar == mHeadChar) {
            mEndChar = n;
            mHeadChar.next = mEndChar;
            mEndChar.prev = mHeadChar;
         }
         else {
            NodeChar temp = mEndChar;
            mEndChar.next = n;
            mEndChar = n;
            mEndChar.prev = temp;
         }
      }

      mValuesChar.put(key, n);
   }

    /**
     * Get cache value based on the key. If key does not exist, return '\u0000'
     *
     * @param key
     * @return value or '\u0000' if element does not exist.
     */
    public char get(char key) {
       if(mValuesChar.containsKey(key)) {
          NodeChar n = mValuesChar.get(key);
          n.prev.next = n.next;
          n.next.prev = n.prev;

          NodeChar temp = mEndChar;
          mEndChar.next = n;
          mEndChar = n;
          mEndChar.prev = temp;
          mEndChar.next = null;

          return  n.value;
       }
       else {
          return Character.MIN_VALUE;
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

   private class NodeChar {
       char key;
       char value;
       NodeChar next;
       NodeChar prev;

       public NodeChar(char k, char v) {
          key = k;
          value = v;
          next = prev = null;
       }
   }
}
