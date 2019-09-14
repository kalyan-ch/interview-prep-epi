package org.wb.epi.Chap8StacksAndQueues;

public class ElementWithCachedMax {
    @Override
    public String toString() {
        return "x: "+x+" max: "+max;
    }

    public int x;
    public int max;

    public ElementWithCachedMax(int x, int max){
        this.x = x;
        this.max = max;
    }

}
