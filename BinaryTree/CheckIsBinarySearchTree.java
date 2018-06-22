package BinaryTree;

public class CheckIsBinarySearchTree {

    public static void main(String args[]){
        Node rootBST = BinaryTreeHelper.createInputBinaryTree(1);
        checkIsBinarySearchTree(rootBST);

        Node rootNotBST = BinaryTreeHelper.createInputBinaryTree(5);
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
