package com.javab1.week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Main
public class IntegerOddEvenSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; ++i){
            arr[i] = sc.nextInt();
        }
        int[] resArr = oddEvenSort(arr);
        System.out.print(resArr[0]);
        for (int i = 1; i < 10; ++i){
            System.out.print(" " + resArr[i]);
        }
        System.out.println();
        sc.close();
    }

    static int[] oddEvenSort(int[] arr){
        int[] resArr = new int[10];
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < 10; ++i){
            if (arr[i] % 2 == 0){
                evenList.add(arr[i]);
            } else {
                oddList.add(arr[i]);
            }
        }
        Collections.sort(oddList);
        Collections.sort(evenList);
        int oddLen = oddList.size();
        for (int i = 0; i < oddLen; ++i){
            resArr[i] = oddList.get(oddLen - 1 - i);
        }
        for (int i = oddLen; i < 10; ++i){
            resArr[i] = evenList.get(i - oddLen);
        }
        return resArr;
    }
}
