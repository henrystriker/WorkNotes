package com.javab1.week9;

import java.util.Scanner;

// Main
public class InverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        inverseArray(arr, n);
        System.out.print(arr[0]);
        for (int i = 1; i < n; ++i){
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        sc.close();
    }

    static void inverseArray(int[] arr, int n){
        for (int i = 0; i < n / 2; ++i){
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}
