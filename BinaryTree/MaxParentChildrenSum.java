package BinaryTree;

public class MaxParentChildrenSum {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.BINARY_TREE);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println(maxParentChildrenSum(root));
    }

    private static int maxParentChildrenSum(Node node) {

        if(node == null) return 0;
        int maxInRightSubTree = node.right!=null? maxParentChildrenSum(node.right) : Integer.MIN_VALUE;
        int maxInLeftSubTree = node.left !=null? maxParentChildrenSum(node.left) : Integer.MIN_VALUE;
        int sum = node.data;
        if(node.right!=null){
            sum += node.right.data;
        }

        if(node.left!=null){
            sum += node.left.data;
        }
        int max = Math.max(sum,Math.max(maxInLeftSubTree,maxInRightSubTree));
        System.out.println("NODE "+node.data +" LEFT "+ maxInLeftSubTree+"RIGHT "+maxInRightSubTree +" MAX "+max);
        return max;
    }
}
