package org.wb.Chap5Arrays;

import java.util.Random;

import static org.wb.Chap5Arrays.ArraysUtils.*;

public class FiveTwelveSampleOfflineData {

    public static void main(String[] args) {
        int[] arr = {12,5,-5,9,58,6,9,7,-85,15,99,48,57,51,56,854};
        selectRandomSample(5, arr);
        printIntArray(arr);
    }

    private static void selectRandomSample(int k, int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            int randIndex = rand.nextInt(arr.length);
            swap(arr, i, randIndex);
        }
    }

}
