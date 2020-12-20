package com.javab1.week2;

import java.util.Scanner;

// Main
public class RockScissorsWrap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int na = sc.nextInt();
        int nb = sc.nextInt();
        int[] patternA = new int[na];
        int[] patternB = new int[nb];
        for (int i = 0; i < na; ++i){
            patternA[i] = sc.nextInt();
        }
        for (int i = 0; i < nb; ++i){
            patternB[i] = sc.nextInt();
        }
        String result = whoWin(n, patternA, patternB, na, nb);
        System.out.println(result);
        sc.close();
    }

    static String whoWin(int n, int[] patternA, int[] patternB, int na, int nb){
        int win = 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; ++k){
            int a, b;
            if (i >= na) {
                i = 0;
            }
            a = patternA[i];
            if (j >= nb) {
                j = 0;
            }
            b = patternB[j];
            if (whoWin(a, b) > 0){
                ++win;
            } else if (whoWin(a, b) < 0){
                --win;
            }
            ++i;
            ++j;
        }
        if (win > 0){
            return "A";
        } else if (win < 0){
            return "B";
        } else {
            return "draw";
        }
    }

    static int whoWin(int a, int b){
        if (a == 0 && b == 5){
            return -1;
        } else if (a == 0 && b == 2){
            return 1;
        } else if (a == 5 && b == 2){
            return -1;
        } else if (a == 5 && b == 0){
            return 1;
        } else if (a == 2 && b == 0){
            return -1;
        } else if (a == 2 && b == 5){
            return 1;
        } else {
            return 0;
        }
    }
}
