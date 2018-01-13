package arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Find duplicate entries in input array.
 */
public class Duplicates {
	public static void main(String[] args) {
		int[] a = {1,2,4,3,2,6,3};
		
		Duplicates d = new Duplicates();
		System.out.println("Original array: " + Arrays.toString(a));
		System.out.println("Duplicates: Using 2 HashSets : " + d.duplicates2HashSets(a));
		System.out.println("Duplicates: Using sort array : " + d.duplicatesSortArray(a));
	}
	
	private String duplicates2HashSets(int[] arr) {
		HashSet<Integer> values = new HashSet<Integer>();
		HashSet<Integer> duplicates = new HashSet<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			int value = arr[i];
			if(values.isEmpty() == true) {
				values.add(value);
			}
			else {
				if(values.contains(value) == true) {
					duplicates.add(value);
				}
				else {
					values.add(value);
				}
			}
		}
		
		return duplicates.toString();
	}
	
	private String duplicatesSortArray(int[] arr) {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		
		Arrays.sort(arr);
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i - 1]) {
				duplicates.add(arr[i]);
			}
		}
		
		return duplicates.toString();
	}
	
}
