package puzzles;

/**
 * Show how different versions of implementing exponentiality 
 * and related computational complexity. 
 */
public class Exponent {
	public static void main(String[] args){
		Exponent exp = new Exponent();
		int a = 3, b = 4;
		
		int result = exp.iterativeExponenet(a, b);
		System.out.println("Iterative: " + a + " in power of " + b + " = " + result);
		
		result = exp.recursiveExponent(a, b);
		System.out.println("Recursive : " + a + " in power of " + b + " = " + result);

		result = exp.reduceExponent(a, b);
		System.out.println("With reducing : " + a + " in power of " + b + " = " + result);
	}
	
	/**
	 * Complexity: linear O(N)
	 * @param a
	 * @param b
	 * @return
	 */
	private int iterativeExponenet(int a, int b) {
		int result = 1;
		int i = 1;
		while(i <= b) {
			result *= a;
			i++;
		}
		return result;
	}
	
	/**
	 * Calculating complexity: 
	 * t(b) = 3 + t(b-1) or
	 * t(b) = 3 + 3 + t(b-2) or
	 * t(b) = 3k + t(b-k)
	 * we are done when (b-k)=1, k = b -1
	 * t(b) = 3(b-1) + t(1)
	 * t(b) = 3(b-1) + 1
	 * t(b) = 3b-2 that is complexity is linear O(b) === O(N) 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int recursiveExponent(int a, int b) {
		if(b == 1) {
			return a;
		}
		
		return a * recursiveExponent(a, b - 1);
	}
	
	/**
	 * Trick: Reducing problem.
	 * Complexity O(log(N))
	 * if b is even: a**b = (a*a)**b/2 because (a*a)**b/2 == (a**2)**b/2 == a**b
	 * if b is odd: a**b = a*(a**(b-1)) because a*(a**(b-1)) == a**b
	 * @param a
	 * @param b
	 * @return
	 */
	private int reduceExponent(int a, int b) {
		if(b == 1) {
			return a;
		}
		
		if(b%2 == 0) {	// b is even.
			return reduceExponent(a * a, b/2);
		}
		else {					// b is odd.
			return a * reduceExponent(a, b - 1);
		}
	}
}
