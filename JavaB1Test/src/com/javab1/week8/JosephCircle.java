package com.javab1.week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main
public class JosephCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> resList = new ArrayList<>();
        resList = calcCirclePopNum(n, m);
        System.out.print(resList.get(0));
        for (int i = 1; i < n; ++i){
            System.out.print(" " + resList.get(i));
        }
        System.out.println();
        sc.close();
    }

    static List<Integer> calcCirclePopNum(int n, int m){
        List<Integer> resList = new ArrayList<>();
        boolean[] arr = new boolean[n];
        int index = 0;
        for (int i = 0; i < n; ++i) {
            int j = m;
            if (i == 0){
                j--;
                index++;
            }
            int k = index;
            while (j > 0) {
                if (!arr[index]){
                    j--;
                    k = index;
                }
                if (index == n - 1){
                    index = 0;
                } else {
                    index++;
                }
            }
            arr[k] = true;
            resList.add(k + 1);
        }
        return resList;
    }
}
