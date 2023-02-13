package org.wb.leetcode.medium;

import org.wb.leetcode.util.ListNode;

public class Prob24SwapPairsOfNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode dummy = head.next;

        while (head != null && head.next != null) {
            if (prev != null) {
                prev.next = head.next;  // Step 4
            }
            prev = head;                // Step 3

            // Step 2
            ListNode nextNode = head.next.next;
            head.next.next = head;      // Step 1

            head.next = nextNode;       // Step 6
            head = nextNode;            // Move onto next pair
        }


        return head;
    }
}
