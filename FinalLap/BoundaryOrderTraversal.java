package FinalLap;

import BinaryTree.BinaryTreeHelper;
import BinaryTree.Node;
import BinaryTree.TreeType;

public class BoundaryOrderTraversal {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        //printRightBoundary(root.right);
        printLeftBoundary(root);
        //printRightBoundaryWithLeafNodeIncluded(root);

    }

    public static void printRightBoundary(Node node){

        if(node == null){
            return;
        }

        while(node.left !=null || node.right!=null){
            //if we are inside this then we are not at leaf node
            System.out.println(node.data);
            if(node.right!=null){
                node = node.right;
            }else if(node.left!=null){
                node = node.left;
            }
        }
    }

    public static void printLeftBoundary(Node node){

        if(node == null){
            return;
        }

        while(node.left !=null || node.right!=null){
            //if we are inside this then we are not at leaf node
            System.out.println(node.data);
            if(node.left!=null){
                node = node.left;
            }else if(node.right!=null){
                node = node.right;
            }
        }
    }

    public static void printRightBoundaryWithLeafNodeIncluded(Node node){

        while(node!=null){
            //if we are inside this then we are not at leaf node
            System.out.println(node.data);
            if(node.right!=null){
                node = node.right;
            }else if(node.left!=null){
                node = node.left;
            }else{
                return;
            }
        }
    }
}
