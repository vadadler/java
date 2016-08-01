package arrays;

/**
 * OpenGarden
 * 
 * The 2010 Census puts populations of 26 largest US metro areas at 18897109, 12828837, 9461105, 
 * 6371773, 5965343, 5946800, 5582170, 5564635, 5268860, 4552402, 4335391, 4296250, 4224851, 
 * 4192887, 3439809, 3279833, 3095313, 2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 
 * 2149127, 2142508, and 2134411.
 * Can you find a subset of these areas where a total of exactly 100,000,000 people live, 
 * assuming the census estimates are exactly right?
 * 
 * http://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
 *
 */
public class SubsetSumProblem {
  static int[] arr = {18897109, 12828837, 9461105, 6371773, 5965343, 5946800, 5582170, 5564635, 
      5268860, 4552402, 4335391, 4296250, 4224851, 4192887, 3439809, 3279833, 3095313, 
      2812896, 2783243, 2710489, 2543482, 2356285, 2226009, 2149127, 2142508,2134411};
  
  static int[] result = new int[arr.length];
  
  static int sum = 100000000;
  
  public static void main(String[] args) {
    findRecursive(0,0);
  }

  /**
   * Recursive algorithm checks all subsets. 
   * 
   * Complexity: O(2^n)
   * 
   * result is array of the same size as input array. It holds 1 if element
   * of input array is part of the subset. Otherwise it holds 0.
   * 
   * @param currentSum - cumulative sum so far.
   * @param index - index into input/result array.
   */
  public static void findRecursive(int currentSum, int index) {
    if (currentSum == sum) {
      System.out.println("Found");
      for (int i = 0; i < result.length; i++) {
        if (result[i] == 1) {
          System.out.print(" " + arr[i]);
        }
      }
    } 
    else if (index == arr.length) {
      return;
    } 
    else {
      result[index] = 1; // Select the element.
      currentSum += arr[index];
      findRecursive(currentSum, index + 1);
      currentSum -= arr[index];  
      result[index] = 0; // Do not select the element.
      findRecursive(currentSum, index + 1);
    }
    return;
  }
  
  /**
   * 
   */
  public static void findDP() {
    // TODO
  }
}
