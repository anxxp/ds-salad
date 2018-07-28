package LinkedList;
/**
 * 1.PREV        CURRENT     NEXT
 * 2.            PREV        CURRENT     NEXT
*  3.                        PREV        CURRENT     NEXT
 * 4.                                    PREV        CURRENT    NEXT
 * 5.                                                PREV        CURRENT    NEXT
 *   HEADER------> 1 -------> 2 --------> 3 -------> 4 --------> NULL
 *
 * We start with
 *      PREV    = NULL
 *      CURRENT = HEADER
 *      NEXT    = CURRENT.NEXT
 *
 * Then, in each iteration we reverse the link.
 *
 * Finally we PREVIOUS NODE as the HEADER as it refers the
 * last node in the initial linked list
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
