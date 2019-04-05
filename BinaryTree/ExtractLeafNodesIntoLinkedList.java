package BinaryTree;

public class ExtractLeafNodesIntoLinkedList {

    private static Node head;
    private static Node tail;


    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        helper(root);
        Node temp =head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.right;
        }
        BinaryTreeHelper.prettyPrintTree(root);
    }

    private static boolean helper(Node node) {
        if(node==null){
            return false;
        }

        if(node.left==null && node.right==null){

            if(head==null && tail==null){
                head=node;
                tail=node;
            }else{
                tail.right = node;
                node.left = tail;
                tail=node;
            }

            return true;
        }

        if(helper(node.left)){
            node.left=null;
        }
        if(helper(node.right)){
            node.right=null;
        }
        return false;
    }
}
