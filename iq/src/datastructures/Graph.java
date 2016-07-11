package datastructures;

public class Graph {
  public static final int MAX_VERT = 20;
  public int[][] adjMatrix = new int[MAX_VERT][MAX_VERT];
  public Vertex[] vertices = new Vertex[MAX_VERT];
  private int count = 0;
  
  public static void main(String[] args) {
    GraphApp app = new GraphApp();
    Graph graph = app.makeGraph();
    
    Vertex a = new Vertex('A');
    Vertex b = new Vertex('B');
    Vertex c = new Vertex('C');
    Vertex d = new Vertex('D');
    Vertex e = new Vertex('E');
    Vertex f = new Vertex('F');
    Vertex g = new Vertex('G');
    Vertex h = new Vertex('H');
    Vertex i = new Vertex('I');
    
    graph.addVertex(a);
    graph.addVertex(b);
    graph.addVertex(c);
    graph.addVertex(d);
    graph.addVertex(e);
    graph.addVertex(f);
    graph.addVertex(g);
    graph.addVertex(h);
    graph.addVertex(i);
    
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 3);
    graph.addEdge(0, 4);
    graph.addEdge(1, 5);
    graph.addEdge(5, 6);
    graph.addEdge(3, 7);
    graph.addEdge(7, 8);
    
    //graph.dfs();
    graph.bfs();
  }
  
  public void addVertex(Vertex v) {
    vertices[count++] = v;
  }
  
  public void addEdge(int start, int end) {
    adjMatrix[start][end] = 1;
    adjMatrix[end][start] = 1;
  }
  
  public void dfs() {
    DFSStack stack = new DFSStack();
    stack.push(0);
    vertices[0].wasVisited = true;
    printVertex(0);
    
    while(stack.isEmpty() == false) {
      int unvisitedIndex = getUnvisitedVertex(stack.peek());
      if(unvisitedIndex >= 0) {
        stack.push(unvisitedIndex);
        vertices[unvisitedIndex].wasVisited = true;
        printVertex(unvisitedIndex);
      }
      else {
        stack.pop();
      }
    }
  }
  
  
  public void bfs() {
    int v2;
    BFSQueue queue = new BFSQueue();
    queue.enqueue(0);
    vertices[0].wasVisited = true;
    printVertex(0);
    
    while(queue.isEmpty() == false) {
      int v1 = queue.dequeue();
      while((v2 = getUnvisitedVertex(v1)) >= 0) { 
        queue.enqueue(v2);
        vertices[v2].wasVisited = true;
        printVertex(v2);
      }
    }
  }
  
  private int getUnvisitedVertex(int v) {
    for(int i = 0; i < MAX_VERT; i++) {
      if(adjMatrix[v][i] == 1 && vertices[i].wasVisited == false) {
        return i;
      }
    }
    return -1;
  }
  
  
  public void printVertex(int i) {
    System.out.print(vertices[i].label + " ");
  }
  
  public void printAdjMatrix() {
    for(int i = 0; i < MAX_VERT; i++) {
      for(int j = 0; j < MAX_VERT; j++) {
        System.out.print(adjMatrix[i][j] + " ");
      }
      System.out.println();
    }        
  }
}

class GraphApp {
  public Graph makeGraph() {
    Graph graph = new Graph();
    return graph;
  }  
}

class Vertex {
  public char label;
  public boolean wasVisited = false;
  
  public Vertex(char l) {
    label = l;
  }
}

class DFSStack {
  int top = -1;
  int[] data = new int[Graph.MAX_VERT];
  public void push(int i) {data[++top] = i;}
  public int pop() {return data[top--];}
  public int peek() {return data[top];}
  public boolean isEmpty() {return top == -1;}
}

// Not the most efficient queue.
// Enqueue: increase tail index.
// Dequeue: increase head index.
class BFSQueue {
  int[] data = new int[2 * Graph.MAX_VERT];
  int head = 0, tail = 0;
  
  public void enqueue(int i) {
    data[tail++] = i;
  }
  
  public int dequeue() {
    return data[head++];
  }
  
  public boolean isEmpty() {
    return head == tail;
  }
}
