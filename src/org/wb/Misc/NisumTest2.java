package org.wb.Misc;

import java.util.PriorityQueue;

public class NisumTest2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        int[][] lists = {{1,4,5},{1,3,4},{2,6}};

        ListNode node = mergeLists(lists);
        while(node != null){
            if(node.next != null)
                System.out.print(node.val+" -> ");
            else
                System.out.println(node.val);

            node = node.next;
        }
        System.out.println();
    }

    private static ListNode mergeLists(int[][] lists){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] list: lists){
            for(int n: list){
                pq.add(n);
            }
        }

        ListNode head = new ListNode(pq.poll());
        ListNode node = head;

        while(!pq.isEmpty()){
            int num = pq.poll();
            node.next = new ListNode(num);
            node = node.next;
        }

        return head;
    }
}
