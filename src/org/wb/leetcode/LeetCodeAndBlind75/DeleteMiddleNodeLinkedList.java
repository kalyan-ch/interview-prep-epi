package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.leetcode.util.ListNode;

public class DeleteMiddleNodeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        createList(3, 11, head);
        head.printList();
        deleteMiddle(head);
        head.printList();
    }

    private static ListNode deleteMiddle(ListNode head) {
        int len = getLength(head);
        int i = 0;
        ListNode node = new ListNode(0, head);
        while(i < (len / 2)){
            node = node.next;
            i++;
        }

        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = null;

        return head;
    }

    private static int getLength(ListNode head){
        int len = 0;
        ListNode node = head;

        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }

    private static void createList(int start, int end, ListNode list) {
        ListNode node = list;
        for(int i = start; i < end; i++){
            node.next = new ListNode(i);
            node = node.next;
        }
    }
}
