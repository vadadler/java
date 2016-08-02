package co;

import java.lang.reflect.Array;
import java.util.Arrays;

import datastructures.BinaryTreeNode;
import datastructures.BinaryTree;


/**
 * Here are few coding challenges candidates were asked to solve 
 * while interviewing at FB.
 */
public class Facebook {
	public static void main(String[] args) {
		int[] arr = {6, 4, 0, 5, 0, 0, 0, 1, 0};
		
		System.out.println("Before sorting: " + Arrays.toString(arr));
		
		Facebook fb = new Facebook();
		fb.moveZeros(arr);
		
		System.out.println("After sorting: " + Arrays.toString(arr));
		
		// Find LCA.
		BinaryTree tree = new BinaryTree();
		tree.buildTree();
		int n1 = 5;
		int n2 = 3;
		BinaryTreeNode node = fb.findLCA(tree.getRoot(), n1, n2);
		if(node != null) {
			System.out.println("LCA(" + n1 + "," + n2 + ")=" + node.value);
		}
		else {
			System.out.println("No LCA");
		}
	}
	
	/**
	 * Given an array of ints = [6, 4, 0, 5, 0, 0, 0, 1, 0] move all non zero numbers 
	 * to the left and zeros to the right. How can you now improve your answer to O(n)?
	 */
	private void moveZeros(int[] arr) {
		int right = arr.length - 1;
		int left = 0;
		
		while(left < right) {
			if(arr[right] == 0) {		// Keep 0 on the right.
				right--;
			}
			else {
				if(arr[left] > 0) {		// Keep non 0 on the left.
					left++;
				}
				else {								// If 0 is on the left swap with non 0 on the right.
					int tmp = arr[right];
					arr[right] = arr[left];
					arr[left++] = tmp;
					right--;
				}
			}
		}
	}
	
	/**
	 * Find Lowest Common Ancestor (LCA) of a binary tree for two nodes.
	 * https://en.wikipedia.org/wiki/Lowest_common_ancestor
	 * 
	 * NOTE: this question deals with Binary Tree not BST, therefore
	 * no order is present in the tree.
	 * 
	 * Solution below uses recursive traversion of the tree starting with the root node.
	 * If root does not match either of the nodes recursively traverse left and right 
	 * subtree. Node which has one of the nodes in its left subtree and the other node
	 * in its right subtree is LCA.
	 * 
	 */
	private BinaryTreeNode findLCA(BinaryTreeNode node, int n1, int n2) {
		// Base case.
		if(node == null) {
			return null;
		}
		
		// If either of the nodes n1 and n2 match node, then
		// node is LCA.
		if(node.value == n1 || node.value == n2) {
			return node;
		}
		
		// Explore left and right subtrees.
		BinaryTreeNode leftLCA = findLCA(node.left, n1, n2);
		BinaryTreeNode rightLCA = findLCA(node.right, n1, n2);
		
		// If left subtree and right subtree has non null nodes
		// satisfying LCA condition then node is the LCA.
		if(leftLCA != null && rightLCA != null) {
			return node;
		}
		
		// Left or right subtree node might be LCA.
		return(leftLCA != null) ? leftLCA : rightLCA;
	}
	
}
