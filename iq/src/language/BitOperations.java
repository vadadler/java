package language;

import java.util.Arrays;

public class BitOperations {
	public static void main(String[] args) {
		int a = 2, b = 4;
		int shift = 1;
		
		BitOperations bo = new BitOperations();
		
		bo.shiftRight(a, shift);
		
		//System.out.println(bo.int2bin(b));
	}
	
	/**
	 *  0001 << 1 = 0010
	 *   
	 *  Left shift by 1 == multiplication by 2: 2<<1=4
	 *  Generic formula: x<<n=x*2^n
	 */
	private void shiftLeft(int value, int by) {
		
	}
	
	/** 
	 * 0010 >> 1 = 0001
	 * 
	 *  Right shift by 1 == division by 2: 4>>2=2
	 *  Right shift keeps the sign bit (32nd bit of an int).
	 *  
	 */
	private void shiftRight(int value, int by) {
		System.out.println("Right shift Java: " + Integer.toString(value) + ">>" + by + "=" + Integer.toString(value>>by));
		
		String strValue = int2bin(value);
		StringBuilder sb = new StringBuilder();
		char signValue = strValue.charAt(0);
		
		for(int i = 0; i < Integer.SIZE; i++) {
			// Preserve sign bit.
			if(i == 0) {
				sb.append(strValue.charAt(i));
			}
			else {
				sb.append(strValue.charAt(i - 1));
			}
		}
		
		System.out.println("Right shift by hand: " + value + ">>" + by + "=" + sb.toString());
	}
	
	/**
	 * The same as right shift except it changes sign bit (32nd for int).
	 * @param value
	 * @param by
	 */
	private void shiftRightUnsigned(int value, int by) {
		
	}
	
	private void xor() {
		
	}
	
	/**
	 * Bitwise AND (&) two numbers.
	 * @param a
	 * @param b
	 */
	private void and(int a, int b) {
		
	}
	
	/**
	 * Swap two numbers without using temp varialbe.
	 * @param left
	 * @param right
	 */
	private void swap(int left, int right) {
		
	}
	
	/**
	 * Calculate sum of two ints without using arithmetic signs.
	 * @param a
	 * @param b
	 */
	private void sum(int a, int b) {
		
	}
	
	/**
	 * Convert integer to binary string.
	 * @param i
	 * @return
	 */
	private String int2bin(int n) {
		StringBuffer sb = new StringBuffer();
		int[] arrBin = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		int pos = arrBin.length - 1;
		
		while(n != 0) {
			int d = n % 2;
			arrBin[pos--] = d;
			n = n / 2;
		}
		
		for(int i = 0; i< arrBin.length; i++) {
			sb.append(arrBin[i]);
		}
		return sb.toString();
	}
	
	private int binString2int(String binStr) {
		int result = 0;
		
		return result;
	}
}
