package com.javab1.week1;

import java.util.ArrayList;
import java.util.Scanner;

// Main
public class LargestSubmatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> results = new ArrayList<>();
        for (int k = 0; k < t; ++k) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; ++i){
                arr[i] = sc.nextInt();
            }
            int[][] matrix = new int[arr[0]][arr[1]];
            for (int i = 0; i < arr[0]; ++i){
                for (int j = 0; j < arr[1]; ++j){
                    matrix[i][j] = sc.nextInt();
                }
                sc.nextLine();
            }
            int result = largestContiguousSubsequence(matrix, arr[0], arr[1], arr[2], arr[3]);
            results.add(result);
        }
        for (Integer result : results) {
            System.out.println(result);
        }
        sc.close();
    }

    // 动态规划
    static int largestContiguousSubsequence(int[][] matrix, int m, int n, int x, int y){
        int[][] dp = new int[m][n];
        for (int i = 0; i < x; ++i){
            for (int j = 0; j < y; ++j){
                dp[x - 1][y - 1] += matrix[i][j];
            }
        }
        int max = dp[x - 1][y - 1];
        for (int i = x; i < m; ++i){
            dp[i][y - 1] = dp[i - 1][y - 1];
            for (int j = 0; j < y; ++j){
                dp[i][y - 1] -= matrix[i - x][j];
                dp[i][y - 1] += matrix[i][j];
            }
            max = Math.max(dp[i][y - 1], max);
        }
        for (int i = x - 1; i < m; ++i){
            for (int j = y; j < n; ++j){
                dp[i][j] = dp[i][j - 1];
                for (int k = i - x + 1; k < i + 1; ++k){
                    dp[i][j] -= matrix[k][j - y];
                    dp[i][j] += matrix[k][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
