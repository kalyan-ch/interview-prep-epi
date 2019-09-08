package org.wb.epi.Chap7LinkedLists;

public class SevenOneMergeTwoSortedLists {

    //merge two sorted linked lists
    public static void main(String[] args) {
        LinkedListBasic linkedListBasic = new LinkedListBasic();
        ListNode<Integer> head1 = new ListNode<>(1);
        for(int i = 2; i <= 10; i += 2){
            linkedListBasic.insertNewNode(i, head1);
        }

        ListNode<Integer> head2 = new ListNode<>(2);
        for(int i = 3; i <= 10; i += 2){
            linkedListBasic.insertNewNode(i, head2);
        }


        linkedListBasic.printLinkedList(head1);
        linkedListBasic.printLinkedList(head2);
        linkedListBasic.printLinkedList(mergeLinkedLists(head1, head2));
        //linkedListBasic.lengthOfAList(mergeLinkedLists(head1, head2));

        //mergeLinkedLists(head1, head2);

    }

    private static ListNode<Integer> mergeLinkedLists(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> mergedHead = new ListNode<>();
        ListNode<Integer> l1 = head1, l2 = head2, l3 =  mergedHead;

        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        l3.next = (l1 == null) ? l2: l1;

        return mergedHead.next;
    }

}
