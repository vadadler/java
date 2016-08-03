package arrays;

import java.util.Arrays;

/**
 * Given an array of positive and negative numbers, find if there is a 
 * subarray (of size at-least one) with 0 sum.
 *
 */
public class ZeroSum {
	public static void main(String[] args) {
		int[] arr = {1,2,-5,1,2,-3};
		
		System.out.println("Array: " + Arrays.toString(arr));
		
		ZeroSum zs = new ZeroSum();
		zs.zeroSumBruteForce(arr);
	}
	
	/**
	 * Consider all subarrays one by one. 
	 * 
	 * @param arr input array of ints.
	 * @return subarray which sum is 0 or null if none.
	 */
	private int[] zeroSumBruteForce(int[] arr) {
		int current_sum = 0;
		for(int i = 0; i < arr.length; i++) {
			current_sum = arr[i];
			
			for(int j = i + 1; j < arr.length; j++) {
				if(current_sum == 0) {
					// Print subarray.
					System.out.print("[");
					for(int k = i; k < j; k++) {
						System.out.print(arr[k] + ",");
					}
					System.out.print("]");
				}
				else {
					current_sum += arr[j];
				}
			}
		}
		return null;
	}
}
