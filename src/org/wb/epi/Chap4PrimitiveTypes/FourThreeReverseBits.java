package org.wb.epi.Chap4PrimitiveTypes;

public class FourThreeReverseBits {
    // reverse the bits of a 64 bit number
    public static void main(String[] args) {
        System.out.println(reverseBits1(56584457771L));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(2, 63));

        System.out.println(reverseBits(43261596));
    }

    //swap bits iteratively from left to right
    private static long reverseBits1(long num) {
        long result = num;
        int i = 0, j = 63;
        while(j > i){
            if(((num >>> i) & 1) != ((num >>> j) & 1)){
                long bitMask = (1L << i) | (1L << j);
                result = result ^ bitMask;
            }
            i++;
            j--;
        }
        return result;
    }

    private static int reverseBits(int n) {
        int i = 0, j = 31, result = n;

        while (j > i) {
            int leftBit = n >>> i;
            int rightBit = n >>> j;
            if((rightBit & 1) != (leftBit & 1)) {
                int bitMask = (1 << i) | (1 << j);
                result = result ^ bitMask;
            }

            i++; j--;
        }

        return result;
    }


}
