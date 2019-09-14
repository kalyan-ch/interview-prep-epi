package org.wb.epi.Chap8StacksAndQueues;

public class EightOneStackWithMax {

    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        stack.push(10);
        stack.push(9);
        stack.push(13);
        stack.push(1);
        stack.push(15);

        System.out.println(stack.maxElement());
        System.out.println("pop: "+stack.pop());
        System.out.println(stack.maxElement());

    }

}
