package com.javab1.week6;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Main
public class MininalInterception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] heightArr = new int[n];
            for (int i = 0; i < n; ++i){
                heightArr[i] = sc.nextInt();
            }
            int res = minimalDeSeq(n, heightArr);
            System.out.println(res);
        }
        sc.close();
    }

    static int minimalDeSeq(int n, int[] arr){
        if (n < 1){
            return 0;
        }
        int count = 1;
        List<Integer> minArr = new LinkedList<>();
        minArr.add(arr[0]);
        for (int i = 1; i < n; ++i){
            boolean isInter = false;
            for (int j = 0; j < count; ++j){
                if (minArr.get(j) >= arr[i]){
                    isInter = true;
                    minArr.set(j, arr[i]);
                    break;
                }
            }
            if (!isInter){
                count++;
                for (int j = 0; j < count - 1; ++j){
                    if (arr[i] <= minArr.get(j)){
                        minArr.add(j, arr[i]);
                        break;
                    }
                }
                if (count > minArr.size()){
                    minArr.add(arr[i]);
                }
            }
        }
        return count;
    }
}
