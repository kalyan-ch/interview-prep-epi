package org.wb.epi.Chap7LinkedLists;

public class SevenTwoReverseASingleSublist {

    //reverse a part of a linkedList
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(5);
        LinkedListBasic<Integer> linkedListBasic = new LinkedListBasic<>();
        for (int i = 10; i < 50; i+=5){
            linkedListBasic.insertNewNode(i, head);
        }

        /*linkedListBasic.printLinkedList(head);
        reverseSubList(head, 2, 6);
        linkedListBasic.printLinkedList(head);*/

        linkedListBasic.printLinkedList(head);
        ListNode<Integer> newHead = reverseLinkedList(head);
        linkedListBasic.printLinkedList(newHead);

    }

    private static void reverseSubList(ListNode<Integer> head, int start, int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        dummyHead.next = head;
        int i = 1;
        while(i++ < start){
            dummyHead = dummyHead.next;
        }

        ListNode<Integer> lIter = dummyHead.next;

        System.out.println(dummyHead.data+" "+lIter.data);

        while(start++ < finish){
            ListNode<Integer> temp = lIter.next;
            lIter.next = temp.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }

    }

    private static ListNode<Integer> reverseLinkedList(ListNode<Integer> head){
        ListNode<Integer> dummyHead = new ListNode<>(0);
        dummyHead.next = head;
        ListNode<Integer> iter = head;
        int start = 0, finish = 0;
        // determine the length of the list
        while(iter.next != null){
            finish++;
            iter = iter.next;
        }

        ListNode<Integer> listIter = dummyHead.next;

        // take two pointers listIter and temp and
        // reverse the links between nodes until you reach the end of the list
        while(start++ < finish){
            ListNode<Integer> temp = listIter.next;
            listIter.next = temp.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }

        return dummyHead.next;
    }
}
