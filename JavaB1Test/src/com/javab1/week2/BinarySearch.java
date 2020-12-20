package com.javab1.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextLong();
        }
        String[] resultArr = new String[m];
        Arrays.sort(arr);
//        long[] xArr = new long[m];
        for (int i = 0; i < m; ++i){
            long x = sc.nextLong();
//            xArr[i] = sc.nextLong();
            resultArr[i] = binarySearch(arr, n, m, x);
        }
        for (int i = 0; i < m; ++i){
            System.out.println(resultArr[i]);
        }
        sc.close();
    }

//    static String[] binarySearch(long[] arr, int n, int m, long[] xArr){
//        String[] resultArr = new String[m];
//        Map<Long, String> arrMap = new HashMap<>();
//        for (int i = 0; i < n; ++i){
//            if (!arrMap.containsKey(arr[i])){
//                arrMap.put(arr[i], "YES");
//            }
//        }
//        for (int i = 0; i < m; ++i){
//            if (arrMap.containsKey(xArr[i])){
//                resultArr[i] = "YES";
//            } else {
//                resultArr[i] = "NO";
//            }
//        }
//        return  resultArr;
//    }

    static String binarySearch(long[] arr, int s, int e, long x){
        while(s <= e){
            int mid = (s + e) / 2;
            if (x < arr[mid]){
                e = mid - 1;
            } else if (x > arr[mid]){
                s = mid + 1;
            } else {
                return "YES";
            }
        }
        return "NO";
    }
}
