package org.wb.leetcode.easy;

import org.wb.epi.Chap7LinkedLists.LinkedListBasic;
import org.wb.epi.Chap7LinkedLists.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>();
        LinkedListBasic linkedListBasic = new LinkedListBasic();
        ListNode<Integer> node = null;
        for (int i = 0; i < 6; i++){
            linkedListBasic.insertNewNode(i, head);
        }

        linkedListBasic.printLinkedList(head);
        System.out.println(linkedListBasic.lengthOfAList(head));
        ListNode middle = middleNode(head);
        System.out.println(middle);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
