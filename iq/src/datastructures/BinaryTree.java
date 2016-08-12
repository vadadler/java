package datastructures;

public class BinaryTree {
	private BinaryTreeNode root;
	public static void main(String[] args) {
		
	}
	
	public void buildTree() {
		root = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
	}
	
	public BinaryTreeNode invertBinaryTree(BinaryTreeNode root) {
		if(root != null) {
			invertRecursive(root);
		}
		
		return root;
	}
	
	private void invertRecursive(BinaryTreeNode node) {
		BinaryTreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		if(node.left != null) {
			invertRecursive(node.left);
		}
		
		if(node.right != null) {
			invertRecursive(node.right);
		}
	}
	
	private void invertIterative(BinaryTreeNode root) {
		
	}
	
 	public BinaryTreeNode getRoot() { return root; }
 	
 	
 	/**
 	 * Find minimum depth of a binary tree.
 	 * Classic BFS problem.
 	 * @param root
 	 * @return
 	 */
 	private int minDepth(BinaryTreeNode root) {
 		int depth = 0;
 		
 		if(root != null) {
 			java.util.Queue<BinaryTreeNode> currentLevel = new java.util.LinkedList<BinaryTreeNode>();
 			java.util.Queue<BinaryTreeNode> nextLevel = new java.util.LinkedList<BinaryTreeNode>();
 			
 			currentLevel.add(root);
 			
 			while(currentLevel.isEmpty() == false) {
 				BinaryTreeNode node = currentLevel.poll();
 				
 				// Reached leaf node.
 				if(node.left == null && node.right == null) {
 					depth = currentLevel.size();
 				}
 				else {
 					if(node.left != null) {
 						nextLevel.add(node.left);
 					}
 					
 					if(node.right != null) {
 						nextLevel.add(node.right);
 					}
 				}
 			}
 			
 		}
 		
 		return depth;
 	}
}
