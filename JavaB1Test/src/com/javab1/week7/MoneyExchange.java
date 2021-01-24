package com.javab1.week7;

import java.util.Scanner;

// Main
public class MoneyExchange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long res = solutionNumOfTernaryLinearEquation(n);
            System.out.println(res);
        }
        sc.close();
    }

    static long solutionNumOfTernaryLinearEquation(int n){
        long res = 0;
        for (int z = 0; z <= n / 3; ++z){
            res += (n - 3 * z) / 2 + 1;
        }
        return res;
    }
}
