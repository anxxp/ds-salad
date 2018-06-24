package BinaryTree;
/**
 * The logic of Morris pre-order traversal is same as that of the
 * Morris in-order traversal, except that we print the current node
 * when we current node moves to the right child instead when
 * current node move to the left.
 *
 * Refer the in-order counterpart for explanation of algorithm
 * */
public class PreOrderTraversalMorris {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        preOrderTraversalMorris(root);
    }

    public static void preOrderTraversalMorris(Node root){
        if(root == null){
            return;
        }
        Node currentNode = root;
        Node inOrderPredecessor;

        while(currentNode != null){

            if(currentNode.left == null){
                System.out.print(currentNode.data+" ");
                currentNode = currentNode.right;
            }else{
                inOrderPredecessor = currentNode.left;
                while(inOrderPredecessor.right!=null &&
                        inOrderPredecessor.right.data!= currentNode.data){
                    inOrderPredecessor = inOrderPredecessor.right;
                }
                if(inOrderPredecessor.right == null){
                    inOrderPredecessor.right = currentNode;
                    System.out.print(currentNode.data+" ");
                    currentNode = currentNode.left;
                }else{

                    currentNode = currentNode.right;
                    inOrderPredecessor.right = null;
                }
            }
        }
    }
}
