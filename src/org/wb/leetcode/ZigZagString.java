package org.wb.leetcode;

public class ZigZagString {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int k = 2 * (numRows-1);
        for(int i = 0; i < numRows; i++){
            int j = i;

            if(i == 0 || i == numRows-1){
                for(j = i; j < s.length(); j+=k) {
                    result.append(s.charAt(j));
                }
            }else{
                int diff = i*2, turn = 0;
                while(j < s.length()){
                    result.append(s.charAt(j));
                    if(turn%2 == 0){
                        j += k-diff;
                    }else{
                        j += diff;
                    }
                    turn++;
                }
            }
        }

        return result.toString();
    }
}
