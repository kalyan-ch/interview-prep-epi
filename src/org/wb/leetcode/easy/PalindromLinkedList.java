package org.wb.leetcode.easy;

import org.wb.epi.Chap7LinkedLists.LinkedListBasic;
import org.wb.epi.Chap7LinkedLists.ListNode;

public class PalindromLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(2);
        LinkedListBasic linkedListBasic = new LinkedListBasic();
        linkedListBasic.insertNewNode(1, head);
        for (int i = 0; i < 3; i++){
            linkedListBasic.insertNewNode(i, head);
        }

        linkedListBasic.printLinkedList(head);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }

        ListNode s = head, f = head.next;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        int length = 0;
        ListNode<Integer> pointer = head;
        while(pointer != null){
            length++;
            pointer = pointer.next;
        }

        ListNode node = head, firstHalf = s, lastHalf = s.next, endNode = lastHalf;
        int[] counter = new int[10];

        if(length % 2 != 0){
            endNode = firstHalf;
        }

        while(node != endNode){
            counter[(int)node.data]++;
            node = node.next;
        }

        while(lastHalf != null){
            counter[(int)lastHalf.data]--;
            lastHalf = lastHalf.next;
        }

        for(int i : counter){
            if(i > 0)
                return false;
        }

        return true;
    }
}
