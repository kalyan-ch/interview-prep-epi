package org.wb;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int[] arr = {1, 2, 3};

        Set<Integer> arrSet =Arrays.stream(arr).boxed().collect(Collectors.toSet());
        Integer[] arr2 = arrSet.toArray(new Integer[arrSet.size()]);
    }
}
