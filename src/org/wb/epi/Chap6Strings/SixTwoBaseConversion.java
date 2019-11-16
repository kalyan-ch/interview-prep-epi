package org.wb.epi.Chap6Strings;

public class SixTwoBaseConversion {

    //convert a string s in base b1 to base b2
    public static void main(String[] args) {
        String newNum = baseConvert("-352", 3, 5);
        System.out.println(newNum);
    }

    private static String baseConvert(String s, int b1, int b2){
        StringBuilder sb = new StringBuilder();
        boolean isNeg = s.charAt(0) == '-';
        s = isNeg ? s.substring(1) : s;
        int numInbase10 = 0, n = s.length();

        if(b1 == 0)
            numInbase10 = Integer.parseInt(s);
        else {
            //convert number from base b1 into base 10
            for (int i = n - 1; i > -1; i--) {
                int digit = s.charAt(i) - '0';
                numInbase10 += (int) Math.pow(b1, n - i - 1) * digit;
            }
        }

        System.out.println(numInbase10);
        //convert numInbase10 into base b2
        if(b2 == 10){
            if(isNeg)
                sb.append("-");
            sb.append(numInbase10);
        }else{
            int quo = numInbase10, rem = 0;
            while(quo > 0){
                rem = quo % b2;
                quo = quo / b2;
                sb.append(rem);
            }
            if(isNeg)
                sb.append("-");
            sb.reverse();
        }
        return sb.toString();
    }

}
