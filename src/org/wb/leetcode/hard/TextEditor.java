package org.wb.leetcode.hard;

import java.util.LinkedList;

public class TextEditor {
    LinkedList<Character> textChar;
    int cursor;

    public TextEditor() {
        textChar = new LinkedList<>();
        cursor = -1;
    }

    public void addText(String text) {
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            textChar.add(++cursor, c);
        }
    }

    public int deleteText(int k) {
        int count = 0;

        while(cursor >= 0 && k-- > 0){
            count++;
            textChar.remove(cursor--);
        }

        return count;
    }

    public String cursorLeft(int k) {

        while(cursor >= 0 && k-- > 0) {
            cursor--;
        }

        return getString();
    }

    public String cursorRight(int k) {
        while(cursor < textChar.size() - 1 && k-- > 0) {
            cursor++;
        }

        return getString();
    }

    public String getString(){
        int lowerBound = 10;
        StringBuilder sb = new StringBuilder();
        for(int i = cursor; (i >= 0) && (lowerBound-- > 0) ; i--) {
            sb.append(textChar.get(i));
        }
        return sb.reverse().toString();
    }
}
