package BinaryTree;

public class FlattenBinaryTreeIntoLinkedList {

    Node prevInOrderNode;
    Node head;

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.BINARY_TREE);
        FlattenBinaryTreeIntoLinkedList flattenBT = new FlattenBinaryTreeIntoLinkedList();
        BinaryTreeHelper.prettyPrintTree(root);
        flattenBT.flattenBTtoLL(root);
        System.out.println("Printing the Doubly linked list");
        Node current = flattenBT.head;
        while(current !=null){
            System.out.println(current.data);
            current = current.right;
        }
    }

    private void flattenBTtoLL(Node node) {

        if(node == null){
            return;
        }

        flattenBTtoLL(node.left);
        if(prevInOrderNode==null){
            head = node;
        }else{
            prevInOrderNode.right = node;
            node.left = prevInOrderNode;
        }
        prevInOrderNode = node;
        flattenBTtoLL(node.right);
    }
}
