package com.javab1.week3;

import java.util.Scanner;

// Main
public class BusinessBattle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String google = sc.nextLine();
        String apple = sc.nextLine();
        int result = minCharCountModify(google, apple);
        System.out.println(result);
    }

    static int minCharCountModify(String google, String apple){
        if (google.length() < apple.length()){
            return 0;
        }
        char[] googleArray = google.toCharArray();
        char[] appleArray = apple.toCharArray();
        int count = 0;
        for (int i = 0; i < googleArray.length; ++i){
            int w = i;
            int j = 0;
            if (googleArray[i] == appleArray[j]){
                for (j = 1, ++i; i < googleArray.length && j < appleArray.length; ++j){
                    if (googleArray[i] == appleArray[j]){
                        ++i;
                    } else {
                        i = w;
                        break;
                    }
                }
                if (j == appleArray.length){
                    --i;
                    ++count;
                }
            }
        }
        return count;
    }
}
