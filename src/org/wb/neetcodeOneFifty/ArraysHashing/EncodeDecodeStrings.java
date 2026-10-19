package org.wb.neetcodeOneFifty.ArraysHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        var words = new ArrayList<String>();
        words.add("neet");
        words.add("code");
        words.add("lint");
        words.add("erro#r");
        words.add("fleet,");


        var encodedStr = encode(words);

        System.out.println("encodedStr:  ------  "+encodedStr);

        var decodedWords = decode(encodedStr);

        if(words.size()!= decodedWords.size()) {
            System.out.println("number of words don't match");
            return;
        }

        for (int i =0; i < words.size(); i++) {
            if (!words.get(i).equals(decodedWords.get(i))) {
                System.out.println("error - words don't match" + words.get(i)+" "+decodedWords.get(i));
                break;
            }
        }

        System.out.println("encoded and decoded successfully");
    }

    public static String encode(List<String> strs) {
        var sb = new StringBuilder();
        for(String s: strs) {
            int size = s.length();
            sb.append(size).append("#").append(s).append(",");
        }
        return sb.toString();
    }

    public static List<String> decode(String encodedStr) {
        var result = new ArrayList<String>();
        var i = 0;

        while(i < encodedStr.length()) {
            var j = i;
            while(encodedStr.charAt(j) != '#') {
                j++;
            }

            var size = Integer.parseInt(encodedStr.substring(i, j));
            var word = new StringBuilder();
            for (int k = j + 1; k <= j + size; k++) {
                word.append(encodedStr.charAt(k));
            }
            result.add(word.toString());
            i = j + size + 2;
        }


        return result;
    }
}
