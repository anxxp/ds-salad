package LinkedList;

import java.util.LinkedList;

public class InsertionSortForLinkedList {

    public static void main (String args[]){
        int[] input = {10,2,50,80,40,30,25,100};
        SLLNode head = createSortedLinkedList(input);

        while(head!=null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static SLLNode createSortedLinkedList(int[] input) {
        SLLNode head = null;

        for(int data : input){
            SLLNode node = new SLLNode(data);
            if(head == null){
                head = node;
                continue;
            }

            SLLNode pointer = head;
            SLLNode previous = null;
            while(pointer!=null){

                if(pointer.data<node.data){
                    previous = pointer;
                    pointer = pointer.next;
                }else{
                    break;
                }
            }

            if(previous == null){
                node.next = previous;
                head = node;
            }else{
                node.next = previous.next;
                previous.next = node;
            }
        }

        return head;
    }


}
