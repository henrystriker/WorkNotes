package com.javab1.week5;

import java.util.ArrayList;
import java.util.Scanner;

// Main
public class SplitMaxDot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> resList = fun(n);
        for (int res : resList) {
            System.out.print(res + " ");
        }
        sc.close();
    }

    static ArrayList<Integer> fun(int n){
        ArrayList<Integer> resList = new ArrayList<>();
        int i = 2;
        while (n - i >= 0) {
            n = n - i;
            resList.add(i);
            i++;
        }
        int len = resList.size();
        for (int j = len - 1; j >= 0; j--){
            if (n > 0){
                n--;
                resList.set(j, resList.get(j) + 1);
            } else {
                break;
            }
        }
        if (n > 0){
            resList.set(len - 1, resList.get(len - 1) + 1);
        }
        return resList;
    }
}
