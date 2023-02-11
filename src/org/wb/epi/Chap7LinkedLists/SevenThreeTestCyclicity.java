package org.wb.epi.Chap7LinkedLists;

public class SevenThreeTestCyclicity {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>();
        LinkedListBasic<Integer> linkedListBasic = new LinkedListBasic<>();
        ListNode<Integer> node = null;
        for (int i = 11; i < 50; i++){
            if(i == 20)
                node = linkedListBasic.insertNewNode(i, head);
            linkedListBasic.insertNewNode(i, head);
        }
        ListNode<Integer> node2 = head;
        while(node2.next != null){
            node2 = node2.next;
        }

        node2.next = node;

        ListNode<Integer> start = hasCycle(head);
        System.out.println(start);
    }

    private static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
