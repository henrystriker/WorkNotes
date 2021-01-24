package com.javab1.week7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main
public class StringNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BigDecimal> resList = new ArrayList<>();
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }
            resList.add(calcStrNum(n, arr));
        }
        for (BigDecimal aLong : resList) {
            System.out.println(aLong);
        }
        sc.close();
    }

    static BigDecimal calcStrNum(int n, int[] arr){
        BigDecimal res = new BigDecimal("1");
        int m = 0;
        for (int i = 0; i < n; ++i){
            m += arr[i];
        }
        for (int i = 1; i <= m; ++i){
            res = res.multiply(BigDecimal.valueOf(i));
        }
        for (int i = 0; i < n; ++i){
            BigDecimal temp = new BigDecimal("1");
            for (int j = 1; j <= arr[i]; ++j){
                temp = temp.multiply(BigDecimal.valueOf(j));
            }
            res = res.divide(temp, 0, BigDecimal.ROUND_UNNECESSARY);
        }
        return res;
    }
}
