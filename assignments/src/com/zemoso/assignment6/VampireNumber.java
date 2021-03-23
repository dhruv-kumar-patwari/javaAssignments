package com.zemoso.assignment6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VampireNumber {

    private static int lengthOfFangs;

    public static void main(String[] args) {
        int count = 0;
        int enteredNumber = 1000;
        while(count < 10){
            if(isVampireNumber(String.valueOf(enteredNumber))){
                System.out.println(enteredNumber);
                count++;
            }
            enteredNumber++;
        }
    }

    private static boolean isVampireNumber(String enteredNumber) {
        if(isLengthOddOrEqualToTwo(enteredNumber))
            return false;
        else{
            lengthOfFangs = enteredNumber.length()/2;
            Set<String> permutations = permutationFinder(enteredNumber);
            for(String number : permutations){
                String possibleFang1 = number.substring(0, lengthOfFangs);
                String possibleFang2 = number.substring(lengthOfFangs);
                if(isFirstNumberZero(possibleFang1, possibleFang2))
                    continue;
                else if(isLastDigitInBothNumbersZero(possibleFang1, possibleFang2))
                    continue;
                else {
                    int numberA = Integer.parseInt(number.substring(0, lengthOfFangs));
                    int numberB = Integer.parseInt(number.substring(lengthOfFangs));
                    if (numberB * numberA == Integer.parseInt(enteredNumber)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isLengthOddOrEqualToTwo(String enteredNumber) {
        return enteredNumber.length() %2 != 0 || enteredNumber.length() == 2;
    }

    public static Set<String> permutationFinder(String str) {
        Set<String> permutations = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                permutations.add(charInsert(strNew, initial, i));
            }
        }
        return permutations;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    private static boolean isLastDigitInBothNumbersZero(String A, String B) {
        return A.charAt(lengthOfFangs - 1) == '0' && B.charAt(lengthOfFangs - 1) == '0';
    }

    private static boolean isFirstNumberZero(String a, String b) {
        return a.charAt(0) == '0' || b.charAt(0) == '0';
    }

}
