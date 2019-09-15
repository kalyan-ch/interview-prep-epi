package org.wb.leetcode;

public class Prob2StringToInt {

    public static void main(String[] args) {
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("492w"));
        System.out.println(myAtoi("125"));
        System.out.println(myAtoi("-58"));
        System.out.println(myAtoi("     58"));
        System.out.println(myAtoi("saf sa65"));
        System.out.println(myAtoi("-58"));
        System.out.println(myAtoi("-91283472332"));

        System.out.println(Integer.parseInt("+1"));

    }

    public static int myAtoi(String str) {

        if(str == null){
            return 0;
        }

        str = str.trim();

        if("".equalsIgnoreCase(str)){
            return 0;
        }

        int result = 0;
        StringBuilder finalString = new StringBuilder();
        long tempRes = 0L;


        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i) != '-' ){
                break;
            }else{
                finalString.append(str.charAt(i));
            }
        }

        try {
            tempRes = Long.parseLong(finalString.toString());
        }catch (Exception e){
            return 0;
        }

        if(tempRes > Integer.MAX_VALUE || tempRes < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)tempRes;
    }
}
