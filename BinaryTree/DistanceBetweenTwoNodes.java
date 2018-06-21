package BinaryTree;

public class DistanceBetweenTwoNodes {

    static boolean hasFirstNode = false;
    static boolean hasSecondNode = false;
    public static void main(String args[]){

        Node root = BinaryTreeCreator.createInputBinaryTree(1);
        int firstNum  =  15;
        int secondNum = 50;

        System.out.println(distanceBetweenNodes1(root,firstNum,secondNum));

    }
    public static int distanceBetweenNodes1(Node node,int firstNum, int secondNum) {

        if (node == null) {
            return 0;
        }

        int leftDistance = distanceBetweenNodes(node.left, firstNum, secondNum);
        int rightDistance = distanceBetweenNodes(node.right, firstNum, secondNum);

        if(node.data == firstNum){
            hasFirstNode =true;
        }
        if(node.data == secondNum){
            hasSecondNode = true;
        }
        if(hasFirstNode && hasSecondNode){
            return leftDistance+rightDistance;
        }else if(leftDistance+rightDistance > 0){
            return leftDistance+rightDistance+1;
        }

        return leftDistance + rightDistance;

    }

    public static int distanceBetweenNodes(Node node,int firstNum, int secondNum) {

        if (node == null) {
            return 0;
        }

        int leftDistance = distanceBetweenNodes(node.left, firstNum, secondNum);
        int rightDistance = distanceBetweenNodes(node.right, firstNum, secondNum);

        if (leftDistance > 0 && rightDistance > 0) {
            return leftDistance + rightDistance - 1;
        } else if (leftDistance > 0 || rightDistance > 0) {
            if (node.data == firstNum || node.data == secondNum) {
                return leftDistance + rightDistance ;
            } else {
                return leftDistance + rightDistance + 1;
            }
        } else if (node.data == firstNum || node.data == secondNum) {
            return 1;
        }
        return leftDistance + rightDistance;

    }


}
