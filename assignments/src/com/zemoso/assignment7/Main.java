package com.zemoso.assignment7;

public class Main {
    public static void main(String[] args) {
        runPart1();
        runPart2();
        runPart3();
        runPart4();
        runPart5();

    }

    private static void runPart1() {
        Rodent rodents[]=new Rodent[3];
        rodents[0]=new Mouse();
        rodents[1]=new Gerbil();
        rodents[2]=new Hamster();
        for(int i = 0; i<3; i++){
            rodents[i].eat();
        }
    }

    private static void runPart2() {
        Cycle cycles[]=new Cycle[3];
        cycles[0]=new Unicycle();
        cycles[0].balance();
        Unicycle uc = (Unicycle)cycles[0];
        uc.balance();

        cycles[1]=new Bicycle();
        cycles[1].balance();
        Bicycle bc = (Bicycle)cycles[1];
        bc.balance();

        cycles[2]=new Tricycle();
        cycles[2].balance();
        Tricycle tc = (Tricycle)cycles[2];
        tc.balance();

    }

    private static void runPart3() {
        Part3 obj=new Part3();
        obj.method1();
        obj.method2();
        obj.method3();
        obj.method4();
        obj.method5();
        obj.method6(obj);
        obj.method7(obj);
        obj.method8(obj);
        obj.method9(obj);
    }

    private static void runPart4() {
        FactoryCycle cycle1=new FactoryCycle();
        Cycle uni=cycle1.getType("UNICYCLE");
        Cycle bi=cycle1.getType("bicycle");
        Cycle Tri=cycle1.getType("triCycle");
    }

    private static void runPart5() {
        Outer2 newOuter = new Outer2();
        Outer2.Inner3 inner = new Outer2.Inner3();
    }
}
