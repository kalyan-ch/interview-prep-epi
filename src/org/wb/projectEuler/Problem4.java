package org.wb.projectEuler;

public class Problem4 {

    public static void main(String[] args) {
        System.out.println(largestPalindromeProduct(2));
        System.out.println(largestPalindromeProduct(3));
        System.out.println(largestPalindromeProduct(4));
    }

    private static int largestPalindromeProduct(int numDigits) {
        int product = 0;
        int upperBound = (int)(Math.pow(10, numDigits) - 1);
        int lowerBound = (int) Math.pow(10, numDigits-1);

        for (int i = upperBound; i > lowerBound; i--) {
            for (int j = upperBound; j > lowerBound; j--) {
                if(isPalindrome(i*j))
                   product = Math.max(product, i*j);
            }
        }

        return product;
    }

    private static boolean isPalindrome(int number){
        int reverse = 0, temp = number;
        while(temp > 0){
            int digit = temp % 10;
            reverse = reverse*10 + digit;
            temp = temp / 10;
        }
        return reverse == number;
    }

}
