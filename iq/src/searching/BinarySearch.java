package searching;

/**
 * https://en.wikipedia.org/wiki/Binary_search_algorithm
 * 
 * Binary search works on sorted arrays.
 * 
 * Complexity O(LOG(N))
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int size = 100;
		int value = 47;
		
		System.out.println("Searching for " + value);
		
		BinarySearch bs = new BinarySearch(size);
		
		System.out.println("Found? " + bs.search(0, size, 47));
	}
	
	private int[] list;
	
	public BinarySearch(int sizeList) {
		list = new int[sizeList];
		
		// Create sorted list.
		for(int i = 0; i < sizeList; i++) {
			list[i] = i + 1; 
		}
	}
	
	/**
	 * Compare value with the value of the middle of the list.
	 * If value is less than value of the middle element recursively search left part 
	 * of the list. If value is greater than value of the middle element recursively search 
	 * right part of the list.
	 * 
	 * @param start - start of the list
	 * @param end -  end of the list
	 * @param value - value to be found
	 * @return was value found?
	 */
	private boolean search(int start, int end, int value) {
		int middle  = (end + start)/2;
		
		System.out.println(start + " " + middle + " " + end);
		
		if(value < list[middle]) {				// Search left sublist.
			return search(start, middle - 1, value);
		}
		else if(value > list[middle]) {		// Search right sublist.
			return search(middle + 1, end, value);
		}
		else if(value == list[middle]) {	// Found,
			return true;
		}
		else {														// Not found.
			return false;
		}
	}
}
