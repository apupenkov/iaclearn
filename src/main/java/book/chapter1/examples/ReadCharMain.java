package book.chapter1.examples;

import java.io.IOException;

public class ReadCharMain {
    public static void main(String[] args) {
        int x;
        try {
            x = System.in.read();
            char c = (char) x;
            System.out.println("Character Code: " + c + " = " + x);
        } catch (IOException e) {
            System.err.println("i\\o error" + e);
        }
    }
}
