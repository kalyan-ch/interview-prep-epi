package org.wb.epi.Chap6Strings;

public class SixBootcamp {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aasdaa"));
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}
