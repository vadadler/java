package puzzles;

import java.util.Arrays;

/**
 * Given an array numbers, write a function to move all 0's to the end/beginning
 * of it while maintaining the relative order of the non-zero elements.
 * 
 * For example: {0,2,0,4,3} -> {2,4,3,0,0} or {0,0,2,4,3}
 */
public class MoveZeros {
	public static void main(String[] args) {
		int[] arr1 = {0,2,0,4,3};
		int[] arr2 = {0,2,0,4,3};
		
		System.out.println("Original array: " + Arrays.toString(arr1));
		
		MoveZeros mz = new MoveZeros();
		mz.moveZerosBack(arr1);
		mz.moveZerosFront(arr2);
		
		System.out.println("Moved zeros back: " + Arrays.toString(arr1));
		System.out.println("Moved zeros front: " + Arrays.toString(arr2));
	}
	
	/**
	 * Maintain 2 pointers. One (j) points to the next not 0 value.
	 * The other (i) points to element with 0 value. 
	 */
	private void moveZerosBack(int[] arr) {
		int i = 0, j = 0;
		
		// By the end of this loop all not-0 values will be at the front
		// of the array. Value of i will tell how may 0 to add to the end
		// of the array.
		while(j < arr.length) {
			if(arr[j] == 0) {
				j++;
			}
			else {
				arr[i++] = arr[j++];
			}
		}
		
		// Fill the rest with 0s.
		while(i < arr.length) {
			arr[i++] = 0;
		}
	}
	
	/**
	 * Similar to moveZerosBack maintain two pointers.
	 * The difference is to start from the end of array 
	 * and decrement pointers while walking the array.
	 */
	private void moveZerosFront(int[] arr) {
		int i = arr.length - 1;
		int j = i;
		
		while(j >= 0) {
			if(arr[j] == 0) {
				j--;
			}
			else {
				arr[i--] = arr[j--]; 
			}
		}
		
		while(i >= 0) {
			arr[i--] = 0;
		}
	}
}
