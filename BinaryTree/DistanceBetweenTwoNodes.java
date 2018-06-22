package BinaryTree;

public class DistanceBetweenTwoNodes {

    public static void main(String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        int firstNum  =  25;
        int secondNum = 55;

        System.out.println(distanceBetweenNodes(root,firstNum,secondNum));

    }
    public static int distanceBetweenNodes(Node node,int firstNum, int secondNum) {

        Node lca = LowestCommonAncestor.lowestCommonAncestor(node,firstNum,secondNum);
        int heightFirstNum = RootToNodeDistance.rootToNodeDistance(lca,firstNum);
        int heightSecondNum = RootToNodeDistance.rootToNodeDistance(lca,secondNum);
        return heightFirstNum + heightSecondNum;
    }

}
