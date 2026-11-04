package org.wb.neetcodeOneFifty.TwoPointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int result = 0, l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        while (l < r) {
            var left = height[l];
            var right = height[r];

            maxL = Math.max(left, maxL);
            maxR = Math.max(right, maxR);

            if(maxL < maxR) {
                result += maxL - left;
                l++;
            } else {
                result += maxR - right;
                r--;
            }
        }
        return result;
    }

}
