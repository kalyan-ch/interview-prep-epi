package org.wb.leetcode.easy;

public class CountingBits {
    public static void main(String[] args) {
        countBits(5);
    }

    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i = 1; i <= n; i++){
            int count = 0, num = i;
            while(num > 0){
                count += num & 1;
                num >>= 1;
            }
            result[i] = count;
        }

        return result;
    }

}
