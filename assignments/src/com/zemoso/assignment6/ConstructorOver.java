package com.zemoso.assignment6;

import java.util.ArrayList;

public class ConstructorOver {
    String fieldValue;

    public ConstructorOver() {
        this("String to be printed");
        System.out.println("Constructor 1");
    }

    public ConstructorOver(String fieldValue) {
        this.fieldValue = fieldValue;
        System.out.println("Constructor 2");
        System.out.println(fieldValue);
    }

    public static void main(String[] args) {
        ConstructorOver obj1=new ConstructorOver();
        ConstructorOver obj2[]=new ConstructorOver[2];

        obj2[0]=new ConstructorOver("Dhruv");
        obj2[1]=new ConstructorOver("Test");
    }

}
