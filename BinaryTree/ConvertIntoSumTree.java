package BinaryTree;

public class ConvertIntoSumTree {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        convertIntoSumTree(root);
        System.out.println("---------------SUM TREE --------------");
        BinaryTreeHelper.prettyPrintTree(root);
    }

    private static int convertIntoSumTree(Node node) {

        if(node == null){
            return 0;
        }
        int currentNodeValue = node.data;
        node.data = convertIntoSumTree(node.left)+convertIntoSumTree(node.right);
        return currentNodeValue + node.data;
    }
}
