package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * In LowestCommonAncestor.java , we had a problem.
 * We did not consider the case when one of the element is not present in the Tree.
 * In this class I , have taken two boolean variables to track if we found the element in
 * the tree.But, since we stop traversing the child sub-tree when we encounter one of the
 * nodes we are searching LCA of.
 *
 * I solve this special case when we found one of the nodes and assumed that the other node
 * is in the sub-tree below.I traverse the sub-tree looking for the other node in such cases.
 * */
public class LowestCommonAncestorFoolProof {

    public static boolean hasFirstNum;
    public static boolean hasSecNum;

    public static void main(String a[]){


        hasFirstNum = false;
        hasSecNum = false;

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);

        int firstNum = 50;
        int secondNum =100;

        Node lcaNode = lowestCommonAncestor(root,firstNum,secondNum);

        if (lcaNode != null && hasFirstNum && hasSecNum ){

            System.out.println("LCA is : "+lcaNode.data);

        }else if(hasFirstNum){

            if(checkIfPresent(lcaNode,secondNum)){
                System.out.println("LCA is : "+lcaNode.data);
            }

        }else if(hasSecNum){

            if(checkIfPresent(lcaNode,firstNum)){
                System.out.println("LCA is : "+lcaNode.data);
            }

        }else{
            System.out.println("Numbers are not present in the Tree");
        }

    }

    public static Node lowestCommonAncestor(Node node,int firstNum,int secondNum){

        if(node==null){
            return null;
        }

        if(node.data==firstNum){
            hasFirstNum = true;
            return node;
        }
        if(node.data ==secondNum){
            hasSecNum = true;
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

    public static boolean checkIfPresent(Node node,int num){
        if(node == null){
            return false;
        }
        if(node.data == num){
            return true;
        }
        return checkIfPresent(node.left,num) || checkIfPresent(node.right,num);
    }
}
