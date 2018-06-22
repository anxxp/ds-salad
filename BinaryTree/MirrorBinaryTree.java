package BinaryTree;

public class MirrorBinaryTree {

    public static void main(String args[]){

        Node rootFirst = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        Node rootSecond = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST_MIRROR);

        System.out.println(checkIfMirrorBinaryTree(rootFirst,rootSecond));

    }
    /**
     * If both the nodes are NULL or same, it means they are mirror.
     * The code will look same as the one for Same Binary Tree.
     * The difference between both the code is the argument which we pass to
     * the function. In case of Mirror we pass the Left Child of one and Right Child
     * of other.
     * */
    public static boolean checkIfMirrorBinaryTree(Node firstNode,Node secondNode ){

        if(firstNode == null && secondNode == null){

            return true;

        }else if(firstNode == null || secondNode == null){

            return false;

        }else if(firstNode.data == secondNode.data){

            return checkIfMirrorBinaryTree(firstNode.left,secondNode.right) &&
                    checkIfMirrorBinaryTree(firstNode.right,secondNode.left);
        }

        return false;
    }
}
