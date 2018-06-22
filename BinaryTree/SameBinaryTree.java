package BinaryTree;

public class SameBinaryTree {

    public static void main(String args[]){

        //Same Tree as Input
        Node rootNodeFirst = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        Node rootNodeSecond = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        System.out.println(checkIfSameBinaryTree(rootNodeFirst,rootNodeSecond));

        //Structurally same but with slight changes in data.
        rootNodeFirst = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        rootNodeSecond = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST_ISOMORPH);
        System.out.println(checkIfSameBinaryTree(rootNodeFirst,rootNodeSecond));

    }
    /**
     * The logic for checking if both the Trees are same is:
     *  1. If both the nodes are NULL then, they both would be leaf nodes. Return TRUE
     *  2. If one of the nodes is NULL then, one is leaf node and other is not. Return FALSE
     *  3. If both the nodes are equal then,
     *      3.1 Check left sub-tree of both the nodes is same
     *      3.2 If the left sub-tree is same then, we check for right sub-tree
     *  4. In all other cases we return FALSE;
     * */
    public static boolean checkIfSameBinaryTree(Node nodeFirst,Node nodeSecond){

        if(nodeFirst==null && nodeSecond==null){
            return true;
        }else if(nodeFirst==null || nodeSecond==null){
            return false;
        }else if(nodeFirst.data==nodeSecond.data){
            return checkIfSameBinaryTree(nodeFirst.left,nodeSecond.left) && checkIfSameBinaryTree(nodeFirst.right,nodeSecond.right);
        }
        return false;
    }
}
