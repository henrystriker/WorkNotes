package com.javab1.week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main
public class NoReturnRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> resList = new ArrayList<>();
        while (true){
            int[] inputArr = new int[4];
            for (int i = 0; i < 4; ++i){
                inputArr[i] = sc.nextInt();
            }
            if (inputArr[0] == 0 && inputArr[1] == 0 &&
                    inputArr[2] == 0 && inputArr[3] == 0){
                break;
            }
            resList.add(canEscape(inputArr));
        }
        for (String res : resList) {
            System.out.println(res);
        }
        sc.close();
    }

    static String canEscape(int[] arr){
        if (arr[0] < arr[1]){
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
        if (arr[2] < arr[3]){
            int temp = arr[2];
            arr[2] = arr[3];
            arr[3] = temp;
        }
        if (arr[0] > arr[2] && arr[1] >arr[3]){
            return "Escape is possible.";
        }
        return "Box cannot be dropped.";
    }
}
