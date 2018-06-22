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
        if(currentNode == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        while(true){

            if(currentNode != null){

                stack.push(currentNode);
                currentNode = currentNode.left;

            }else{
                if(stack.isEmpty()){
                    break;
                }
                currentNode = stack.pop();
                System.out.print(" "+currentNode.data);
                currentNode = currentNode.right;
            }
        }
    }
}
