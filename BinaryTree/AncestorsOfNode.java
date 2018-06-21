package BinaryTree;

public class AncestorsOfNode {

    public static void main(String args[]){
        //Input data
        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        int num = 40;

        /**
        * If the given number is in the Root node then there is no need to process this
        * input.The Root node will not have any ancestors.
        *
        * Otherwise , we process the input and try to find if its present in the Tree.
        * When its found in the Tree then we return TRUE.So if the parent method call returns
        * FALSE, it means the given number is not present in the Tree.
        */

        if(root!= null && root.data ==num ){

            System.out.println("The given num is in the Root node,hence has no ancestors");

        }else{

            if(!ancestorsOfNode(root,num)){
                System.out.println("The given node is not present in the Tree");
            }
        }
    }

    public static boolean ancestorsOfNode(Node node,int num){

        if(node==null){
            return false;
        }

        if(node.data == num){
            return true;
        }

        /**
         * This is an interesting construct.
         * We have used an OR condition of the method call for LEFT and RIGHT sub-tree.
         * This helps us to code the scenario when you want to probe the RIGHT sub-tree only if the
         * LEFT sub-tree failed in its probe.
         * */
        if(ancestorsOfNode(node.left,num)|| ancestorsOfNode(node.right,num)){

            System.out.print("->"+node.data);
            return true;
        }

        return false;

    }
}
