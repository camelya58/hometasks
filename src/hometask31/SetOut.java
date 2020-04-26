package hometask31;

import java.io.IOException;
import java.io.PrintStream;

public class SetOut {
    public static void main(String[] args) throws IOException {
        PrintStream usual = System.out;

        PrintStream ps = new PrintStream("OtherFile");
        System.setOut(ps);
        System.out.println("Фраза, не выведенная в консоль, а записанная сразу в файл");

        System.setOut(usual);
        System.out.println("Фраза, выведенная в консоль");
        ps.close();

    }
}
