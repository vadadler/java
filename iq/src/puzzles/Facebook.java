package puzzles;

import java.util.Arrays;

/**
 * Here are few coding challenges candidates were asked to solve 
 * while interviewing at FB.
 */
public class Facebook {
	public static void main(String[] args) {
		int[] arr = {6, 4, 0, 5, 0, 0, 0, 1, 0};
		
		System.out.println("Before sorting: " + Arrays.toString(arr));
		
		Facebook fb = new Facebook();
		fb.moveZeros(arr);
		
		System.out.println("After sorting: " + Arrays.toString(arr));
	}
	
	/**
	 * Given an array of ints = [6, 4, 0, 5, 0, 0, 0, 1, 0] move all non zero numbers 
	 * to the left and zeros to the right. How can you now improve your answer to O(n)?
	 */
	private void moveZeros(int[] arr) {
		int right = arr.length - 1;
		int left = 0;
		
		while(left < right) {
			if(arr[right] == 0) {		// Keep 0 on the right.
				right--;
			}
			else {
				if(arr[left] > 0) {		// Keep non 0 on the left.
					left++;
				}
				else {								// If 0 is on the left swap with non 0 on the right.
					int tmp = arr[right];
					arr[right] = arr[left];
					arr[left++] = tmp;
					right--;
				}
			}
		}
	}
	
	
}
