package LinkedList;

public class LinkedListHelper {

    public static SLLNode createSinglyLinkedList(LinkedListType type) {
        SLLNode head=null;

        switch (type) {
            case RANDOM_EVEN_LENGTH:
                head = new SLLNode();
                head.data =10;
                head.next = new SLLNode();
                head.next.data = 5;
                head.next.next = new SLLNode();
                head.next.next.data = 42;
                head.next.next.next = new SLLNode();
                head.next.next.next.data = 25;
                break;
            case RANDOM_ODD_LENGTH:
                head = new SLLNode();
                head.data =10;
                head.next = new SLLNode();
                head.next.data = 5;
                head.next.next = new SLLNode();
                head.next.next.data = 42;
                head.next.next.next = new SLLNode();
                head.next.next.next.data = 25;
                head.next.next.next.next = new SLLNode();
                head.next.next.next.next.data = 15;
                break;
        }
        return head;
    }

    public static void printLinkedList(String prefix ,SLLNode header){
        System.out.println("\n"+prefix);
        SLLNode temp = header;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void printLinkedList(String prefix ,DLLNode header){
        System.out.println("\n"+prefix);
        DLLNode temp = header;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
