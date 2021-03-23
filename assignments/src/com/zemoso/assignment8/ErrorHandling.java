package com.zemoso.assignment8;

import java.util.Scanner;

public class ErrorHandling {

    public static void main(String[] args) {
        try {
            methodThrowsError();
        } catch (Exception e) {
            System.out.println("Error");
        }
        finally{
            System.out.println("Finally block executes");
        }

    }

    public static void methodThrowsError(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. ErrorOne is Thrown \n" +
                "2. ErrorTwo is Thrown \n" +
                "3. ErrorThree is Thrown\n" +
                "Default: NullPointerException");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                throw new ErrorOne();
            case 2:
                throw new ErrorTwo();
            case 3:
                throw new ErrorThree();
            default:
                throw new NullPointerException();

        }
    }

    public static class ErrorOne extends RuntimeException {}
    public static class ErrorTwo extends RuntimeException {}
    public static class ErrorThree extends RuntimeException {}
}
