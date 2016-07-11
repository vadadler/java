package puzzles;

import java.util.LinkedList;
import java.util.Stack;

/**
 * I was asked today to write an algorithm checking if string 
 * was a palindrome. 
 *
 */
public class Palindrome {
	static String str1 = "Borrow or rob?";
	static String str2 = "Borrow or robb?";
	
	public static void main(String[] args) {
		System.out.println("Is \"" + str1 + "\" palindrome? " + isPalindrome(str1));
		System.out.println("Is \"" + str2 + "\" palindrome? " + isPalindrome(str2));
		
		System.out.println("Is \"" + str1 + "\" palindrome? " + isPalindromeWithStack(str1));
		System.out.println("Is \"" + str2 + "\" palindrome? " + isPalindromeWithStack(str2));
		
	}
	
	/**
	 * Approach #1
	 * 1. Sanitize input string. Remove white characters, punctuation marks etc.
	 * 2. Lowercase.
	 * 3. Walk the string from both ends checking if chars at position {@code i} and
	 * {@code length - 1 - i} are the same.
	 * 
	 * @param str input string to check.
	 * @return true if {@code str} is a palindrome. Otherwise, false.
	 */
	private static boolean isPalindrome(String str) {
		// Sanitize and lowercase.
		str = str.replaceAll("\\W","").toLowerCase();
		
		for(int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Approach #2 Using stack and queue (java.utils.LinkedList).
	 */
	private static boolean isPalindromeWithStack(String str) {
		Stack<Character> s = new Stack<Character>();
		LinkedList<Character> q = new LinkedList<Character>();
		
		// Sanitize and lowercase.
		str = str.replaceAll("\\W","").toLowerCase();
		
		for(int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			q.add(str.charAt(i));
		}
		
		while(s.isEmpty() == false) {
			if(s.pop() != q.removeFirst()) {
				return false;
			}
		}
		
		return true;
	}
}
