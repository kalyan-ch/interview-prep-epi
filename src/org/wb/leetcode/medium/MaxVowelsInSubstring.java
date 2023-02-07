package org.wb.leetcode.medium;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class MaxVowelsInSubstring {
    public static void main(String[] args) {
        try{
            String s = readFile("src/org/wb/leetcode/testfiles/longstring.txt");
            System.out.println(s);
            long millis = System.currentTimeMillis();
            System.out.println(maxVowels(s, 3945));
            long diff = System.currentTimeMillis() - millis;

            System.out.println(diff);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName) throws Exception{
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        StringBuilder sb = new StringBuilder();
        while (myReader.hasNextLine()) {
            sb.append(myReader.nextLine());
        }

        return sb.toString();
    }

    public static int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');
        vowels.add('o');vowels.add('u');

        int result = 0, r = 0, vowelCount = 0;;
        while(r < s.length()){

            if(vowels.contains(s.charAt(r))){
                vowelCount++;
            }

            if(r >= k && vowels.contains(s.charAt(r-k))){
                vowelCount--;
            }

            result = Math.max(vowelCount, result);

            r++;
        }

        return result;
    }
}
