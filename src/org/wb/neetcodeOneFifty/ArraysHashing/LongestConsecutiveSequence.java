package org.wb.neetcodeOneFifty.ArraysHashing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws IOException {
        int[] nums = {2, 1, 3, 4, 8, 10, 11, 13, 12, 5};
        int[] nums2 = {1,0,1,2};
        int[] nums3 = Arrays.stream(Files.readString(Path.of("resources/LongestConsecutiveSequence/case3.txt")).trim().split(",")).mapToInt(Integer::parseInt).toArray();
        //System.out.println(longestConsecutiveSequence(nums));
        //System.out.println(longestConsecutiveSequence(nums2));
        long start = System.currentTimeMillis();
        System.out.println(longestConsecutiveSequence(nums3));
        long time = System.currentTimeMillis() - start;
        System.out.println("time taken: "+time);
    }

    public static int longestConsecutiveSequence(int[] nums) {
        int result = 0;
        var numSet = new HashSet<Integer>();

        for(int n: nums){
            numSet.add(n);
        }

        for (int n: numSet){
            if(!numSet.contains(n - 1)) {
                var tempLength = 1;
                while(numSet.contains(n + tempLength)) {
                    tempLength += 1;
                }

                result = Math.max(tempLength, result);
            }
        }

        return result;
    }
}
