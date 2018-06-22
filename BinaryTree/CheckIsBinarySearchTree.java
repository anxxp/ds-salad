package BinaryTree;

public class CheckIsBinarySearchTree {

    public static void main(String args[]){
        Node rootBST = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        checkIsBinarySearchTree(rootBST);

        Node rootNotBST = BinaryTreeHelper.createInputBinaryTree(TreeType.BINARY_TREE);
        checkIsBinarySearchTree(rootNotBST);
    }

    public static void checkIsBinarySearchTree(Node root){

        System.out.println(
                checkIsBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE)
        );
    }

    public static boolean checkIsBinarySearchTree(Node node,int lowerBound,int upperBound){

            if(node == null){
                return true;
            }

            if(node.data > lowerBound && node.data < upperBound){
                return checkIsBinarySearchTree(node.left,lowerBound,node.data)
                        && checkIsBinarySearchTree(node.right,node.data,upperBound);
            }else{
                return false;
            }
    }
}
