package BinaryTree;

import java.util.Stack;

/**
 * This is popularly also known as zig-zag traversal
 * */
public class SpiralOrderTraversal {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println();
        System.out.println("******** SPIRAL TRAVERSAL OF THE ABOVE TREE **************");
        spiralOrderTraversal(root);
    }


    public static void spiralOrderTraversal(Node root){

        Stack<Node> oddStack = new Stack<>();
        Stack<Node> evenStack = new Stack<>();
        Node currentNode;
        if(root!=null){
            oddStack.push(root);
        }
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){

                while(!oddStack.isEmpty()){
                    currentNode = oddStack.pop();
                    System.out.print(currentNode.data+" ");
                    if(currentNode.left!=null){
                        evenStack.push(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        evenStack.push(currentNode.right);
                    }
                }

                while(!evenStack.isEmpty()){
                    currentNode = evenStack.pop();
                    System.out.print(currentNode.data+" ");
                    if(currentNode.right!=null){
                        oddStack.push(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        oddStack.push(currentNode.left);
                    }
                }
        }
    }
}
