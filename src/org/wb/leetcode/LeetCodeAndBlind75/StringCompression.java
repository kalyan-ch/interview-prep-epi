package org.wb.leetcode.LeetCodeAndBlind75;

public class StringCompression {
    public static void main(String[] args) {
        char[][] strings = {{'a','a','b','b','c','c','c'}, {'a'},
                {'a','b','b','b','b','b','b','b','b','b','b','b','b'},
                {'a','a','a','b','b','a','a'}};

        for(char[] str: strings) {
            int idx = compress(str);
            System.out.print(idx + " ");
            for(int i = 0; i < idx; i++){
                System.out.print(str[i]);
            }
            System.out.println();
        }
    }

    private static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1) {
                for (char c : String.valueOf(count).toCharArray())
                    chars[indexAns++] = c;
            }
        }
        return indexAns;
    }
}
