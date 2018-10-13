package BinaryTree;
import LinkedList.DLLNode;


public class TopView {

    public static void main (String args[]){

        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.BINARY_TREE);
        BinaryTreeHelper.prettyPrintTree(root);
        DLLNode topViewNode = new DLLNode(root.data);
        topView(root,topViewNode);

        while(topViewNode.prev!=null){
            topViewNode = topViewNode.prev;
        }

        while(topViewNode!=null){
            System.out.println(topViewNode.data);
            topViewNode = topViewNode.next;
        }

    }

    private static void topView(Node root, DLLNode topViewNode) {

        DLLNode node;
        if (root.left != null) {
            node = topViewNode.prev;
            if (node==null){
                topViewNode.prev = new DLLNode(root.left.data);
                topViewNode.prev.next = topViewNode;
            }
            topView(root.left,topViewNode.prev);
        }

        if (root.right != null) {
            node = topViewNode.next;
            if (node==null){
                topViewNode.next = new DLLNode(root.right.data);
                topViewNode.next.prev = topViewNode;
            }
            topView(root.right,topViewNode.next);
        }
    }
}
