package arrays;

import java.util.Arrays;

/**
 * Find the Missing Number in a Set of Numbers from 1 to 10
 * 
 * Solution: Sum up numbers 1 to 10 and then subtract sum of array elements.
 * The result is missing number
 */
public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6,7,8,9,10};
		
		int sum1To10 = 1+2+3+4+5+6+7+8+9+10;
		int sumInArray = 0;
		for(int i = 0; i< arr.length; i++) {
			sumInArray += arr[i];
		}
		
		int missingNumber = sum1To10 - sumInArray;
		
		System.out.println("Input array: " + Arrays.toString(arr));
		System.out.println("Missing number is: " + missingNumber);
	}
}
