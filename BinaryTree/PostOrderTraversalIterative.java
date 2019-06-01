package BinaryTree;

import java.util.Stack;

public class PostOrderTraversalIterative {

    public static void main(String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println(

        );
        postOrderTraversalIterative(root);
    }

    private static void postOrderTraversalIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        Node temp;


        while(currentNode != null || !stack.isEmpty()){

            if(currentNode!= null){
                stack.push(currentNode);
                currentNode = currentNode.left;

            }else{

                temp = stack.peek().right;
                if(temp!= null){
                    currentNode = temp;

                }else{

                    temp = stack.pop();
                    System.out.print(temp.data+" ");

                    while(!stack.isEmpty() && temp ==stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
            }
        }
    }
}
