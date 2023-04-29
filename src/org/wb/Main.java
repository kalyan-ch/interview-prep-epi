package org.wb;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class Main {

    public static void main(String[] args) {
        String s = "/a";
        String[] s1 = s.split("/");
        for(String s2: s1){
            System.out.println(s2);
        }

    }
}
