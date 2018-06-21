package BinaryTree;

public class HeightOfBinaryTree {
    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        System.out.println(heightOfBinaryTree(root));

    }

    public static int heightOfBinaryTree(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        return Math.max(leftHeight,rightHeight)+1;
    }


}
