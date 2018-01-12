package co;

import java.util.Arrays;
import java.util.HashSet;

public class Google {
	public static void main(String[] args) {
		Google g = new Google();
		
		//2sum
		int[] arr2 = {2,4,5,9,7,11};
		int sum2 = 12;
		g.twoSum(arr2, sum2);
		g.twoSumUnsorted(arr2, sum2);
		
		//3sum
		int[] arr3 = {8,2,1,5,7,6,11};
		int sum3 = 18;
		g.threeSumBruteForce(arr3, sum3);
		g.threeSumOptimal(arr3, sum3);
		g.threeSumClosest(arr3, sum3);

		// Find first duplicate character.
		g.findFirstDuplicate("ADCBED");
	}
	

	/**
	 * Given a sorted array, find 2 numbers that sum up to S.
	 * 
	 * To solve this in O(N) time, we can keep two indices – one in the beginning 
	 * (start) and the other in the end (end). If the sum of the current two numbers 
	 * is greater than S, we move the end pointer backward by one step. If the sum 
	 * is smaller than S, we move the start pointer forward by one step.
	 * When the two pointers meet each other, we know that no two numbers sum up to S.
	 * The reason we can make it O(N) is that the array is sorted and we don’t need to 
	 * check all the combinations.
	 */
	private void twoSum(int[] arr, int sum) {
		int start = 0;
		int end = arr.length - 1;
		
		System.out.println("Find sum=" + sum + " in array " + Arrays.toString(arr));
		
		while(start != end) {
			int currSum = arr[start] + arr[end];
			
			if(currSum < sum) {
				start++;
			}
			else if (currSum > sum) {
				end--;
			}
			else {
				System.out.println("2sum found: " + arr[start] + "+" + arr[end] + "=" + sum);
				return;
			}
		}
		
		System.out.println("2sum not found: array " + Arrays.toString(arr) + " to find sum=" + sum);
	}

	/**
	 * Given an unsorted array find 2 numbers that sum to S.
    *
	 * The idea here is while walking array at each iteration store compliment to the current value as a set. Compliment is a
	 * difference between S and current value. When visiting an element search set for its compliment. If found, the sum
	 * is found.
    * 
	 */
	private void twoSumUnsorted(int[] arr, int sum) {
		HashSet<Integer> compliments = new HashSet<Integer>();

		System.out.println("Find sum=" + sum + " in array " + Arrays.toString(arr));

		int index = 0;

		while(index < arr.length - 1) {
			int compliment = sum - arr[index];
			compliments.add(compliment);

			if(compliments.contains(arr[index]) == true) {
				System.out.println("2sum unsorted found: " + arr[index] + "+" + compliment + "=" + sum);
				return;
			}

			index++;
		}

		System.out.println("2sum unsorted not found: array " + Arrays.toString(arr) + " to find sum=" + sum);
	}

	/**
	 * Determine if any 3 integers in an array sum to S.
	 * @param arr input array
	 * @param sum sum
	 * 
	 * Brute force approach. Make 3 nested loops and iterate through to find solution.
	 * Time complexity O(N^3)
	 */
	private void threeSumBruteForce(int[] arr, int sum) {
		System.out.println("Find sum=" + sum + " in array " + Arrays.toString(arr));
		int size = arr.length;
		
		for(int i = 0; i < size; i++) {
			for(int j = i + 1; j < size; j++) {
				for(int k = j + 1; k < size; k++) {
					int currSum = arr[i] + arr[j] + arr[k];
					if(currSum == sum) {
						System.out.println("3sum found: " + arr[i] + "+" + arr[j] + "+" + arr[k] + "=" + sum);
						return;
					}
				}
			}
		}
		
		System.out.println("3sum not found: array " + Arrays.toString(arr) + " to find sum=" + sum);
	}
	
	/**
	 * Sort input array. Fix one number. Run 2sum algorithm for the other two.
	 * Time complexity O(N^2)
	 */
	private void threeSumOptimal(int[] arr, int sum) {
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		sorting.QuickSort qs = new sorting.QuickSort(arr);
		qs.sort();
		System.out.println("Array after sorting: " + Arrays.toString(arr));
		
		int size = arr.length;
		boolean isFound = false;
		for(int i = 0; i < size; i++) {
			int tmpSum = sum - arr[i];
			
			int start = i + 1;
			int end = size - 1;
			while(start != end) {
				int currSum = arr[start] + arr[end];
				if(currSum < tmpSum) {
					start++;
				}
				else if(currSum > tmpSum) {
					end--;
				}
				else {
					isFound = true;
					break;
				}
			}
			
			if(isFound == true) {
				System.out.println("3sum found: " + arr[i] + "+" + arr[start] + "+" + arr[end] + "=" + sum);
				return;
			}
		}
		
		System.out.println("3sum not found: array " + Arrays.toString(arr) + " to find sum=" + sum);
	}

	/**
	 * Find 3 integers in an array whose sum is closest to S.
	 * 
	 * Sort array. Fix first number. Use 2sum algorithm to find closest sum. 
	 * 
	 */
	private void threeSumClosest(int[] arr, int sum) {
		System.out.println("Array before sorting: " + Arrays.toString(arr));
		sorting.QuickSort qs = new sorting.QuickSort(arr);
		qs.sort();
		System.out.println("Array after sorting: " + Arrays.toString(arr));
		
		int size = arr.length;
		for(int i = 0; i < size; i++) {
			int tmpSum = sum - arr[i];
			
			int start = i + 1;
			int end = size -1;
			boolean isReached = false;
			while(start != end) {
				int currSum = arr[start] + arr[end];
				if(currSum < tmpSum) {
					if(start + 1 != end) {
						start++;
					}
					else {
						isReached = true;
						break;
					}
				}
				else if(currSum > tmpSum) {
					if(end - 1 != start) {
						end--;
					}
					else {
						isReached = true;
						break;
					}
				}
				else {
					break;
				}
			}
			
			if(isReached == true) {
				System.out.println("3sum closest to sum=" + sum + " is "+ arr[i] + "+" 
							+ arr[start] + "+" + arr[end] + "=" + (arr[i] + arr[start] + arr[end]));
				return;
			}
		}
	}

	/**
	 * Given a string find first duplicate character.
	 * "DABFAB" -> 'A' is the first duplicate.
	 */
	private void findFirstDuplicate(String src) {
		HashSet<Character> characters = new HashSet<Character>();

		for(int i = 0; i < src.length(); i++) {
			char ch = src.toCharArray()[i];

			if(characters.contains(ch)) {
				System.out.println(ch + " is the first duplicate character in " + src);
				return;
			}

			characters.add(ch);
		}

		System.out.println("No duplicate characters found.");
	}
}
