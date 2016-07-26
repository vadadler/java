package arrays;

import java.util.Arrays;

/**
 * Merge two arrays of integers.
 * 1. Sort both arrays.
 *
 */
public class MergeTwoArrays {
	public static void main(String[] args) {
		int[] a = {1,2,4,7};
		int[] b = {3,5,6};
		
		System.out.println("Original arrays: a=" + Arrays.toString(a) + " b=" + Arrays.toString(b));
		
		MergeTwoArrays mta = new MergeTwoArrays();
		System.out.println("Merged array: " + Arrays.toString(mta.mergeSorted(a, b)));
	}
	
	/**
	 * Merge two sorted arrays.
	 * 
	 * @param a sorted array.
	 * @param b sorted array.
	 * @return merged array.
	 */
	private int[] mergeSorted(int[] a, int[] b) {
		// Create a bigger arry which can hold both a and b arrays.
		int ret[] = new int[a.length + b.length];
		
		// Copy arr a into ret.
		System.arraycopy(a, 0, ret, 0, a.length);
		
		int n = a.length - 1;
		int m = b.length - 1;
		int i = n + m + 1;
		
		while(n >= 0 && m >= 0) {
			if(a[n] > b[m]) {
				ret[i--] = a[n--];
			}
			else {
				ret[i--] = b[m--];
			}
		}
		
		return ret;
	}
}
