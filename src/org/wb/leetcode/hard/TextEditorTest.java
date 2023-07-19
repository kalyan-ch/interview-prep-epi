package org.wb.leetcode.hard;

public class TextEditorTest {
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.addText("leetCode");
        System.out.println(te.deleteText(4));
        te.addText("practice");
        System.out.println(te.cursorRight(3));
        System.out.println(te.cursorLeft(8));
        System.out.println(te.deleteText(10));
        System.out.println(te.cursorLeft(2));
        System.out.println(te.cursorRight(6));
    }
}
