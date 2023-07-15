package book.chapter10.chapter_examples.predefined_standard_streams;

import java.io.*;

public class PrintMain {
    public static void main(String[] args) {
        double[] values = {1.10, 1.2};
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("data/r.txt")))) {
            for (double value : values) {
                writer.printf("Java %.2g%n", value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
