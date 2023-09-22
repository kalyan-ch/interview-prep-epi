package org.wb.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public void printList() {
        ListNode node = this;

        while(node != null) {
            System.out.print(node.val+" -> ");
            node = node.next;
        }

        System.out.println();
    }
}
