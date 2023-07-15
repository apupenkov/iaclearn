package book.chapter10.chapter_examples.read_from_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStringBufferedReaderMain {
    public static void main(String[] args) {
        StringBuilder stringLines = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/res.txt"))) {
            String tmp;
            while ((tmp = reader.readLine()) != null) { // java 2
                stringLines.append(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringLines);
    }
}
