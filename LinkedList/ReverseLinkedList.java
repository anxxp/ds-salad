package LinkedList;
/**
 *
 * */
public class ReverseLinkedList {
    public static void main(String args[]){
        SLLNode header = LinkedListHelper.createSinglyLinkedList(LinkedListType.RANDOM_EVEN_LENGTH);
        LinkedListHelper.printLinkedList("INPUT",header);
        header = reverseLinkedList(header);
        LinkedListHelper.printLinkedList("OUTPUT",header);
    }

    private static SLLNode reverseLinkedList(SLLNode header) {

        SLLNode current = header;
        SLLNode previous = null;
        SLLNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        }
        header = previous;
        return header;
    }

}
