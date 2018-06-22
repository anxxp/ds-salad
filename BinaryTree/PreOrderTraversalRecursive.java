package BinaryTree;

public class PreOrderTraversalRecursive {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        preOrderTraversalRecursive(root);
    }

    public static void preOrderTraversalRecursive(Node node){
        if(node == null){
            return;
        }
        System.out.print(" "+node.data);
        preOrderTraversalRecursive(node.left);
        preOrderTraversalRecursive(node.right);
    }
}
