package org.wb.Misc;

public class SampleMain {

    public static void main(String[] args) {
        printReverse("hello");
    }

    private static void printReverse(String s){
        printChar(0, s);
    }

    private static void printChar(int index, String s){
        if(index >= s.length()){
            return;
        }
        printChar(index+1, s);
        System.out.print(s.charAt(index));
    }


}
