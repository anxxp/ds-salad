package BinaryTree;

import java.util.Stack;

public class InOrderTraversalIterative {

    public static void main(String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        inOrderTraversalIterative(root);
        /***
         *
         * Verify the result with Recursive solution.
         * System.out.println();
         * InOrderTraversalRecursive.inOrderTraversalRecursive(root);
         */

    }
    public static void inOrderTraversalIterative(Node root){

        Node currentNode = root;
        Stack<Node> stack = new Stack<>();
        while(! stack.isEmpty() || currentNode != null){

            if(currentNode != null){

                stack.push(currentNode);
                currentNode = currentNode.left;

            }else{

                currentNode = stack.pop();
                System.out.print(" "+currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }
}
