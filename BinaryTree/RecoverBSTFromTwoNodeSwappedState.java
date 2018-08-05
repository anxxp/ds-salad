package BinaryTree;

import java.util.Stack;

public class RecoverBSTFromTwoNodeSwappedState {

    public static void main(String args[]){

        System.out.println("CASE 1: When two non-adjacent numbers are swapped");
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST_TWO_NODES_SWAPPED);
        System.out.println("INPUT");
        InOrderTraversalIterative.inOrderTraversalIterative(root);
        recoverBSTFromTwoNodeSwappedState(root);
        System.out.println("\nOUTPUT");
        InOrderTraversalIterative.inOrderTraversalIterative(root);



        System.out.println("\n\n\nCASE 2: When two adjacent numbers are swapped");
        root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST_TWO_ADJ_NODES_SWAPPED);
        System.out.println("INPUT");
        InOrderTraversalIterative.inOrderTraversalIterative(root);
        recoverBSTFromTwoNodeSwappedState(root);
        System.out.println("\nOUTPUT");
        InOrderTraversalIterative.inOrderTraversalIterative(root);
    }

    public static void recoverBSTFromTwoNodeSwappedState(Node root){

        Node currentNode = root;
        Node firstNode = null;
        Node secondNode = null;
        Node thirdNode = null;
        Node prevNode = null;
        Stack<Node> stack = new Stack<Node>();

        while(true){

            if(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }else{

                if(stack.isEmpty()){
                    break;
                }else{
                    currentNode = stack.pop();

                    if(prevNode!=null && prevNode.data>currentNode.data){

                        if(firstNode == null && secondNode == null){
                            firstNode = prevNode;
                            secondNode = currentNode;
                        }else{
                            thirdNode = currentNode;
                        }
                    }
                    //System.out.println(currentNode.data);
                    prevNode = currentNode;
                    currentNode = currentNode.right;
                }
            }
        }

        if(thirdNode!=null){
            int temp = firstNode.data;
            firstNode.data = thirdNode.data;
            thirdNode.data = temp;
        }else{
            int temp = firstNode.data;
            firstNode.data = secondNode.data;
            secondNode.data = temp;
        }
    }
}
