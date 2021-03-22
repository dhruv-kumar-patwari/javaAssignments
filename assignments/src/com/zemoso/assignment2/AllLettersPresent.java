package com.zemoso.assignment2;

import java.util.HashMap;
import java.util.Scanner;

public class AllLettersPresent {
    // Space remains constant irrespective of the input size. Hence space complexity is o(1)
    private static HashMap<Character, Integer> letterFrequency = new HashMap<>();
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        inputString = inputString.toLowerCase();
        System.out.println(isAllLettersOfAlphabetPresent(inputString));
    }

    private static boolean isAllLettersOfAlphabetPresent(String inputString) {
        initHashMap();
        char[] inputStringLetters = inputString.toCharArray();
        for(char c: inputStringLetters){ // o(n) here n is the size of the string.
            if(alphabet.contains(String.valueOf(c)))
                letterFrequency.put(c, letterFrequency.get(c) + 1);
        }
        if(letterFrequency.containsValue(0))
            return (false);
        else
            return (true);
    }

    private static void initHashMap(){
        char[] alphabetLetters = alphabet.toCharArray();
        for(char c : alphabetLetters) // o(1) as this is not dependant on the input size.
            letterFrequency.putIfAbsent(c, 0);
    }
}