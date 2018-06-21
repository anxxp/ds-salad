package BinaryTree;

public class DistanceBetweenTwoNodes {

    static boolean hasFirstNode = false;
    static boolean hasSecondNode = false;
    public static void main(String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        int firstNum  =  15;
        int secondNum = 45;

        System.out.println(distanceBetweenNodes(root,firstNum,secondNum));

    }
    public static int distanceBetweenNodes(Node node,int firstNum, int secondNum) {

        if (node == null) {
            return 0;
        }

        int leftDistance = distanceBetweenNodes(node.left, firstNum, secondNum);
        int rightDistance = distanceBetweenNodes(node.right, firstNum, secondNum);

        if(node.data == firstNum){
            hasFirstNode =true;
            if(leftDistance+rightDistance>0){
                return leftDistance+rightDistance;
            }else{
                return 1;
            }
        }
        if(node.data == secondNum){
            hasSecondNode = true;
            if(leftDistance+rightDistance>0){
                return leftDistance+rightDistance;
            }else{
                return 1;
            }
        }
        if(hasFirstNode && hasSecondNode){
            return leftDistance+rightDistance;
        }else if(leftDistance+rightDistance > 0){
            return leftDistance+rightDistance+1;
        }

        return leftDistance + rightDistance;

    }

}
