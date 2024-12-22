package org.wb.leetcode.LeetCodeAndBlind75;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[][] flowerBeds = {{1, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 0, 1}};
        for(int[] arr: flowerBeds) {
            System.out.println(canPlaceFlowers(arr, 2));
        }
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) {
            return true;
        }

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                --n;
                if(n == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
