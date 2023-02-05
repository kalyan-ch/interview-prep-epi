package org.wb.leetcode.easy;

import java.util.Random;

public class LicenseKeyFormatting {

    private static String randomStringGen(int n){
        StringBuilder sb = new StringBuilder();
        Random rn = new Random();
        int i = 0;
        while (i < n) {
            boolean isAlpha = rn.nextBoolean();
            int index = -1;

            if (isAlpha) {
                index = rn.nextInt(97, 123);
                sb.append((char) index);
                i++;
            }else {
                index = rn.nextInt(0, 10);
                sb.append(index);
                i++;
            }

            boolean isDash = rn.nextBoolean();
            if(isDash)
                sb.append('-');
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String key = randomStringGen(12);
        System.out.println(key);
        //System.out.println(formatLicenseKey(key, 4));
        System.out.println(formatLicenseKey("2-5g-3-J", 2));
    }

    private static String formatLicenseKey(String key, int k) {
        StringBuilder sb = new StringBuilder();
        String[] alphaNum = key.split("-");
        String alphaNumStr = String.join("", alphaNum);
        alphaNumStr = alphaNumStr.toUpperCase();
        for (int i = alphaNumStr.length() - 1; i >= 0 ; i = i - k) {
            for (int j = i; j > i-k && j >= 0; j--) {
                sb.append(alphaNumStr.charAt(j));
            }
            if(i >= k)
                sb.append('-');
        }

        return sb.reverse().toString();
    }
}
