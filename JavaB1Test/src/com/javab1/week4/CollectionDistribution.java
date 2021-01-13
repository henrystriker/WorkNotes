package com.javab1.week4;

import java.util.ArrayList;
import java.util.Scanner;

// Main
public class CollectionDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> resList = new ArrayList<>();
        while (true){
            String nl = sc.nextLine();
            if (nl.equals("")){
                break;
            }
            int n = Integer.parseInt(nl);
            long res = calcSubCollection(n);
            resList.add(res);
        }
        for (Long aLong : resList) {
            System.out.println(aLong);
        }
        sc.close();
    }

    static long calcSubCollection(int n){
        if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else if (n == 3){
            return 5;
        }
        long sum = 2;
        for (int i = 2; i < n - 1; ++i){
            sum += (calcC(n, i) + calcC(n, i) * (calcSubCollection(n - i) - 1) / (n / i));
        }
        sum += calcC(n, n - 1);
        return sum;
    }

    static long calcC(int n, int m){
        long res = 1;
        for (int i = 1; i <= m; ++i){
            res *= n;
            res /= i;
            --n;
        }
        return res;
    }
}

/*
    F1: 1
    F2: 1+1
    F3: 1+C32+1
    F4: 1+C42+C42*C(4-2)2/2+C43+1       F6: 1+C42+C42*(F2-1)/2+C43+1
    F5: 1+C52+C52*C(5-2)2/2+C53+C53*C(5-3)2/2+C54+1      F5: 1+C52+C52*(F3-1)/2+C53+C53*(F2-1)/1+C54+1
    F6: 1+C62+C62*C(6-2)2/2+C62*C(6-2)2/2/3+C63++C64+C64*C(6-4)2+C65+1     F6: 1+C62*F4/3+C63*F3/2+C64*F2/1+C65+1
    Fn: 1+Cn2*F(n-2)/(n-3)+Cn3*F(n-3)/(n-4)+......+Cn(n-2)*F2/1+Cn(n-1)+1
    Fn: 1+Cn2*F(n-2)/(n-3)+Cn3*F(n-3)/(n-4)+......+Cn(n-2)*F2/1+Cn(n-1)+1+Cn2+Cn3+......Cn(n-1)+1
 */
