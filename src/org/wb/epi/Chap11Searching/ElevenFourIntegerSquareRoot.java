package org.wb.epi.Chap11Searching;

public class ElevenFourIntegerSquareRoot{

    public static void main(String[] args){
        System.out.println(findSquareRoot(400000));
    }

    //find the largest integer whose square is less than or equal to the given integer
    private static int findSquareRoot(int n){
        long start = 0, end = n;

        while (start <= end){
            long mid = (start + end) / 2;
            long midSq = mid*mid;
            if(midSq > n){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return (int)(start - 1);
    }

}