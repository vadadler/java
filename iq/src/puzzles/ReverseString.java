package puzzles;

public class ReverseString {
	public static void main(String[] args) {
		String strToReverse = "abcdef";
		System.out.println(strToReverse);
		System.out.println(reverse(strToReverse));

	}

	static String reverse(String s) {
		if(s.length() <= 1) {
			return s;
		}
		
		return reverse(s.substring(1)) + s.charAt(0);
	}
}
