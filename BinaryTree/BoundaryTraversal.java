package BinaryTree;


public class BoundaryTraversal {

    public static void main(String args[]){
        Node root = BinaryTreeHelper.createInputBinaryTree(TreeType.STANDARD_BST);
        BinaryTreeHelper.prettyPrintTree(root);
        System.out.println();
        boundaryTraversal(root);
    }

    private static void boundaryTraversal(Node root) {

        if(root == null){
            return;
        }
        printLeftBoundaryIterative(root);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    private static void printLeftBoundary(Node node) {
        if(node==null){
            return;
        }

        if(node.left != null){
            System.out.print(node.data+" ");
            printLeftBoundary(node.left);
        }else if(node.right !=null){
            System.out.print(node.data+" ");
            printLeftBoundary(node.right);
        }
    }

    private static void printLeftBoundaryIterative(Node node) {

        if(node==null){
            return;
        }

        while(node.left != null || node.right !=null){

            System.out.print(node.data+" ");
            if(node.left != null){
                node = node.left;
            }else if(node.right !=null){
               node = node.right;
            }
        }

    }

    private static void printLeaves(Node node) {

        if(node== null){
            return;
        }

        if(node.left==null && node.right == null){
            System.out.print(node.data+" ");
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }

    private static void printRightBoundary(Node node) {
        if(node == null){
            return;
        }

        if(node.right !=null){
            printRightBoundary(node.right);
        }else if(node.left !=null){
            printRightBoundary(node.left);
        }else{
            return;
        }
        System.out.print(node.data+" ");
    }

    private static void printRightBoundaryIterative(Node node) {
        if(node==null){
            return;
        }

        while(node.left != null || node.right !=null){

            System.out.print(node.data+" ");
            if(node.right !=null){
                node = node.right;
            }else if(node.left != null){
                node = node.left;
            }
        }

    }
}
