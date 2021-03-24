package com.zemoso.assignment10;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class SList<T> {
    static Link head;
    private static boolean isTrue = true;

    private static SListIterator iterator(Link head){
        return new SListIterator(head);
    }

    public static void main(String args[]){
        SList list = new SList();
        head = new Link("Head Link",null);
        SListIterator listIterator = iterator(head);

        performOperations(listIterator);

    }

    private static void performOperations(SListIterator listIterator) {
        isTrue = true;
        while(isTrue){
            System.out.println("1. Add a new link\n" +
                    "2. Remove the last link\n" +
                    "3. Print the list");

            Scanner scan = new Scanner(System.in);
            int response = scan.nextInt();
            switch(response){
                case 1:
                    System.out.println("Enter data: ");
                    listIterator.insert(scan.next());
                    break;
                case 2:
                    listIterator.remove();
                    break;
                case 3:
                    listIterator.iterate();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
    }

}
