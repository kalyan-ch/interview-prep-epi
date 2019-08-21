package org.wb.Chap4PrimitiveTypes;

public class FourOneParity {
    // parity - number of 1s in a bit - parity is 1 number of 1s is odd 0 otherwise
    // find the parity of a number
    public static void main(String[] args) {
        System.out.println(findParityBruteForce(1592L));
        System.out.println(findParitySetLowestBitToZero(1593L));
        System.out.println(rightPropagateSetBit(48));
        System.out.println(modPowerOf2(43, 8));
        System.out.println(isPowerOf2(43));
        System.out.println(isPowerOf2(64));
        System.out.println(isPowerOf2(4096));
    }

    private static short findParitySetLowestBitToZero(long l) {
        short result = 0;
        while(l != 0){
            result ^= 1;
            l &= (l-1);
        }
        return result;
    }

    private static short findParityBruteForce(long number) {
        short result=0;
        while(number > 0){
            result ^= (number & 1);
            number >>>= 1;
        }
        return result;
    }

    //variant1
    //right propagate rightmost set bit in O(1) time
    // 00110000 becomes 00111111
    private static int rightPropagateSetBit(int num){
        return (num | (num -1));
    }

    // variant2
    // find x mod a power of 2 in O(1)
    private static int modPowerOf2(int num, int twoPow){
        return num & (twoPow - 1);
    }

    //variant3
    // test if x is a power of 2
    private static boolean isPowerOf2(int num){
        return (num & (num - 1)) == 0;
    }

}
