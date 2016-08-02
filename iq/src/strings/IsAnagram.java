package strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two strings are called anagrams if they contain same set of 
 * characters but in different order.
 * Example: keep <-> peek
 *
 * Asked by: Yelp
 */
public class IsAnagram {
	public static void main(String[] args) {
		IsAnagram ia = new IsAnagram();
		
		String s1 = "keep";
		String s2 = "peek";
		
		System.out.println("Using Arrays.equals(): " + s1 + " and " + s2 + " are anagrams? " + ia.isAnagramIsEqual(s1, s2));
		System.out.println("Using HashMap: " + s1 + " and " + s2 + " are anagrams? " + ia.isAnagramHashMap(s1, s2));
	}

	/**
	 * Use java.utils.Arrays.equals() method of two char arrays.
	 * 1. Sanitize and lower case both input strings.
	 * 2. Convert resulted strings to char[].
	 * 3. Sort char[] arrays.
	 * 4. Check for equality.
	 * 
	 * Complexity O(Nlog(N))
	 * 
	 * @param str1 input string 1.
	 * @param str2 input string 2.
	 * @return
	 */
	private boolean isAnagramIsEqual(String str1, String str2) {
		// Sanitize and lowercase.
		String s1 = str1.replaceAll("\\W","").toLowerCase();
		String s2 = str2.replaceAll("\\W","").toLowerCase();
		
		// Convert strings to char arrays.
		char[] sa1 = s1.toCharArray();
		char[] sa2 = s2.toCharArray();
		
		// Sort arrays of chars.
		Arrays.sort(sa1);
		Arrays.sort(sa2);
		
		System.out.println(Arrays.toString(sa1) + " " + Arrays.toString(sa2));
		return Arrays.equals(sa1, sa2);
	}
	
	/**
	 * Use HashMap helper. 
	 * 1. Sanitize and lower case both input strings.
	 * 2. Populate HashMap from first string. Use characters as keys
	 *    and value as counter of number if instances of that key in the strig.
	 * 3. Walk the second string. If character present in the HashMap decrement 
	 *    count. If at the end of he walk HashMap has no elements the strings
	 *    are anagrams.
	 *    
	 *    Complexity O(2N) sinse there are two loops.
	 * 
	 * @param str1 input string 1.
	 * @param str2 input string 2.
	 * @return
	 */
	private boolean isAnagramHashMap(String str1, String str2) {
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		
		// Sanitize and lowercase.
		String s1 = str1.replaceAll("\\W","").toLowerCase();
		String s2 = str2.replaceAll("\\W","").toLowerCase();
		
		// Populate hashmap and counter.
		Integer count;
		Character ch;
		for(int i = 0; i < str1.length(); i++) {
			ch = str1.charAt(i);		
			count =  0;

			count = hm1.get(ch);
			
			if(count == null) {
				hm1.put(ch, 1);
			}
			else {
				hm1.put(ch, ++count);
			}
		}
		
		for(int i = 0; i < str2.length(); i++) {
			ch = str2.charAt(i);
			count = hm1.get(ch);
			
			if(count == null) {
				return false;
			}
			else {
				if(--count == 0) {
					hm1.remove(ch);
				}
				else {
					hm1.put(ch, count);
				}
			}
		}
		
		if(hm1.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
