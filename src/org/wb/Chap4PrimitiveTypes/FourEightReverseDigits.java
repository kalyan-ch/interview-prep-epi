package org.wb.Chap4PrimitiveTypes;

public class FourEightReverseDigits {
    // reverse an integer
    public static void main(String[] args) {
        System.out.println(reverseInteger(-456));
        System.out.println(reverseInteger(224556));
        System.out.println(checkIfPalindrome(22522));
    }

    private static int reverseInteger(int num) {
        int result = 0;
        int num1 = Math.abs(num);
        while(num1 > 0){
            int digit = num1 % 10;
            result = result * 10 + digit;
            num1 /= 10;
        }
        return num < 0 ? -result: result;
    }

    //variant 1
    //check if number is palindrome
    public static boolean checkIfPalindrome(int num){
        return reverseInteger(num) == num;
    }

}
