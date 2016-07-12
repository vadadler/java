package puzzles;

import java.util.concurrent.TimeUnit;

/**
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 * The minimum number of moves required to solve a Tower of Hanoi puzzle is 2n - 1, 
 * where n is the number of disks
 *
 * Three rods are A (from), B (temp) and C(to)
 * To move n discs from peg A to peg C:
 *
 * move n−1 discs from A to B. This leaves disc n alone on peg A
 * move disc n from A to C
 * move n−1 discs from B to C so they sit on disc n
 */
public class TowersOfHanoi {
	private int size;	// Number of rings.
	
	public static void main(String[] args) {
		TowersOfHanoi towers = new TowersOfHanoi(3);
		
		String from = "A";
		String temp = "B";
		String to = "C";
		
		int n = 3;
		
		long t1 = System.currentTimeMillis();
		towers.solve(n, from, to, temp);
		long t2 = System.currentTimeMillis();
		
		//System.out.println("It took " + TimeUnit.MILLISECONDS.toSeconds(t2 - t1) + " seconds to move " + n + " disks");
	}
	
	public TowersOfHanoi(int s) {
		size = s;
	}
	
	private void solve(int size, String from, String to, String temp ) {
		if(size == 1) {
			System.out.println(from + "->" + to);
		}
		else {
			// Move size-1 discs from source to temp pole.
			solve(size - 1, from, temp, to);
			
			// Move last disc to destination pole.
			solve(1, from, to, temp);
			
			//Move size-1 disks from temp to destination.
			solve(size - 1, temp, to, from);
		}
	}
}
