package datastructures;
/**
 * Binary Search Tree
 *
 */
public class BST {
   BSTNode mRoot;
   
   public static void main(String[] args) {
      BST bst = new BST();
      /*
             50
          25    75
        15  30     85
       */
      bst.addNode(new BSTNode(50));
      bst.addNode(new BSTNode(25));
      bst.addNode(new BSTNode(75));
      bst.addNode(new BSTNode(15));
      bst.addNode(new BSTNode(30));
      bst.addNode(new BSTNode(85));
      
      // In-order traversal.
      System.out.println("In order left->root->right");
      bst.inOrderTraversal(bst.mRoot);

      // Post-order traversal
      System.out.println("\nPost order left->right->root");
      bst.postOrderTraversal(bst.mRoot);

      // Pore-order traversal
      System.out.println("\nPre order root->left->right");
      bst.preOrderTraversal(bst.mRoot);

   }
   
   /**
    * Add node to the tree.
    * @param n Node to add.
    */
   public void addNode(BSTNode n) {
      BSTNode tmp = mRoot;
      
      while(true) {
         if(mRoot == null) {
            mRoot = n;
            return;
         }
         
         if(n.value < tmp.value) {
            if(tmp.leftNode != null) {
               tmp = tmp.leftNode;
            }
            else {
               tmp.leftNode = n;
               return;
            }
         }
         else {
            if(tmp.rightNode != null) {
               tmp = tmp.rightNode;
            }
            else {
              tmp.rightNode = n;
              return;
            }
         }
      }
   }
   
   /**
    * Left->Root->Right
    * @param root
    */
   public void inOrderTraversal(BSTNode node) {
      if(node != null) {
         inOrderTraversal(node.leftNode);
         System.out.print(node.value + " ");
         inOrderTraversal(node.rightNode);
      }
   }
   
   /**
    * Left->Right->Root
    * @param root
    */
   public void postOrderTraversal(BSTNode node) {
      if(node != null) {
         postOrderTraversal(node.leftNode);
         postOrderTraversal(node.rightNode);
         System.out.print(node.value + " ");
      }
   }   

   /**
    * Root->Left->Right
    * @param root
    */
   public void preOrderTraversal(BSTNode node) {
      if(node != null) {
         System.out.print(node.value + " ");
         preOrderTraversal(node.leftNode);
         preOrderTraversal(node.rightNode);
      }
   }   
}

class BSTNode {
   int value;
   BSTNode leftNode;
   BSTNode rightNode;
   
   public BSTNode(int v) {
      value = v;
   }
}


