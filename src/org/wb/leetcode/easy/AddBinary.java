package org.wb.leetcode.easy;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010",
                "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while(i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            switch (sum) {
                case 2 -> {
                    carry = 1;
                    sum = 0;
                }
                case 3 -> {
                    carry = 1;
                    sum = 1;
                }
                default -> carry = 0;
            }

            sb.append(sum);
            i--; j--;
        }

        if(carry > 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
