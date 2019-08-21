package org.wb.Chap4PrimitiveTypes;

public class FourThreeReverseBits {
    // reverse the bits of a 64 bit number
    public static void main(String[] args) {
        System.out.println(reverseBits1(56584457771L));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(2, 63));
    }

    //swap bits iteratively from left to right
    private static long reverseBits1(long l) {
        long result = 0;
        int i = 0, j = 63;
        while(j > i){
            if(((l >>> i) & 1) != ((l >>> j) & 1)){
                long bitMask = (1L << i) | (1L << j);
                result = l ^ bitMask;
            }
            i++;
            j--;
        }
        return result;
    }


}
