package BinaryTree;

public class BuildTreeFromInOrderAndPreOrder {

    public Node makeBTree(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd) {
            return null;
        }
        Node root = new Node(preOrder[pStart]);

        if (iStart == iEnd) {
            return root;
        }
        int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
        root.left = makeBTree(
                inOrder,
                preOrder,
                iStart,
                index - 1,
                pStart + 1,
                pStart + (index - iStart)

        );
        root.right = makeBTree(
                inOrder,
                preOrder,
                index + 1,
                iEnd,
                pEnd - (iEnd - index) + 1,
                pEnd);

        return root;
    }

    public int getInorderIndex(int[] inOrder, int start, int end, int data) {
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public void printINORDER(Node root) {
        if (root != null) {
            printINORDER(root.left);
            System.out.print("  " + root.data);
            printINORDER(root.right);
        }
    }

    public static void main(String[] args) {
        int[] inOrder = {2, 5, 6, 7, 10, 12, 14, 15};
        int[] preOrder = {10, 5, 2, 6, 7, 14, 12, 15};
        BuildTreeFromInOrderAndPreOrder i = new BuildTreeFromInOrderAndPreOrder();
        Node x = i.makeBTree(
                inOrder,
                preOrder,
                0,
                inOrder.length - 1,
                0,
                preOrder.length - 1);
        System.out.println("Constructed Tree : ");
        i.printINORDER(x);
    }
}

