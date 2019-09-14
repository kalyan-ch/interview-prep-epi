package org.wb.epi.Chap8StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax {
    private Deque<ElementWithCachedMax> internalStack = new ArrayDeque<>();

    public boolean isEmpty(){
        return internalStack.isEmpty();
    }

    public int maxElement(){
        if(isEmpty()){
            return -1;
        }
        return internalStack.peek().max;
    }

    public void push(int ele){

        ElementWithCachedMax elem = new ElementWithCachedMax(ele, Math.max(ele, isEmpty()? ele: maxElement()));
        System.out.println(elem);
        internalStack.addFirst(elem);
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        return internalStack.pop().x;
    }

}
