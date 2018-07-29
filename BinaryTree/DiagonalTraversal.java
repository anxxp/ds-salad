package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        diagonalTraversal(root);
    }

    public static void diagonalTraversal(Node node){

        Queue<Node> queue = new LinkedList();
        Node currentNode = null;
        queue.offer(node);
        queue.offer(null);

        while(!queue.isEmpty()){

            currentNode = queue.poll();
            if(currentNode == null){
                currentNode = queue.poll();
                queue.offer(null);
                if (currentNode == null){
                    break;
                }
            }
            while(currentNode !=null){
                System.out.println(currentNode.data);
                if(currentNode.left!=null){

                    queue.offer(currentNode.left);
                }
                currentNode = currentNode.right;
            }
        }
    }
}
