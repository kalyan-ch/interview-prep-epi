package org.wb.epi.Chap15Recursion;

// given number of rings and that no ringer can go on top of smaller ring
// print the sequence of steps that will take to
// transfer all rings from one tower to another

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FifteenOneHanoi {
    public static void main(String[] args) {
        List<List<String>> steps = transferRingsToAnotherTower(5);
        System.out.println(steps.size());
        ArraysUtils.printStr2dList(steps);
    }

    private static List<List<String>> transferRingsToAnotherTower(int numRings) {
        List<Stack<Integer>> towers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            towers.add(new Stack<>());
        }

        for(int i = numRings; i > 0; i--) {
            towers.get(0).push(i);
        }

        List<List<String>> result = new ArrayList<>();
        computeHanoi(numRings, towers, result, 0, 1, 2);
        return result;
    }

    private static void computeHanoi(int numRings, List<Stack<Integer>> towers, List<List<String>> result,
                                     int fromTower, int toTower, int useTower) {
        if(numRings > 0) {
            computeHanoi(numRings - 1, towers, result, fromTower, useTower, toTower);
            towers.get(toTower).push(towers.get(fromTower).pop());
            result.add(Arrays.asList(String.valueOf(fromTower), String.valueOf((toTower))));
            computeHanoi(numRings - 1, towers, result, useTower, toTower, fromTower);
        }
    }
}
