package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.leetcode.util.ListNode;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);

        createList(3, 8, list1);
        createList(4, 8, list2);

        ListNode mergedList = mergeTwoLists(list1, list2);
        mergedList.printList();
    }

    private static void createList(int start, int end, ListNode list) {
        ListNode node = list;
        for(int i = start; i < end; i += 2){
            node.next = new ListNode(i);
            node = node.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode node = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
