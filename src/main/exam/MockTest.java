package main.exam;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author 李智
 * @date 2017/4/30
 */
public class MockTest {
    public static void main(String[] args) {
        try {
            PrintStream printStream = new PrintStream(System.out);
            printStream.println("good Boy");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
