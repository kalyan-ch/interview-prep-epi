package org.wb.neetcodeOneFifty.TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String[] strs = {"Was it a car or a cat I saw?", "tab a cat", "was nit tin saw"};
        for(String s : strs) {
            System.out.println(isPalindrome(s));
        }
    }

    public static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        while(i < j) {
            char leftC = s.charAt(i);
            char rightC = s.charAt(j);

            if(!Character.isLetterOrDigit(leftC)) {
                i++;
            } else if(!Character.isLetterOrDigit(rightC)){
                j--;
            } else {
                if(Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {
                    return false;
                }
                i++; j--;
            }
        }

        return true;
    }
}
