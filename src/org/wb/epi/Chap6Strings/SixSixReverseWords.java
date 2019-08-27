package org.wb.epi.Chap6Strings;

public class SixSixReverseWords {

    //reverse all words in a sentence
    public static void main(String[] args) {
        String sente = "the scrollbar shows errors and warnings in the current file";
        char[] sentChar = sente.toCharArray();
        reverseWordsInaSentence(sentChar);
        System.out.println(sentChar);

        String sente1 = "im not kalyan";
        sentChar = sente1.toCharArray();
        reverseWordsInaSentence(sentChar);
        System.out.println(sentChar);

    }

    private static void reverseWordsInaSentence(char[] sentence){
        // reverse the entire sentence
        reverseString(sentence, 0, sentence.length-1);

        //reverse each word in the sentence
        int i = 0, spaceInd = 1;

        while(spaceInd < sentence.length){
            if(sentence[spaceInd] == ' '){
                reverseString(sentence, i, spaceInd-1);
                i = spaceInd+1;
            }else if(spaceInd == sentence.length-1){
                reverseString(sentence, i, spaceInd);
            }
            spaceInd++;
        }


    }

    private static void reverseString(char[] str, int i, int j){
        while(i < j){
            char tmp = str[i];
            str[i++] = str[j];
            str[j--] = tmp;
        }
    }

}
