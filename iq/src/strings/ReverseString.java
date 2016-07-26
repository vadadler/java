package strings;

public class ReverseString {
	public static void main(String[] args) {
		String strToReverse = "abcdef";
		System.out.println("Original string: " + strToReverse);
		System.out.println("Reversed string recursively: " + reverseRecursive(strToReverse));
		System.out.println("Reversed string iteratively: " + reverseIterative(strToReverse));
	}

	/**
	 * Recursive reversal.
	 * @param s input string
	 * @return output string.
	 */
	static String reverseRecursive(String s) {
		//System.out.println(s);
		if(s.length() <= 1) {
			return s;
		}
		
		return reverseRecursive(s.substring(1)) + s.charAt(0);
	}
	
	/**
	 * Iteratively reverse a string. Uses StringBuffer as helper.
	 * @param s input string.
	 * @return output string.
	 */
	static String reverseIterative(String s) {
		StringBuffer sbOut = new StringBuffer();
		int len = s.length();
		
		for(int i = len - 1; i >= 0; i--) {
			sbOut.append("" + s.charAt (i));
		}
		
		return sbOut.toString();
	}
}
