package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Manipulations {
   public static void main(String[] args) {
      Manipulations m = new Manipulations();
      
      int[] arr = {1,2,3,4,1,2,4,3,5};
      System.out.println("In array: " + Arrays.toString(arr) + " " + m.singularNumber2(arr) + " occurs once");
   }
   
   /**
    * Write a method that returns a number that appears only once in an array. 
    * Assume the array will surely have a unique value. The array will never 
    * be empty.
    * {1,2,3,4,1,2,4,3,5} ==> 5
    * 
    * Solution: Use HashMap to store numbers of array as keys and number of
    * occurrences as value.
    */
   private int singularNumber(int[] arr) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      for(int i = 0; i < arr.length; i++) {
         Integer v = map.get(arr[i]);
         if(v == null) {
            map.put(arr[i], 1);
         }
         else {
            map.put(arr[i], ++v);
         }
      }
      
      for(Integer k : map.keySet()) {
         int v = map.get(k); 
         if(v == 1) {
            return k;
         }
      }
      
      return 0;
   }
   
   /**
    * 1. Sort array.
    * 2. Convert it to string.
    * 3. Walk char array built from that string.
    * 4. Compare first and last occurrence indexes of chars.
    *    If indexes match there is only one instance of that char in the string.  
    */
   private int singularNumber2(int[] arr) {
      Arrays.sort(arr);

      // Convert array to string.
      StringBuilder sb = new StringBuilder();
      for(int i =0; i < arr.length; i++) {
         sb.append(arr[i]);
      }
      
      for(char ch : sb.toString().toCharArray()) {
         if(sb.toString().indexOf(ch) == sb.toString().lastIndexOf(ch)) {
            return Character.getNumericValue(ch);
         }
      }
      return 0;
   }
}
