package com.javab1.week2;

import java.math.BigDecimal;
import java.util.Scanner;

// Main
public class APengWantHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int R = sc.nextInt();
        int r = sc.nextInt();
        String result = isTableBigEnough(n, R, r);
        System.out.println(result);
        sc.close();
    }

    static String isTableBigEnough(int n, int R, int r){
        BigDecimal bR = BigDecimal.valueOf(Double.valueOf(R));
        BigDecimal br = BigDecimal.valueOf(Double.valueOf(r));
        BigDecimal bn = BigDecimal.valueOf(Double.valueOf(n));
        if (br.compareTo(bR) > 0){
            return "NO";
        }
        if (br.multiply(BigDecimal.valueOf(Double.valueOf(2))).compareTo(bR) <= 0) {
            BigDecimal bSinTheta = br.divide(bR.subtract(br), 32, BigDecimal.ROUND_HALF_UP);
            double theta = Math.asin(bSinTheta.doubleValue());
            BigDecimal bTheta = BigDecimal.valueOf(theta);
            BigDecimal bPi = BigDecimal.valueOf(3.141592653589793238462643383279);
            if (bTheta.multiply(bn).compareTo(bPi) <= 0) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            if (bn.compareTo(BigDecimal.valueOf(Double.valueOf(1))) <= 0){
                return "YES";
            } else {
                return "NO";
            }
        }
    }
}
