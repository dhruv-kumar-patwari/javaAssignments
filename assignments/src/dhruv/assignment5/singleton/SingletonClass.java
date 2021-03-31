package dhruv.assignment5.singleton;

public class SingletonClass {
    private String testVariable = "Hello";

    public static SingletonClass ReturnClassObject(String parameter){
//        Static method cannot access or change non static member variables.
//        testVariable = parameter;
        SingletonClass sc = new SingletonClass();
        sc.testVariable = "test text";
        return sc;
    }

    public void StringPrinter(){
        System.out.println(testVariable);
    }
}
