package com.javab1.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Main
public class PhoneList {

    static String[] strArray = new String[10000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] resArray = new String[t];
        for (int i = 0; i < t; ++i){
            int n = sc.nextInt();
            for (int j = 0; j < n; ++j){
                strArray[j] = sc.next();
            }
            resArray[i] = hasSub(0, n);
        }
        for (int i = 0; i < t; ++i){
            System.out.println(resArray[i]);
        }
        sc.close();
    }

    static String hasSub(int start, int end){
        Arrays.sort(strArray, start, end, new LengthComparator());
        for (int i = 0; i < end - 1; ++i){
            if (isSub(i, i + 1)){
                return "NO";
            }
        }
        return "YES";
    }

    static class LengthComparator implements Comparator<String>{
        public int compare(String a, String b){
            return a.compareTo(b);
        }
    }

    static boolean isSub(int i, int j){
        for (int k = 0; k < strArray[i].length(); ++k){
            if (strArray[i].charAt(k) != strArray[j].charAt(k)){
                return false;
            }
        }
        return true;
    }

//    static String hasSub(int n){
//        for (int i = 0; i < n; ++i){
//            for (int j = 0; j < n; ++j){
//                if (j != i && strArray[i].length() <= strArray[j].length() && isSub(i, j)){
//                    return "NO";
//                }
//            }
//        }
//        return "YES";
//    }
//
//    static boolean isSub(String strA, String strB){
//        char[] aArray = strA.toCharArray();
//        char[] bArray = strB.toCharArray();
//        for (int i = 0; i < aArray.length; ++i){
//            if (aArray[i] != bArray[i]){
//                return false;
//            }
//        }
//        return true;
//    }
}
