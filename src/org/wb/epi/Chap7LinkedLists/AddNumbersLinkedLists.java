package org.wb.epi.Chap7LinkedLists;

public class AddNumbersLinkedLists {

    //add two numbers represented as linkedlists
    public static void main(String[] args) {
        LinkedListBasic<Integer> linkedListBasic = new LinkedListBasic<>();

        ListNode<Integer> l1 = new ListNode<>(2);
        linkedListBasic.insertNewNode(4, l1);
        linkedListBasic.insertNewNode(3, l1);

        ListNode<Integer> l2 = new ListNode<>(5);
        linkedListBasic.insertNewNode(6, l2);
        linkedListBasic.insertNewNode(4, l2);

        ListNode<Integer> resultHead = addTwoNumbers(l1, l2);
        linkedListBasic.printLinkedList(resultHead);

    }

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> dummyHead = new ListNode<Integer>(0);
        ListNode<Integer> resultIter = dummyHead;
        int carry = 0, sum = 0;

        while(l1 != null || l2 != null){
            int firstDigit = (l1 == null) ? 0 : l1.data;
            int secondDigit = (l2 == null) ? 0 : l2.data;
            sum = carry + firstDigit + secondDigit;
            carry = (sum >= 10) ? 1: 0;
            sum = sum % 10;

            resultIter.next = new ListNode<Integer>(sum);
            resultIter = resultIter.next;

            l1 = (l1 == null || l1.next == null) ? null : l1.next;
            l2 = (l2 == null || l2.next == null) ? null : l2.next;

        }

        if(carry > 0){
            resultIter.next = new ListNode<>(1);
        }

        return dummyHead.next;
    }


}
