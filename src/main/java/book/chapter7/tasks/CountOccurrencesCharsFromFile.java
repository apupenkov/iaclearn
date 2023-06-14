package book.chapter7.tasks;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static book.chapter7.tasks.CountOccurrencesFromFile.readFile;

public class CountOccurrencesCharsFromFile {
    public static void main(String[] args) {
        String filename = "src/test/resources/CountOccurrencesFromFile.txt";

        try {
            String text = readFile(filename);
            Map<Character, Integer> map = new HashMap<>();

            BiConsumer<Map<Character, Integer>, Character> biConsumer = (m, c) -> {
                if (m.containsKey(c)) m.put(c, m.get(c) + 1);
                else m.put(c, 1);
            };

            for (char ch : text.toCharArray()) {
                biConsumer.accept(map, ch);
            }

            map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
