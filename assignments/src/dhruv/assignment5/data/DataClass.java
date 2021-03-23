package dhruv.assignment5.data;

public class DataClass {
    private int testInt;
    private char testChar;
    public void printFieldVariables(){
        System.out.println(testInt +" \t"+ testChar);
    }
    //The following section of the code does not work because the local variables in Java need to be initialized.
 /*
    public void printLocalVariables(){
        int localInt;
        char localChar;
        System.out.println(localInt +" \t"+ localChar);
    }
 */
}
