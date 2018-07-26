package LinkedList;

public class ReverseLinkedList {
    public static void main(String args[]){
        SLLNode header = LinkedListHelper.createSinglyLinkedList(LinkedListType.RANDOM_EVEN_LENGTH);
        System.out.println("INPUT");
        LinkedListHelper.printLinkedList(header);
        reverseLinkedList(header);
    }

    private static void reverseLinkedList(SLLNode node) {
        //TODO
    }

}
