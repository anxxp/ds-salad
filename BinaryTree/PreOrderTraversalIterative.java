package BinaryTree;

import java.util.Stack;

public class PreOrderTraversalIterative {
    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        preOrderTraversalIterative(root);
    }

    public static void preOrderTraversalIterative(Node root){
        Node currentNode;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            currentNode = stack.pop();
            System.out.print(currentNode.data+" ");

            /**
             * Note : We push the right child first and then the left child.
             * This is done because we pop in the reverser order we push.
             * We wish to access the left child first and then the right child.
             * */

            if(currentNode.right != null){
                stack.push(currentNode.right);
            }

            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }
    }
}
