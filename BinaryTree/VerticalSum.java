package BinaryTree;

import LinkedList.DLLNode;
import LinkedList.LinkedListHelper;

import java.util.Stack;

public class VerticalSum {

    public static void main(String args[]) {

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);

        DLLNode header = new DLLNode();
        verticalSum(root,header);

        while(header.prev!=null){
            header = header.prev;
        }

        LinkedListHelper.printLinkedList("VERTICAL SUM :",header);

    }

    public static void verticalSum(Node currentTreeNode, DLLNode associatedDLLNode) {

        if(currentTreeNode== null){
                return ;
        }

        associatedDLLNode.data += currentTreeNode.data;

        if(currentTreeNode.left!= null && associatedDLLNode.prev == null){
            associatedDLLNode.prev = new DLLNode();
            associatedDLLNode.prev.next = associatedDLLNode;
        }
        verticalSum(currentTreeNode.left,associatedDLLNode.prev);


        if(currentTreeNode.right!=null && associatedDLLNode.next == null){
            associatedDLLNode.next = new DLLNode();
            associatedDLLNode.next.prev = associatedDLLNode;
        }
        verticalSum(currentTreeNode.right,associatedDLLNode.next);
    }

}
