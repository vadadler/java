package puzzles;

/**
 * Multiple challenges dealing with traversing 2D matrix.
 */
public class Traverse2DMatrix {
	public static void main(String[] args) {
		// First index represents row and second column.
		char[][] matrix = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
		
		printMatrix(matrix);
		
		PrintAllPaths pap = new PrintAllPaths(matrix);
		pap.traverse(0, 0, "");
	}
	
	public static void printMatrix(char[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}

/**
 * Print all paths to traverse a 2D from upper left
 * corner to bottom right corner.
 */
class PrintAllPaths {
	int cntCols, cntRows;
	char[][] arr;
	
	public PrintAllPaths(char[][] a) {
		arr = a;
		cntCols = arr[0].length;
		cntRows = arr.length;
	}
	
	/**
	 * Traverse matrix from current location.
	 * 
	 * @param currCol - current column.
	 * @param currRow - current row.
	 * @param path - walks path.
	 */
	void traverse(int currRow, int currCol, String path) {
		// Base cases: last column or row.
		if(currCol == cntCols - 1) {
			for(int i = currRow; i < cntRows; i++) {
				path += "->" + arr[i][currCol];
			}
			
			System.out.println(path);
			return;
		}
		
		if(currRow == cntRows - 1) {
			for(int i = currCol; i < cntCols; i++) {
				path += "->" + arr[currRow][i];
			}
			
			System.out.println(path);
			return;
		}
		
		if(path.length() == 0) {
			path = path + arr[currRow][currCol];
		}
		else {
			path = path + "->" + arr[currRow][currCol];
		}
		traverse(currRow + 1, currCol, path);
		traverse(currRow, currCol + 1, path);
	}
}
