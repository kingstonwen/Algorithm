package com.company;

import java.util.*;

public class BasicCalculator {

    public static void main(String[] args) {
        // write your code here
        /* LC227. Basic Calculator II
        System.out.println(calculate(new String("-4 - 2")));
         */
        System.out.println(calculate(new String("3 * -2 / -5 * 2")));
        System.out.println(calculate(new String("-132")));
    }

    public static List<List<Integer>> possiblePurchases(int[] A, int[] B, int[] C, int[] D, int budget) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }


    // LC227. Basic Calculator II
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char operator = '+';
        int currentNum = 0, prevNum = 0, result = 0;
        boolean isNegativeInt = false;
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (!Character.isDigit(currentChar) && currentChar != ' ') {
                if (s.charAt(i+1) != ' ') {
                    isNegativeInt = true;
                }
            }
            if (Character.isDigit(currentChar)) {
                currentNum = (currentNum * 10) + (currentChar - '0');
            }
            //cur char is operator or end of string
            if ( (i == n-1) || isOperator(s, i, currentChar)) {
                if (isNegativeInt) {
                    currentNum = 0 - currentNum;
                    isNegativeInt = false;
                }
                if (operator == '+' || operator == '-') {
                    result += prevNum;
                    prevNum = (operator == '+') ? currentNum : -currentNum;
                } else if (operator == '*') {
                    prevNum = prevNum * currentNum;
                } else if (operator == '/') {
                    prevNum = prevNum / currentNum;
                }
                operator = currentChar;
                currentNum = 0;
            }
        }
        result += prevNum;
        return result;
    }

    private static boolean isOperator(String s, int i, char currentChar) {
        return !Character.isDigit(currentChar) && currentChar != ' ' && s.charAt(i+1) == ' ';
    }
}
