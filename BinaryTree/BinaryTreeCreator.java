package BinaryTree;

public class BinaryTreeCreator {


    public static Node createInputBinaryTree(int type){
        Node root;

        switch(type){
            case 0:
                root = new Node(40);
                break;
            case 1:
                root = new Node(40);
                root.left = new Node(25);
                root.left.right = new Node(30);
                root.left.left = new Node(15);
                root.right = new Node(50);
                root.right.left = new Node(45);
                root.right.right = new Node(55);
                root.right.right.right = new Node(75);
                root.right.right.right.right = new Node(100);
                break;
            case 2:
                root = new Node(40);
                root.right = new Node(50);
                root.right.right = new Node(55);
                root.right.right.right = new Node(75);
                break;
            case 3:
                /**
                 * Similar structure to CASE 1 , but some values are different.
                 */
                root = new Node(40);
                root.left = new Node(25);
                root.left.right = new Node(30);
                root.left.left = new Node(15);
                root.right = new Node(50);
                root.right.left = new Node(45);
                root.right.right = new Node(58);
                root.right.right.right = new Node(75);
                root.right.right.right.right = new Node(101);
                break;
            case 4:
                /**
                 * Mirror tree of the CASE 1
                 * */
                root = new Node(40);
                root.right = new Node(25);
                root.right.left = new Node(30);
                root.right.right = new Node(15);
                root.left = new Node(50);
                root.left.right = new Node(45);
                root.left.left = new Node(55);
                root.left.left.left = new Node(75);
                root.left.left.left.left = new Node(100);
                break;
            default:
                root = null;
        }

        return root;

    }
}
