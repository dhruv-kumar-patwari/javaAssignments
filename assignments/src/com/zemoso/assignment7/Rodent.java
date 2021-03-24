package com.zemoso.assignment7;

public abstract class Rodent {
    abstract void eat();
}

class Mouse extends Rodent {
    public Mouse(){
        System.out.println("This is Mouse");
    }
    @Override
    void eat() {
        System.out.println("Mouse eating");
    }
}

class Gerbil extends Rodent {
    public Gerbil() {
        System.out.println("This is Gerbil");
    }
    @Override
    void eat() {
        System.out.println("Gerbil eating");
    }
}
class Hamster extends Rodent {
    public Hamster() {
        System.out.println("This is Hamster");
    }
    @Override
    void eat() {
        System.out.println("Hamster eating");
    }
}