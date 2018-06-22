package BinaryTree;

public class InOrderTraversalRecursive {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        inOrderTraversalRecursive(root);
    }

    public static void inOrderTraversalRecursive(Node node){

        if(node == null){
            return;
        }

        inOrderTraversalRecursive(node.left);
        System.out.print(" "+node.data);
        inOrderTraversalRecursive(node.right);
    }
}
