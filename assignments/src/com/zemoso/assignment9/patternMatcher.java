package com.zemoso.assignment9;

import java.util.Scanner;
import java.util.regex.Pattern;

public class patternMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        boolean b = Pattern.matches("[A-Z].+[.]", sentence);
        System.out.println(b);
    }
}
