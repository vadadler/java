package strings;

/**
 * Given a string of words, reverse the words.
 * Example: "no more questions" -> "questions more no" 
 */
public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		String s = "no more questions";
		System.out.println(s + "=>" + rw.reverseWords(s));
		
	}
	
	private String reverseWords(String str1) {
		String[] words = str1.split(" ");
		StringBuffer sb = new StringBuffer();
		
		for(int i = (words.length - 1); i >= 0; i--) {
			sb.append(words[i] + " ");
		}
		
		return sb.toString();
	}
}
