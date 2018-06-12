package BinaryTree;

public class LowestCommonAncestor {

    public static void main(String a[]){
        Node root = BinaryTreeCreator.createInputBinaryTree(1);
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
