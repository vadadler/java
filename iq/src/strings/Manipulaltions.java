package strings;

import java.util.LinkedHashMap;

public class Manipulaltions {
   public static void main(String[] args) {
      String s1 = "abcdcd";
      String s2 = "cbcd";
      String s3 = "cdcd";
      
      Manipulaltions m = new Manipulaltions();
      String ret = m.firstNonRepeatedCharacter2(s1);
      if(ret == null) {
         ret = "NULL";
      }
      System.out.println("In " + s1 + " first non duplicate char is " + ret);
   }
   

   /**
    * Find the first non-duplicate character in a string. Return null if no unique character is found. 
    * firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
    * firstNonRepeatedCharacter( "cbcd" ) --> 'b'
    * firstNonRepeatedCharacter( "cdcd" ) --> null
    * 
    * Solution: order is important. While walking input string save char into LinkedHashMap. 
    * This data structure offers O(1) complexity for getting, checking and inserting.
    * The keys in this LinkedHashMap are chars and values are occurrence count.  
    */
   private String firstNonRepeatedCharacter(String inStr) {
      String ret = null;
      LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
      
      for(char ch : inStr.toCharArray()) {
         Integer v = map.get(ch);
         if(v == null) {
            map.put(ch, 1);
         }
         else {
            map.put(ch, ++v);
         }
      }
      
      for(char ch : map.keySet()) {
         if(map.get(ch) == 1) {
            ret = "" + ch;
            break;
         }
      }
      
      return ret;
   }
   
   /**
    * Solution: if char happens only once in a string then its index inside
    * the string will be same with the last index.
    * 
    * @param inStr
    * @return
    */
   private String firstNonRepeatedCharacter2(String inStr) {
      for(char ch : inStr.toCharArray()) {
         if(inStr.indexOf(ch) == inStr.lastIndexOf(ch)) {
            return "" + ch;
         }
      }
      
      return null;
   }
}
