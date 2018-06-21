package BinaryTree;

public class RootToLeafGivenSum {

    public static void main(String args[]){

        //Input
        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        int sum = 135;

        rootToLeafGivenSum(root,sum);
    }

    public static boolean rootToLeafGivenSum(Node node,int sum){
        /**
         * We check if the current node is NULL.If so,then the parent of this node
         * must be a Leaf Node.Now , if the remaining SUM == 0 , then the path to its
         * Parent Node (i-e Leaf Node) is having the given SUM.
         * We return TRUE in such case. And if the SUM != 0 then we return FALSE
         *
         * */
        if(node==null && sum==0){
            return true;
        }else if(node==null){
            return false;
        }

        /**
         * This is an interesting construct.
         * We have used an OR condition of the method call for LEFT and RIGHT sub-tree.
         * This helps us to code the scenario when you want to probe the RIGHT sub-tree only if the
         * LEFT sub-tree failed in its probe.
         * */
        if(rootToLeafGivenSum(node.left,sum-node.data) ||
                rootToLeafGivenSum(node.right,sum-node.data)){
            System.out.print(" <- "+node.data);
            return true;
        }

        return false;
    }
}
