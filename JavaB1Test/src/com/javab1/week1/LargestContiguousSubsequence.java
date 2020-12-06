package com.javab1.week1;

import java.util.ArrayList;
import java.util.Scanner;

// Main
public class LargestContiguousSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        ArrayList<ArrayList<Long>> results = new ArrayList<>();
        while ((n = sc.nextInt()) != 0){
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }
            ArrayList<Long> result = largestContiguousSubsequence(arr, n);
            results.add(result);
        }
        for (ArrayList<Long> result : results) {
            System.out.print(result.get(0));
            for (int j = 1; j < result.size(); ++j) {
                System.out.print(" " + result.get(j));
            }
            System.out.println();
        }
        sc.close();
    }

    // 动态规划
    static ArrayList<Long> largestContiguousSubsequence(int[] arr, int k){
        ArrayList<Long> result = new ArrayList<>();
        long maxSum = arr[0];
        int maxStart = 0;
        int maxEnd = k - 1;
        long[] dp = new long[k + 1];
        dp[0] = 0;
        int[] start = new int[k + 1];
        start[0] = 1;
        for (int i = 1; i <= k; ++i){
            dp[i] = arr[i - 1];
            start[i] = i;
            if (dp[i - 1] > 0){
                dp[i] += dp[i - 1];
                start[i] = start[i - 1];
            }
            if (dp[i] > maxSum){
                maxSum = dp[i];
                maxStart = start[i] - 1;
                maxEnd = i - 1;
            }
        }
        if (maxSum < 0){
            maxSum = 0;
        }
        result.add(maxSum);
        result.add((long)arr[maxStart]);
        result.add((long)arr[maxEnd]);
        return result;
    }
}
