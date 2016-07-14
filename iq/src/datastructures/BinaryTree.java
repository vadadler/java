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
	
	public BinaryTreeNode getRoot() { return root; }
}
