package org.wb.neetcodeOneFifty.SlidingWindow;

import java.util.ArrayList;

public class LongestAfterCharReplacement {
    public static void main(String[] args) {
        var testValues = new ArrayList<TestValue>();
        testValues.add(new TestValue(2, "ABBB"));
        testValues.add(new TestValue(2, "XYYX"));
        testValues.add(new TestValue(1, "AAABABB"));
        testValues.add(new TestValue(2, "ABABBAAABAB"));

        for(var test: testValues) {
            System.out.println(characterReplacement(test.s, test.k));
        }
    }

    public static int characterReplacement(String s, int k) {
        int result = 0;
        int[] countMap = new int[26];
        int l = 0, maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            var charIdx = s.charAt(r) - 'A';
            countMap[charIdx]++;
            maxFreq = Math.max(maxFreq, countMap[charIdx]);
            while ((r - l + 1) - maxFreq > k) {
                countMap[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }

    public static int getMaxFreq(int[] countMap) {
        int maxVal = 0;
        for(int i: countMap) {
            maxVal = Math.max(maxVal, i);
        }

        return maxVal;
    }

    private static class TestValue {
        int k;
        String s;

        public TestValue(int x, String t) {
            k = x;
            s = t;
        }
    }
}
