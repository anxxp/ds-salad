package BinaryTree;

/**
 * NOTE : This program works with the assumption that both the nodes are present in the Tree.
 *
 * We follow the following approach:
 *  1. When ever we encounter a node with data same as on of the given node,
 *      we return the current Node.
 *  2. If we get a NOT NULL value from both left and right sub-tree,
 *      we return the current Node.
 *  3. If we get NOT NULL from one sub-tree and NULL from other sub-tree then,
 *      we return the NOT NULL node received.
 *  4. Else , in all other cases we return NULL.
 * */
public class LowestCommonAncestor {

    public static void main(String a[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println("\n");
        System.out.println(lowestCommonAncestor(root,45,100).data);

    }

    public static Node lowestCommonAncestor(Node node,int firstNum,int secondNum){

        if(node==null){
            return null;
        }

        if(node.data==firstNum || node.data ==secondNum){
            return node;
        }

        Node fromLeft = lowestCommonAncestor(node.left,firstNum,secondNum);
        Node fromRight = lowestCommonAncestor(node.right,firstNum,secondNum);

        if(fromLeft==null && fromRight== null){
            return null;
        }
        if(fromLeft!=null && fromRight!=null){
            return node;
        }

        return fromLeft!=null?fromLeft:fromRight;
    }
}
