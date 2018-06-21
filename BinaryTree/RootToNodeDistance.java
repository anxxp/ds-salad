package BinaryTree;

public class RootToNodeDistance {

    public static void main(String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(1);
        int num = 55;

        System.out.println(rootToNodeDistance(root,num));
    }

    public static int rootToNodeDistance(Node root,int num){
        return levelOfNode(root,num)-1;
    }
    public static int levelOfNode(Node node,int num){
        if(node == null){
            return 0;
        }
        if(node.data == num){
            return 1;
        }

        int leftDistance = 0;
        int rightDistance = 0;
        leftDistance = levelOfNode(node.left,num);
        if(leftDistance==0){
            rightDistance = levelOfNode(node.right,num);
        }

        if(leftDistance > 0 || rightDistance > 0){
            return leftDistance + rightDistance + 1;
        }

        return 0;
    }
}
