package com.zemoso.assignment7;

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

interface Interface3 {
    void method3();
}

interface Interface4 extends Interface1,Interface2,Interface3 {
    void method4();
}

class ConcreteClass {
    void method5() {
        System.out.println("Method5 in concrete class");
    }
}

class Part3 extends ConcreteClass implements Interface4{
    public void method1() {
        System.out.println("Method1");
    }

    public void method2() {
        System.out.println("Method2");
    }

    public void method3() {
        System.out.println("Method3");
    }

    public void method4() {
        System.out.println("Method4");
    }

    public void method6(Interface1 I) {
        I.method1();
    }

    public void method7(Interface2 I) {
        I.method2();
    }

    public void method8(Interface3 I) {
        I.method3();
    }

    public void method9(Interface4 I) {
        I.method1();
        I.method2();
        I.method3();
        I.method4();
    }
}
