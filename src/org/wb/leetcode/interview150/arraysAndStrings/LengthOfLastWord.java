package org.wb.leetcode.interview150.arraysAndStrings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" fh  dfasfa dfasfagg ggdgfd   "));
    }

    private static int lengthOfLastWord(String s) {
        s = s.trim();

        int i = s.length() - 1, len = 0;

        while(i >= 0) {
            if(s.charAt(i--) == ' '){
                break;
            }
            len++;
        }

        return len;
    }
}
