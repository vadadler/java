package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers find all unique
 * pairs which sum up to a value.
 * 
 * Three possible solutions:
 * 	1. Brute force. Nested loops to check all 
 *     possible combinations.
 *  2. Sort array. Binary search for (sum - element).
 *  3. Using HashTable to store elements as keys and 
 * 		 (sum - element) as value.
 *
 */

public class PairSum {
	public static void main(String[] args) {
		int[] a = {5,3,7,0,1,2,4};
		int sum = 5;
		
		System.out.println(Arrays.toString(a));
		
		PairSum ps = new PairSum();
		System.out.println("Using nested loops");
		ps.pairSumNestedLoops(a, sum);

		System.out.println("Using hashmap");
		ps.pairSumHashMapDiff(a, sum);

		System.out.println("Using sorted array and binary search");
		ps.pairSumSortBinary(a, sum);
}
	
	/**
	 * Brute force method. Check all pairs (double nested loops).
	 * 
	 * Time complexity O(n^2)
	 * 
	 * @param arr
	 * @param sum
	 */
	private void pairSumNestedLoops(int[] arr, int sum) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == sum) {
					System.out.println("[" + arr[i] + "," + arr[j] + "] = " + sum);
				}
			}
		}
	}
	
	/**
	 * Use a hash table to store the difference between sum and each of the elements 
	 * in the array. Loop through the array, check each element against the hash table.
	 * 
	 * NOTE: current implementation does not deal with duplicate entries. I.e. 
	 * [5,0] and [0,5] are treated as different pair.
	 * 
	 * Time complexity: O(N)
	 * 
	 * @param arr
	 * @param sum
	 */
	private void pairSumHashMapDiff(int[] arr, int sum) {
		HashMap<Integer, Integer> hmDiff = new HashMap<Integer, Integer>();
		
		// Populate hashmap.
		for(int i = 0; i < arr.length; i++) {
			hmDiff.put(i, sum - arr[i]);
		}
		
		// Loop through input array and check values with hashmap. 
		for(int i = 0; i < arr.length; i++) {
			int value = hmDiff.get(i);
			if(hmDiff.containsKey(value) == true) {
				System.out.println("[" + arr[i] + "," + value + "] = " + sum);
			}
		}
	}
	
	private void pairSumSortBinary(int[] arr, int sum) {
		// Sort array.
		Arrays.sort(arr);
		
		searching.BinarySearch bs = new searching.BinarySearch(arr);
		
		for(int i = 0; i < arr.length; i++) {
			int index = bs.findIndex(sum - arr[i]);
			if(index >= 0) {
				System.out.println("[" + arr[i] + "," + arr[index] + "] = " + sum);
			}
		}
	}	
}
