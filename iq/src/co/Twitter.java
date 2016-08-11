package co;

public class Twitter {
	public static final int MAX_VERT = 11;

	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.mouseAndCheese();
	}
	
	/**
	 * Mouse and cheese trap question: There is a grid, and mouse is in 
	 * one coordinate. He has to reach the cheese. There are mousetraps 
	 * and walls, means he mouse cannot go to those grids. Find the 
	 * smallest path for the mouse to reach cheese.
	 * 
	 * Solution: Grid is represented by a graph. Where vertices are accessible cells.
	 * Root of the graph is cell where the search begins. BFS algorithm gives shortest
	 * path (assuming all edges have the same weight) in terms of number of steps. 
	 * BFS uses queue.
	 */
	public void mouseAndCheese() {
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		Vertex i = new Vertex("I");
		Vertex j = new Vertex("J");
		Vertex k = new Vertex("K");
		
		Graph graph = new Graph();
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);

		graph.addEdge(0, 0);
		graph.addEdge(0, 1);
		graph.addEdge(1, 1);
		graph.addEdge(2, 1);
		graph.addEdge(3, 1);
		graph.addEdge(2, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.addEdge(4, 3);
		
		graph.print();
		
		graph.findCheese("h");
	}
	
	/**
	 * Very rudimentary queue. Keep two pointers head and tail
	 * and adjust them based on operation.
	 */
	private class Queue {
		private int[] arr = new int[2*MAX_VERT];
		int tail = 0, head = 0;
		
		public void enqueue(int v) { arr[tail++] = v;}
		public int dequeu() { return arr[head++]; }
		public boolean isEmpty() { return tail == head; }
	}
	
	private class Stack {
		private int[] arr = new int[MAX_VERT];
		private int top = -1;
		public boolean isEmpty() {return top == -1;}
		public void push(int v) {arr[++top] = v;}
		public int pop() {return arr[top--];}
		public int peek() { return arr[top]; }
		
		// Return string representation of bottom up stack. 
		public String toBottomUpString() {
			StringBuffer sb = new StringBuffer();
			
			for(int i = 0; i <= top; i++) {
				sb.append(arr[i]);
			}
			return sb.toString();
		}
	}
	
	private class Vertex {
		public String label;
		public boolean isVisited = false;
		
		public Vertex(String l) {
			label = l;
			isVisited = false;
		}
	}
	
	private class Graph {
		int[][] adjMatrix = new int[MAX_VERT][MAX_VERT];
		public Vertex[] vertices = new Vertex[MAX_VERT];
		int size = -1;
		
		public void addVertex(Vertex v) {
			vertices[++size] = v;
		}
		
		public void addEdge(int start, int end) {
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
		
		public void print() {
			for(int i = 0; i < MAX_VERT; i++) {
				for(int j = 0; j < MAX_VERT; j++) {
					System.out.print(adjMatrix[j][i] + " ");
				}
				System.out.println();
			}
		}
		
		/**
		 * Print traversal path to cheese.
		 */
		public void printPath(Queue queue) {
			System.out.println();
		}
		
		public void printVertex(int index) {
			System.out.print(vertices[index].label + " ");
		}
		
		/**
		 * BFS approach with queue should find shortest path.
		 */
		public void findCheese(String cheese) {
			Queue queue = new Queue();
			queue.enqueue(0);
			vertices[0].isVisited = true;
			printVertex(0);
			
			// Lucky. The first cell contains cheese.
			if(vertices[0].label.equals(cheese)) {
				printPath(queue);
				return;
			}
			
			while(queue.isEmpty() == false) {
				int nextUnvisitedIndex = getUnvisitedVertex(queue.dequeu());
				if(nextUnvisitedIndex >= 0) {
					queue.enqueue(nextUnvisitedIndex);
					vertices[nextUnvisitedIndex].isVisited = true;
					
					printVertex(nextUnvisitedIndex);
					
					// Check is the cheese cell.
					if(vertices[nextUnvisitedIndex].label.equals(cheese)) {
						printPath(queue);
						return;
					}		
				}
			}
			
			// No cheese found :(
			System.out.println();
			System.out.println("Could not find the cheese");
		}
		
		/**
		 * Find unvisited vertex of another vertex.
		 * @param v of the input vertex in adjacency matrix. 
		 * @return index of the next unvisited vertex.
		 * 				-1 there is no more unvisited vertices.
		 */
		public int getUnvisitedVertex(int v) {
			for(int i = 0; i < MAX_VERT; i++) {
				if(adjMatrix[v][i] == 1 && vertices[i].isVisited == false) {
					return i;
				}
			}
			return -1;
		}
	}
}
