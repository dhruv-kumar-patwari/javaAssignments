package com.zemoso.assignment1;

import java.io.File;
import java.util.Scanner;

public class HomeDirectoryCrawler {
    public static void main(String[] args) {
        File directory = new File("/home/dhrkp/"); // Link to the directory to be read
        String[] filesInDir = directory.list();
        String regex;
        while (true){
            System.out.println("Enter regular expression or type q to quit");
            Scanner scanner = new Scanner(System.in);
            regex = scanner.next();
            if(regex.equals("q"))
                break;
            else{
                for (String file: filesInDir){
                    if(file.matches(regex)) // If filename matches with the reqular expression, print the file name
                        System.out.println(file);
                }
            }
        }
    }
}
