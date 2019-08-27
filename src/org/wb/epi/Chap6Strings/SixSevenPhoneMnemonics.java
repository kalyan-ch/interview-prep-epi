package org.wb.epi.Chap6Strings;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SixSevenPhoneMnemonics {
    private static String[] numberMap = {" ", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //compute all mnemonics for a phone number
    public static void main(String[] args) {
        List<String> allWords = phoneMnemonics("724");
        System.out.println(allWords.size());

        allWords = phoneMnemonics("7044212428");
        System.out.println(allWords.size());
    }

    private static List<String> phoneMnemonics(String phoneNum){
        List<String> mnemonics = new ArrayList<>();
        char[] partialStr = new char[phoneNum.length()];
        phoneMnemonicHelper(phoneNum, 0, partialStr, mnemonics);
        return mnemonics;
    }

    private static void phoneMnemonicHelper(String phoneNum, int digit, char[] partialStr, List<String> mnemonics){
        if(digit == phoneNum.length()){
            mnemonics.add(new String(partialStr));
        }else{
            int phoneDigit = phoneNum.charAt(digit) - '0';
            for(int i = 0; i < numberMap[phoneDigit].length(); i++){
                char c = numberMap[phoneDigit].charAt(i);
                partialStr[digit] = c;
                phoneMnemonicHelper(phoneNum, digit+1, partialStr, mnemonics);
            }
        }



    }

}
