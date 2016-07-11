package datastructures;

/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */
 
public class BinarySearchTree {

  // Add, search remove node.
  
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    
    tree.add(15);
    tree.add(6);
    tree.add(22);
    tree.add(8);
    tree.add(5);
    tree.add(31);
    tree.add(9);
    tree.add(19);
    
    tree.printInOrder(tree.root);
    System.out.println("");
    tree.printPreOrder(tree.root);
    System.out.println("");
    tree.printPostOrder(tree.root);
    System.out.println("");
    System.out.println("Size: " + tree.size());
    System.out.println("Levels: " + tree.levels());
  }
  
  BSTNode root;
  int size;
  Integer lastValue = null;
  
  public BinarySearchTree() {
    root = null;
  }
  
  public boolean add(int v){
    if(root == null) {
      root = new BSTNode(v);
      return true;
    }
    else {
      return root.add(v);
    }
  }
  
  public boolean search(int v) {
    if(root == null) {
      return false;
    }
    return root.search(v);
  }
  
  public boolean remove(int v) {
    if(root == null) {
      return false;
    }
    
    if(v == root.value) {
      return false;
    }
    else {
      return root.remove(v, null);
    }
  }
 
  /**
   * Get number nodes in the tree. I.e. size of the tree.
   */
  public int size() {
    if(root == null) return 0;
    return root.size(root);
  }
  
  /**
   * Get number of levels in the tree.
   */
  public int levels() {
    if(root == null) return 0;
    return root.levels(root);
  }
  
  /**
   * Determine if binary tree is BST or not.
   * @param node - root of the tree.
   * @return true if BST, false otherwise.
   */
  public boolean isBST(BSTNode node) {
    if(node == null)
      return true;
    
    // Max on the left is greater than current value.
    if(node.left != null && node.left.MaxValue() > node.value)
      return false;
    
    // Min on the right is less than current value.
    if(node.right != null && node.right.MinValue() < node.value)
      return false;
    
    // Left of right tree is not BST.
    if(!isBST(node.left) || !isBST(node.right))
      return false;
    
    return true;
  }

  /**
   * In-order: left->root->right. Type of DFS.
   */
  public void printInOrder(BSTNode node) {
    if(node != null) {
      printInOrder(node.left);
      System.out.print(node.value + " ");
      printInOrder(node.right);
    }
  }
  
  /**
   * Pre-order: root->left->right. Type of DFS.
   */
  public void printPreOrder(BSTNode node) {
    if(node != null) {
      System.out.print(node.value + " ");
      printInOrder(node.left);
      printInOrder(node.right);
    }    
  }
  
  /**
   * Post-order: left->right->root. Type of DFS.
   *
   */
  public void printPostOrder(BSTNode node) {
    if(node != null) {
      printInOrder(node.left);
      printInOrder(node.right);
      System.out.print(node.value + " ");
    }    
  }

  /**
   * Using In-order traversing.
   * Keep value of the last visited element and compare. 
   */
  public boolean isBSTInOrder(BSTNode node) {
    if(node == null) return true;
    
    if(!isBSTInOrder(node.left)) return false;
    
    if(lastValue != null && lastValue > node.value) return false;
    lastValue = node.value;
    
    if(!isBSTInOrder(node.right)) return false;
    
    return true;
  }
  
  /**
   * Using min-max.
   */
  public boolean isBSTMinMax(BSTNode node, Integer min, Integer max) {
    if(node == null) return true;
    
    if((min != null && node.value <= min) ||
      (max != null && node.value >= max))
      return false;
    
    if(!isBSTMinMax(node.left, min, node.value)) return false;
    if(!isBSTMinMax(node.right, node.value, max)) return false;
    
    return true;
  }
  
  class BSTNode {
    private int value;
    private BSTNode left;
    private BSTNode right;
    
    public BSTNode(int v) {
      value = v;
      left = null;
      right = null;
    }
    
    public boolean add(int v) {
      if(v == value) {
        return false;
      }
      else {
        if(v < value) {
          if(left == null) {
            left = new BSTNode(v);
            return true;
          }
          else {
            return left.add(v);
          }
        }
        else if(v > value) {
          if(right == null) {
            right = new BSTNode(v);
            return true;
          }
          else {
            return right.add(v);
          }
        }
      }
      return false;
    }
  
    public boolean search(int v) {
      if(v == value) {
        return true;
      }
      
      if (v < value) {
        if(left == null) {
          return false;
        }
        else {
          return left.search(v);
        }
      }
      else if (v > value) {
        if(right == null) {
          return false;
        }
        else {
          return right.search(v);
        }
      }
      
      return false;
    }
  
    public boolean remove(int v, BSTNode parent) {
      if (v < value) {
        if(left != null) {
          return left.remove(v, this);
        }
        else {
          return false;
        }
      }
      else if (v > value) {
        if(right != null) {
          return right.remove(v, this);
        }
        else {
          return false;
        }
      }
      else {
        if(left != null && right != null) {
          value = right.MinValue();
          return remove(value, this);
        }
        else if(parent.left == this) {
          parent.left = (left != null) ? left : right;
        }
        else if(parent.right == this) {
          parent.right = (left != null) ? left : right;
        }
      }
      return false;
    }
    
    // Size of the tree.
    private int size(BSTNode node) {
      if(node == null) return 0;
      return size(node.left) + 1 + size(node.right);
    }
    
    // Depth (# of levels) of the tree.
    private int levels(BSTNode node) {
      if(node == null) return 0;
      int leftLevels = levels(node.left);
      int rightLevels = levels(node.right);
      return (Math.max(leftLevels, rightLevels) + 1);
    }
    
    // Min value in the tree.
    private int MinValue() {
      if(left == null) {
        return value;
      }
      return left.MinValue();
    }
    
    // Max value in the tree.
    private int MaxValue() {
      if(right == null)
        return value;
      return right.MaxValue();
    }
  }
}
