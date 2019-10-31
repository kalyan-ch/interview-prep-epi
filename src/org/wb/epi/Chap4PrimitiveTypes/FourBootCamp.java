package org.wb.epi.Chap4PrimitiveTypes;

public class FourBootCamp {
    public static void main(String[] args) {
        System.out.println(countSetBits(8));
    }

    private static int countSetBits(int num){
        int count = 0;
        while(num != 0){
            count += (num & 1);
            num >>>= 1;
        }
        return count;
    }
}
