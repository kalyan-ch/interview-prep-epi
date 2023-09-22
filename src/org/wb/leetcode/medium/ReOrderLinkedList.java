package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;
import org.wb.leetcode.util.ListNode;

public class ReOrderLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i < 8; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        head.printList();
        reorderList(head);
        head.printList();
    }

    public static void reorderList(ListNode head) {
        ListNode fast = head, mid = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode prev = null;
        ListNode curr = mid.next;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode node = head;
        mid.next = null;

        while(node != null && prev != null) {
            ListNode temp = node.next;
            ListNode temp2 = prev.next;
            prev.next = null;
            node.next = prev;
            prev.next = temp;
            node = temp;
            prev = temp2;
        }

    }
}
