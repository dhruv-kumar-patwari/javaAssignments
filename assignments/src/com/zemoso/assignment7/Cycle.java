package com.zemoso.assignment7;

public class Cycle {
    void balance() {
        System.out.println("Balance method in Cycle class");
    }
}

class Unicycle extends Cycle{
    void balance() {
        System.out.println("Balance in Unicycle");
    }
}

class Bicycle extends Cycle{
    void balance(){
        System.out.println("Balance in Bicycle");
    }
}

class Tricycle extends Cycle {
}

class FactoryCycle {
    public Cycle getType(String type) {
        if(type==null) return null;
        if(type.equalsIgnoreCase("Unicycle"))
            return new Unicycle();
        if(type.equalsIgnoreCase("Bicycle"))
            return new Bicycle();
        if(type.equalsIgnoreCase("Tricycle"))
            return new Tricycle();
        return null;
    }
}
