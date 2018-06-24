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
            /**
             * If the current node is NOT NULL , then we check whether the
             * current node has a left child or not
             * */
            if(currentNode.left == null){
                /**
                 * If the current node doesn't have a left sub-tree
                 * then,we print the current node and move to the right child.
                 * */
                System.out.print(currentNode.data+" ");
                currentNode = currentNode.right;
            }else{
                /**
                 * If the current node has a left child , then before navigating
                 * to the right child we first find the in-order predecessor of the
                 * current node.
                 * */
                inOrderPredecessor = currentNode.left;

                while(inOrderPredecessor.right!= null &&
                        inOrderPredecessor.right.data!=currentNode.data){
                    inOrderPredecessor = inOrderPredecessor.right;
                }

                /**
                 * If the in-order predecessor doesn't have right child then,
                 * we point the current node with it. This is done because, during in-order traversal ,
                 * the predecessor node will be followed by the current node.Establishing this link will
                 * do away the need of a stack.
                 *
                 * The else, part is to handle the case when we have already traversed the nodes.
                 * In such case we remove the link to restore the initial structure of tree.
                 */
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
