package com.zemoso.assignment7;

class Outer1 {
    static public class Inner1{
        public Inner1(String name){
            System.out.println(name);
        }
    }

    public class Inner2 {
        public Inner2(String name) {
            System.out.println(name);
        }
    }
}

class Outer2 {
    static class Inner3 extends Outer1.Inner1 {
        public Inner3() {
            super("Inner 3 calling Inner 1 method");
        }
    }

    class Inner4 extends Outer1.Inner2 {
        public Inner4() {
            new Outer1().super("Inner 4 calling Inner 2 method");
        }
    }
}
