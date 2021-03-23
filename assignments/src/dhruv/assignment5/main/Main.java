package dhruv.assignment5.main;

import dhruv.assignment5.data.DataClass;
import dhruv.assignment5.singleton.SingletonClass;

public class Main {

    public static void main(String[] args) {
        DataClass dc = new DataClass();
        dc.printFieldVariables();

        SingletonClass sc = new SingletonClass();
        sc.StringPrinter();
        sc.ReturnClassObject("Hello");
    }
}
