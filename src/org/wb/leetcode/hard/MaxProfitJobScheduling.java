package org.wb.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxProfitJobScheduling {
    public static void main(String[] args) {
        int[] startTimes = {1, 2, 3, 4, 6};
        int[] endTimes = {3, 5, 10, 6, 9};
        int[] profits = {20, 20, 100, 70, 60};

        int maxProfit = jobScheduling(startTimes, endTimes, profits);
        System.out.println(maxProfit);
    }

    static int[] memo;
    static int n;

    private static int jobScheduling(int[] startTimes, int[] endTimes, int[] profits) {
        // first thing about this is to select non-conflicting jobs, since we can't be in two places at once
        // start1 >= end2 or start2 >= end1 means jobs 1 and 2 are non-conflicting
        // if we schedule a job, that means all jobs having a conflict with it can't be scheduled

        // create a list with three dimensions to store info about a job together
        n = startTimes.length;
        int[][] jobs = new int[n][3];

        memo = new int[n];
        Arrays.fill(memo, -1);

        for(int i = 0; i < startTimes.length; i++){
            jobs[i] = new int[] {startTimes[i], endTimes[i], profits[i]};
        }

        // sort the jobs array so that it is easier to look for non-conflicting jobs
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < startTimes.length; i++){
            startTimes[i] = jobs[i][0];
        }

        for(int pos = n - 1; pos >= 0; pos--) {
            int currProfit = jobs[pos][2];
            int nextIdx = findNextJob(startTimes, jobs[pos][1]);

            // if nextIdx is within the startTime array
            // add the profit of this nextIdx job to current job
            if(nextIdx != n) {
                currProfit += memo[nextIdx];
            }

            // if pos is last then only profit is to complete the job at hand
            // else compare currProfit with profit obtained by doing next set of jobs too
            if(pos == n - 1){
                memo[pos] = currProfit;
            } else {
                memo[pos] = Math.max(currProfit, memo[pos + 1]);
            }
        }

        return memo[0];
    }



    private static int findNextJob(int[] startTimes, int currEndTime) {
        int l = 0, r = n -1, nextIdx = n;
        // find the first job that starts after currEndTime
        while(l <= r){
            int m = (l + r) / 2;
            if(startTimes[m] >= currEndTime){
                nextIdx = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return nextIdx;
    }


}
