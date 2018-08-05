package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHelper {

    public static Node createInputBinaryTree(TreeType type){
        Node root;

        switch(type){
            case EMPTY_TREE:
                root = new Node(40);
                break;
            case STANDARD_BST:
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
            case RIGHT_SKEWED_BST:
                root = new Node(40);
                root.right = new Node(50);
                root.right.right = new Node(55);
                root.right.right.right = new Node(75);
                break;
            case STANDARD_BST_ISOMORPH:
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
            case STANDARD_BST_MIRROR:
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
            case BINARY_TREE:
                /**
                 * Not a Binary Search Tree
                 * */
                root = new Node(40);
                root.left = new Node(25);
                root.left.right = new Node(30);
                root.left.left = new Node(15);
                root.right = new Node(50);
                root.right.left = new Node(45);
                root.right.right = new Node(10);
                root.right.right.right = new Node(75);
                root.right.right.right.right = new Node(100);
                break;
            case STANDARD_BST_TWO_NODES_SWAPPED:
                root = new Node(40);
                root.left = new Node(50);
                root.left.right = new Node(30);
                root.left.left = new Node(15);
                root.right = new Node(20);
                root.right.left = new Node(45);
                root.right.right = new Node(55);
                root.right.right.right = new Node(75);
                root.right.right.right.right = new Node(100);
                break;
            case STANDARD_BST_TWO_ADJ_NODES_SWAPPED:
                root = new Node(40);
                root.left = new Node(25);
                root.left.right = new Node(30);
                root.left.left = new Node(15);
                root.right = new Node(50);
                root.right.left = new Node(45);
                root.right.right = new Node(75);
                root.right.right.right = new Node(55);
                root.right.right.right.right = new Node(100);
                break;
            default:
                root = null;
        }

        return root;

    }

    public static void prettyPrintTree(Node root) {
        if (root == null) {
            return;
        }

        int[] size = new int[1];
        size[0] = 0;
        int height = height(root, size) - 1;
        int total = 2 * (int) Math.pow(2, height) - 1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        for (int i = 0; i <= height; i++) {
            int front = (int) (Math.pow(2, (height - i))) - 1;
            int num = (int) (Math.pow(2, i));
            int interval = num > 1 ? (total - front * 2 - num) / (num - 1) : 0;

            for (int j = 0; j < num; j++) {
                Node peek = queue.poll();

                if (j == 0) {
                    print(front, size, peek);
                } else {
                    print(interval, size, peek);
                }

                if (peek == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(peek.left);
                    queue.offer(peek.right);
                }
            }

            System.out.println();
        }
    }

    public static int height(Node root, int[] size) {
        if (root == null) {
            return 0;
        }

        size[0] = Math.max(size[0], Integer.toString(root.data).length());
        return Math.max(height(root.left, size), height(root.right, size)) + 1;
    }

    public static void print(int count, int[] size, Node root) {
        for (int i = 0; i < count * size[0]; i++) {
            System.out.print(" ");
        }

        if (root != null) {
            for (int j = 0; j < size[0] - Integer.toString(root.data).length(); j++) {
                System.out.print(" ");
            }

            System.out.print(root.data);
        } else {
            for (int j = 0; j < size[0]; j++) {
                System.out.print(" ");
            }
        }
    }
}
