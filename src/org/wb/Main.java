package org.wb;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        Set<Integer> set = strings.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toSet());

    }
}
