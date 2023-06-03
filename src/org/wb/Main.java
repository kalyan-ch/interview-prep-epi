package org.wb;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 2; i < 10; i += 2){
            ls.add(i);
        }

        ls.add(2, 5);

        ArraysUtils.printIntList(ls);

    }
}
