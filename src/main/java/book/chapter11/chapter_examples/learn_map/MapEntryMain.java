package book.chapter11.chapter_examples.learn_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapEntryMain {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Пряник", 5);
        hashMap.put("Кефир", 1);
        hashMap.put("Хлеб", 1);
        hashMap.putIfAbsent("Хлеб", 2);
        hashMap.putIfAbsent("Молоко", 5);
        hashMap.computeIfAbsent("Сырок", v -> 3);
        hashMap.computeIfPresent("Сырок", (k, v) -> 4);
        hashMap.computeIfAbsent("Сырок", v -> 144);
        System.out.println(hashMap);

        hashMap.put("Пряник", 4);
        System.out.println(hashMap + "after replacing the element");
        System.out.println(hashMap.get("Хлеб") + " - found by key 'Хлеб'");
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        System.out.println(entrySet);
        entrySet.stream()
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        Set<Integer> values = new HashSet<Integer>(hashMap.values());
        System.out.println(values);

    }
}
