package org.wb.epi.Chap7LinkedLists;

public class LinkedListBasic<T> {

    public ListNode<T> insertNewNode(T data, ListNode<T> head){
        ListNode<T> node = head;
        while(node.next != null){
            node = node.next;
        }
        ListNode<T> newNode= new ListNode<T>(data);
        node.next = newNode;

        return newNode;
    }

    public void deleteNextNode(ListNode<T> node){
        node.next = node.next.next;
    }

    public void printLinkedList(ListNode<T> head){
        ListNode<T> node = head;
        while(node != null){
            if(node.next != null)
                System.out.print(node.data+" -> ");
            else
                System.out.println(node.data);

            node = node.next;
        }
        System.out.println();
    }

    public int lengthOfAList(ListNode<T> head){
        int counter = 0;
        ListNode<T> pointer = head;
        while(pointer != null){
            counter++;
            pointer = pointer.next;
        }
        return counter;
    }

}
