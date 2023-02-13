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
        ListNode<Integer> newHead = reverseLinkedList2(head);
        linkedListBasic.printLinkedList(newHead);
        reverseSubList(newHead, 2, 6);
        linkedListBasic.printLinkedList(newHead);

    }

    private static void reverseSubList(ListNode<Integer> head, int start, int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        dummyHead.next = head;
        int i = 1;
        // get the node just before start
        while(i++ < start){
            dummyHead = dummyHead.next;
        }

        ListNode<Integer> curr = dummyHead.next;

        // throughout the loop curr is going to remain the same
        // all the change are the links between temp and  dummyHead
        while(start++ < finish){
            ListNode<Integer> temp = curr.next; // save next node in temp
            curr.next = temp.next; // link curr to temp's next node
            temp.next = dummyHead.next; // link temp's next to curr's predecessor node
            dummyHead.next = temp; // make temp as start of reversed list
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

    private static ListNode<Integer> reverseLinkedList2(ListNode<Integer> head){
        ListNode<Integer> prev = null; // this is the next location for the first node
        ListNode<Integer> curr = head; // current pointer iterating through each node

        while(curr != null){
            ListNode<Integer> nextNode = curr.next; // save the next node in a temp pointer
            curr.next = prev; // sever the link to next node and point it to previous node
            prev = curr; // move previous to next
            curr = nextNode; // move curr to next
        }

        return prev;
    }
}
