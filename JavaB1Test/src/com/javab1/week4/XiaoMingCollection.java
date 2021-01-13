package com.javab1.week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main
public class XiaoMingCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] resArray = new int[t];
        for (int i = 0; i < t; ++i){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nArr = new int[n];
            int[] mArr = new int[m];
            for (int j = 0; j < n; ++j){
                nArr[j] = sc.nextInt();
            }
            for (int j = 0; j < m; ++j){
                mArr[j] = sc.nextInt();
            }
            resArray[i] = similarCollection(nArr, mArr, n, m);
        }
        for (int i = 0; i < t; ++i){
            System.out.println(resArray[i]);
        }
        sc.close();
    }

    static int similarCollection(int[] nArray, int[] mArray, int n, int m){
        int sameCount = 0;
        int differentCount = 0;
        Map<Integer, Boolean> arrayMap = new HashMap<>();
        for (int i = 0; i < m; ++i){
            arrayMap.put(mArray[i], false);
            differentCount++;
        }
        for (int i = 0; i < n; ++i){
            if (!arrayMap.containsKey(nArray[i])){
                //arrayMap.put(nArray[i], false);
                differentCount++;
            } else {
                //arrayMap.replace(nArray[i], true);
                differentCount--;
                sameCount++;
            }
        }
        return sameCount * 100 / (sameCount + differentCount);
    }
}
