package com.javab1.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main
public class BigIntegerAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String result = bigIntegerAdd(a, b);
        System.out.println(result);
    }

    static String bigIntegerAdd(String a, String b){
        StringBuilder sb = new StringBuilder();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int lenA = aArray.length;
        int lenB = bArray.length;
        int temp = 0;
        int numA, numB, num;
        List<Integer> numList = new ArrayList<>();
        for (int i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0; --i, --j){
            if (i < 0){
                numB = Character.getNumericValue(bArray[j]);
                num = (numB + temp) % 10;
                temp = (numB + temp) / 10;
            } else if (j < 0){
                numA = Character.getNumericValue(aArray[i]);
                num = (numA + temp) % 10;
                temp = (numA + temp) / 10;
            } else {
                numA = Character.getNumericValue(aArray[i]);
                numB = Character.getNumericValue(bArray[j]);
                num = (numA + numB + temp) % 10;
                temp = (numA + numB + temp) / 10;
            }
            numList.add(num);
        }
        if (temp > 0){
            numList.add(temp);
        }
        int start = numList.size() - 1;
        for (; start > 0; --start){
            if (numList.get(start) != 0){
                break;
            }
        }
        for (; start >= 0; --start){
            sb.append(numList.get(start));
        }
        return sb.toString();
    }
}
