package book.chapter10.chapter_examples.read_from_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadStringStreamMain {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/res.txt"));
             Stream<String> stream = reader.lines()) {
            String lines = stream.collect(Collectors.joining());
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
