package book.chapter10.chapter_examples.read_from_stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadStringFilesReadAllLinesMain {
    public static void main(String[] args) {
        String dirName = "data";
        String filename = "res.txt";
        Path path = FileSystems.getDefault().getPath(dirName, filename);
        try { // java7
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
