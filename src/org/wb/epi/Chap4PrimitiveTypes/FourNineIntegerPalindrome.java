package org.wb.epi.Chap4PrimitiveTypes;

public class FourNineIntegerPalindrome {
    public static void main(String[] args) {
        int[] tests = {1, 22, 323, -5, 24, 4334, 100, Integer.MAX_VALUE};
        for(int i : tests){
            System.out.println(isPalindrome(i));
        }
    }

    private static boolean isPalindrome(int x) {
        if(x <= 0) {
            return x == 0;
        }

        int n = x;
        int reverse = 0;
        while(n != 0) {
            reverse *= 10;
            int digit = n % 10;
            reverse += digit;
            n /= 10;
        }

        return reverse == x;
    }
}
