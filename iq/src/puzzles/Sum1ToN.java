package puzzles;

public class Sum1ToN {

	public static void main(String[] args) {
		int n = 10;
		System.out.println("Iterative sum of " + n + " is " + sumIterative(n));
		System.out.println("Recursive sum of " + n + " is " + sumRecursive(n));
	}

	private static int sumIterative(int c) {
	  int retVal = 0;
	  for(int i = 1; i <= c; i++)
	    retVal += i;
	  
	  return retVal;
	}
	
	private static int sumRecursive(int c) {
	  if(c > 0)
	    return c + sumRecursive(c - 1);
	  else
	    return 0;
	}
}
