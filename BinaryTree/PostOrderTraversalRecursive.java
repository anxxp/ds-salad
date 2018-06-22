package BinaryTree;

public class PostOrderTraversalRecursive {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);

        postOrderTraversalRecursive(root);
    }

    public static void postOrderTraversalRecursive(Node node){

        if(node == null){
            return;
        }
        postOrderTraversalRecursive(node.left);
        postOrderTraversalRecursive(node.right);
        System.out.print(" "+node.data);
    }
}
