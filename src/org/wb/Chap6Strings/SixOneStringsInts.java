package org.wb.Chap6Strings;

public class SixOneStringsInts {

    public static void main(String[] args) {

        System.out.println(convertStringToInt("-452"));
        System.out.println(convertIntToString(253));
        System.out.println(convertIntToString(-9953));
    }

    private static int convertStringToInt(String s) {
        int number = 0;

        for(int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++){
            int digit = s.charAt(i) - '0';
            number = number*10 +digit;
        }

        return s.charAt(0) == '-' ? -number: number;
    }

    private static String convertIntToString(int num) {
        StringBuilder sb = new StringBuilder();
        if(num < 0){
            sb.append("-");
            num = -num;
        }
        int numDigits = (int)(Math.floor(Math.log10(num)) + 1);
        while(numDigits-- > 0){
            int pow10 = ((int)Math.pow(10, numDigits));
            int digit = num/pow10;
            num = num % pow10;
            sb.append(digit);
        }

        return sb.toString();
    }

}
