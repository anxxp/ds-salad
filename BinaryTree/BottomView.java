package BinaryTree;


import LinkedList.DLLNode;

public class BottomView {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println("-------------------------");
        DLLNode head = new DLLNode();
        bottomView(root,head);

        while (head.prev!=null){
            head = head.prev;
        }

        while (head !=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static void bottomView(Node node,DLLNode associatedDLLNode){

        if(node == null){
            return;
        }

        associatedDLLNode.data=node.data;
        if(node.left!=null){
            if(associatedDLLNode.prev==null){
                associatedDLLNode.prev = new DLLNode();
                associatedDLLNode.prev.next = associatedDLLNode;
            }
            bottomView(node.left,associatedDLLNode.prev);
        }

        if(node.right!=null){
            if(associatedDLLNode.next==null){
                associatedDLLNode.next = new DLLNode();
                associatedDLLNode.next.prev = associatedDLLNode;
            }
            bottomView(node.right,associatedDLLNode.next);
        }
    }
}
