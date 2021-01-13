package com.javab1.week6;

import java.util.Scanner;

// Main
public class Decode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] codeArr = new int[n];
            for (int i = 0; i < n; ++i){
                codeArr[i] = sc.nextInt();
            }
            String res = decode(n, codeArr);
            System.out.println(res);
        }
        sc.close();
    }

    static String decode(int n, int[] codeArr){
        int code = 0;
        for (int j = 0; j < 26; ++j) {
            boolean isCode = true;
            for (int i = 0; i < n; ++i) {
                if ((('A' + j) ^ codeArr[i]) > 'Z' || (('A' + j) ^ codeArr[i]) < 'A'){
                    isCode = false;
                    break;
                }
            }
            if (isCode){
                code = 'A' + j;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; ++k){
            sb.append((char) (codeArr[k] ^ code));
        }
        return sb.toString();
    }
}
