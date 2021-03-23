package com.zemoso.assignment11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class characterCounter {
    private static HashMap<Character, Integer> letterFrequency = new HashMap<>();
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        initHashMap();
        readFileAndCountCharacters();
        writeToFile();
    }

    private static void initHashMap(){
        char[] alphabetLetters = alphabet.toCharArray();
        for(char c : alphabetLetters)
            letterFrequency.putIfAbsent(c, 0);
    }

    private static void readFileAndCountCharacters() {
        try {
            File fileObject = new File("/home/dhrkp/javaAssignments/assignments/src/com/zemoso/assignment11/test.txt");
            Scanner fileText = new Scanner(fileObject);
            while (fileText.hasNextLine())
                countingCharacters(fileText);
            fileText.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void countingCharacters(Scanner myReader) {
        String data = myReader.nextLine();
        char[] inputStringLetters = data.toCharArray();
        for(char c: inputStringLetters){
            if(alphabet.contains(String.valueOf(c)))
                letterFrequency.put(c, letterFrequency.get(c) + 1);
        }
    }

    private static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("/home/dhrkp/javaAssignments/assignments/src/com/zemoso/assignment11/result.txt");
            myWriter.write(letterFrequency.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
