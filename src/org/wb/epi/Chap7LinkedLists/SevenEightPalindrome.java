package org.wb.epi.Chap7LinkedLists;

public class SevenEightPalindrome {

    //check if a linkedList is Palindrome
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(5);
        LinkedListBasic<Integer> linkedListBasic = new LinkedListBasic<>();
        linkedListBasic.insertNewNode(2, head);
        linkedListBasic.insertNewNode(1, head);
        linkedListBasic.insertNewNode(2, head);
        linkedListBasic.insertNewNode(5, head);

        System.out.println(isPalindrome(head));

    }

    private static boolean isPalindrome(ListNode<Integer> head) {

        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(" "+slow.data);

        return true;
    }

}
