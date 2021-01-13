package com.javab1.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Main
public class OddUpArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArr = new int[n];
        for (int i = 0; i < n; ++i){
            numArr[i] = sc.nextInt();
        }
        ArrayList<Integer> resList = oddUpArray(numArr, n);
        System.out.print(resList.get(0));
        for (int i = 1; i < resList.size(); ++i){
            System.out.print("," + resList.get(i));
        }
        System.out.println();
        sc.close();
    }

    static ArrayList<Integer> oddUpArray(int[] arr, int n){
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            if (arr[i] % 2 == 1){
                resList.add(arr[i]);
            }
        }
        Collections.sort(resList);
        return resList;
    }
}
