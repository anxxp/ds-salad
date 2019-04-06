package BinaryTree;

public class ConvertNodeToSumOfLeftSubTree {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        convertNodeToSumOfLeftSubTree(root);
        BinaryTreeHelper.prettyPrintTree(root);

    }

    private static int convertNodeToSumOfLeftSubTree(Node node) {

        if(node==null){
            return 0;
        }
        int temp;
        if(node.left==null && node.right==null){
            temp = node.data;
            node.data=0;
            return temp;
        }
        int leftSubTreeSum = convertNodeToSumOfLeftSubTree(node.left);
        int rightSubTreeSum = convertNodeToSumOfLeftSubTree(node.right);

        temp = node.data;
        node.data = leftSubTreeSum;
        return leftSubTreeSum+rightSubTreeSum+temp;
    }
}
