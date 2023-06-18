package book.chapter11.chapter_examples.learn_map;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("jeans", 40);
        map.put("T-Shirt", 35);
        map.put("Gloves", 42);
        map.compute("Shoes", (k, v) -> 77);
        System.out.println(map);

        map.computeIfPresent("Shoes", (k, v) -> v + k.length());
        System.out.println(map);

        map.computeIfAbsent("Shoes", v -> 11);

        map.computeIfAbsent("Shoes_2", v -> 11);
        System.out.println(map);
    }
}
