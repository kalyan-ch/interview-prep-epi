package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.epi.Chap7LinkedLists.SevenTwoReverseASingleSublist;
import org.wb.leetcode.util.ListNode;

import java.util.Random;
import java.util.Stack;

public class MaxTwinSumLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(12324);
        createList( 10, list1);

        list1.printList();
        System.out.println(pairSum(list1));
    }

    private static void createList(int end, ListNode list) {
        ListNode node = list;
        Random rm = new Random();
        for(int i = 0; i <= end; i++){
            node.next = new ListNode(rm.nextInt(100000));
            node = node.next;
        }
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        int length = 0;

        while(slow != null) {
            slow = slow.next;
            length++;
        }

        ListNode firstHalf = head;
        reverseSubList(head, length / 2 + 1, length);
        head.printList();

        slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxSum = 0;

        ListNode secondHalf = slow;
        while(secondHalf != null){
            maxSum = Math.max(firstHalf.val + secondHalf.val, maxSum);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }

    private static void reverseSubList(ListNode head, int start, int finish) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int i = 1;
        // get the node just before start
        while(i++ < start){
            dummyHead = dummyHead.next;
        }

        ListNode curr = dummyHead.next;

        // throughout the loop curr is going to remain the same
        // all the change are the links between temp and  dummyHead
        while(start++ < finish){
            ListNode temp = curr.next; // save next node in temp
            curr.next = temp.next; // link curr to temp's next node
            temp.next = dummyHead.next; // link temp's next to curr's predecessor node
            dummyHead.next = temp; // make temp as start of reversed list
        }

    }


}
