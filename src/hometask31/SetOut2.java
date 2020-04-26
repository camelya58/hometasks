package hometask31;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SetOut2 {
    public static void main(String[] args) {
        PrintStream usual = System.out;
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        PrintStream myPrint = new PrintStream(array);
        System.setOut(myPrint);
        printSomething();
        String result = array.toString().toUpperCase();
        System.setOut(usual);
        System.out.println(result);
    }

        public static void printSomething() {
            System.out.println("it's a text for testing");
        }
}
