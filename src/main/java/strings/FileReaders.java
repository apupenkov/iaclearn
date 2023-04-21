package strings;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaders {

    public static long getCountLines(String filePath) {
        long lines = 0;
        try {
            lines = Files.lines(Paths.get(filePath)).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String getStringFromFile(String filePath) throws IOException {
        Scanner scanner = new Scanner(Paths.get(filePath), StandardCharsets.UTF_8.name());
        if (scanner.hasNextLine())
            return scanner.nextLine();
        return "";
    }

    public static String[] getStringsFromFile(String filePath) throws IOException {
        Path source = Paths.get(filePath);
        Scanner scanner = new Scanner(source, StandardCharsets.UTF_8.name());
        long lines = 0;

        try {
            lines = Files.lines(source).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strings = new String[(int)lines];

        int index = 0;
        while (scanner.hasNextLine()) {
            strings[index] = scanner.nextLine();
            index++;
        }

        return strings;
    }
}
