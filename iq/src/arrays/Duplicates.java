package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class Duplicates {
	public static void main(String[] args) {
		int[] a = {1,2,4,3,2,6,3};
		
		Duplicates d = new Duplicates();
		System.out.println("Original array: " + Arrays.toString(a));
		System.out.println("Duplicates: Using 2 HasSets : " + d.duplicates2HashSets(a));
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
}
