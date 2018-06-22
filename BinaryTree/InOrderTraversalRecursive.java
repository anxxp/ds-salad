package BinaryTree;

public class InOrderTraversalRecursive {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        inOrderTravesalRecursive(root);
    }

    public static void inOrderTravesalRecursive(Node node){

        if(node == null){
            return;
        }

        inOrderTravesalRecursive(node.left);
        System.out.print(" "+node.data);
        inOrderTravesalRecursive(node.right);
    }
}
