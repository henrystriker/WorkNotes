package com.javab1.week6;

import java.util.ArrayList;
import java.util.Scanner;

// Main
public class InverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long res = inverseNumber(num);
        System.out.println(res);
        sc.close();
    }

    static long inverseNumber(long num){
        if (num == 0) {
            return 0;
        }
        boolean isNegative = false;
        if (num < 0){
            isNegative = true;
            num = -num;
        }
        long res = 0;
        ArrayList<Long> resList = new ArrayList<>();
        long ans = num / 10;
        resList.add(num % 10);
        while (ans > 0){
            resList.add(ans % 10);
            ans /= 10;
        }
        ans = 1;
        for (int i = resList.size() - 1; i >= 0; --i){
            res += ans * resList.get(i);
            ans *= 10;
        }
        if (isNegative){
            res = -res;
        }
        return res;
    }
}
