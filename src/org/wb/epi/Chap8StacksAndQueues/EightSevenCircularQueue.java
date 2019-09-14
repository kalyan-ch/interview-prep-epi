package org.wb.epi.Chap8StacksAndQueues;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntArray;

public class EightSevenCircularQueue {

    static class CirQueue{
        int head = 0, tail = 0, numElements = 0;
        int[] values;

        CirQueue(int capacity){
            values = new int[capacity];
        }

        public void enQue(int x){
            if(numElements == values.length){
                Collections.rotate(Arrays.asList(values), -head);
                head = 0;
                tail = numElements;
                values = Arrays.copyOf(values, numElements*2);
            }
            values[tail] = x;
            tail = (tail+1) % values.length;
            ++numElements;
        }

        public int deQue(){
            if(numElements != 0){
                --numElements;
                int res = values[head];
                values[head] = 0;
                head = (head + 1) % values.length;
                return res;
            }

            throw new NoSuchElementException();
        }

    }

    public static void main(String[] args) {
        CirQueue cirQ = new CirQueue(5);
        cirQ.enQue(5);
        printIntArray(cirQ.values);
        cirQ.enQue(10);
        printIntArray(cirQ.values);
        cirQ.enQue(15);
        printIntArray(cirQ.values);
        cirQ.enQue(42);
        printIntArray(cirQ.values);
        cirQ.enQue(2);
        printIntArray(cirQ.values);
        cirQ.enQue(26);
        printIntArray(cirQ.values);

        System.out.println(cirQ.deQue());
        printIntArray(cirQ.values);
        System.out.println(cirQ.deQue());
        printIntArray(cirQ.values);

        cirQ.enQue(20);
        printIntArray(cirQ.values);
        cirQ.enQue(320);
        printIntArray(cirQ.values);
        cirQ.enQue(220);
        printIntArray(cirQ.values);
        cirQ.enQue(205);
        printIntArray(cirQ.values);
        cirQ.enQue(507);
        printIntArray(cirQ.values);

        System.out.println(cirQ.deQue());

    }
}
