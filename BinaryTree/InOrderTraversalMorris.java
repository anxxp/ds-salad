package BinaryTree;
/***
 * The Recursive and the Stack based Iterative implementation of the In-Order Traversal
 * both uses extra space. The extra space is in the order of O(height), which in worst
 * case would be O(number of nodes).
 *
 * The stack was used to keep track of the in-order successor. Morris suggest to
 * establish a link to the in-order successor and then traverse the left sub-tree.
 * */

public class InOrderTraversalMorris {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        inOrderTraversalMorris(root);
    }

    public static void inOrderTraversalMorris(Node root){

        Node currentNode = root;
        Node inOrderPredecessor;

        while(currentNode != null){

            if(currentNode.left == null){
                System.out.print(currentNode.data+" ");
                currentNode = currentNode.right;
            }else{

                inOrderPredecessor = currentNode.left;

                while(inOrderPredecessor.right!= null &&
                        inOrderPredecessor.right.data!=currentNode.data){
                    inOrderPredecessor = inOrderPredecessor.right;
                }
                if(inOrderPredecessor.right == null){
                    inOrderPredecessor.right = currentNode;
                    currentNode = currentNode.left;
                }else{
                    System.out.print(currentNode.data+" ");
                    currentNode = currentNode.right;
                    inOrderPredecessor.right = null;
                }
            }
        }
    }

}
