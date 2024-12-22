package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.leetcode.util.ListNode;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        createList(2, 10, list1);

        ListNode head = oddEvenList(list1);
        head.printList();
    }

    private static void createList(int start, int end, ListNode list) {
        ListNode node = list;
        for(int i = start; i < end; i ++){
            node.next = new ListNode(i);
            node = node.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;

        ListNode odd= head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
