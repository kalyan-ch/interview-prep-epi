package org.wb.epi.Chap7LinkedLists;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    public ListNode(T data){
        this.data = data;
        this.next = null;
    }

    public ListNode(){

    }

}
