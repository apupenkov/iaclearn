package book.chapter7.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class CountOccurrencesFromFile {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        try {
            String text = readFile("src/test/resources/CountOccurrencesFromFile.txt");

            BiPredicate<Map<String, Integer>, String> search = Map::containsKey;


            for (String str : text.split("\\W+")) {
                if (search.test(map, str)) {
                    map.put(str, map.get(str) + 1);
                } else map.put(str, 1);
            }

//            Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
//                    .sorted(Map.Entry.comparingByValue());


//            map.forEach((key, value) -> System.out.println(key + ": " + value));
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
}
