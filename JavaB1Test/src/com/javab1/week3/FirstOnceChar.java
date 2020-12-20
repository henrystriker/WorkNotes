package com.javab1.week3;

import java.util.HashMap;
import java.util.Scanner;

// Main
public class FirstOnceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String result = firstOnceChar(line);
        System.out.println(result);
    }

    static String firstOnceChar(String line){
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] lineArray = line.toCharArray();
        for (char c : lineArray){
            if (charMap.containsKey(c)){
                charMap.replace(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        for (char c : lineArray){
            if (charMap.get(c) == 1){
                return String.valueOf(c);
            }
        }
        return "no";
    }
}
