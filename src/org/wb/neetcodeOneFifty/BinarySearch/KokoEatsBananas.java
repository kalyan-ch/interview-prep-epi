package org.wb.neetcodeOneFifty.BinarySearch;

public class KokoEatsBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles, 5));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = 0;
        int k = 0;
        for(int p: piles) {
            low = Math.min(p, low);
            high = Math.max(p, high);
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canEatAll(piles, h, mid)) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }

    public static boolean canEatAll (int[] piles, int h, int speed) {
        var count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += piles[i] % speed == 0 ? piles[i] / speed : (piles[i] / speed) + 1;
            if (count > h) {
                break;
            }
        }
        return count <= h;
    }
}
