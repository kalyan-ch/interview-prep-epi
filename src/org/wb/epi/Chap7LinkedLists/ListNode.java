package org.wb.epi.Chap7LinkedLists;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data){
        this.data = data;
        this.next = null;
    }

    public ListNode(){

    }

    @Override
    public String toString() {
        return "data= " + data;
    }
}
