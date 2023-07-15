package book.chapter10.chapter_examples.byte_chars_streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutMain {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("src/main/java/book/chapter10/chapter_examples/byte_chars_streams/files/out.txt", true)) {
            output.write(48);
            byte[] value = {65, 67, 100};
            output.write(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
