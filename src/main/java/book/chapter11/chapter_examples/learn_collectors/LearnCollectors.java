package book.chapter11.chapter_examples.learn_collectors;

import java.util.*;
import java.util.stream.Collectors;

public class LearnCollectors {
    public static void main(String[] args) {
        List<String> strings = List.of("as a the d on and".split("\\s+"));

        List<Integer> listLengths = strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(listLengths);

        List<Character> listFirstSymb = strings.stream()
                .map(s -> s.charAt(0))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listFirstSymb);

        String result = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" : "));
        System.out.println(result);

        List<Integer> listCode = strings.stream()
                .collect(Collectors.mapping(s -> (int) s.charAt(0), Collectors.toList()));
        System.out.println(listCode);

        int max = strings.stream().map(s -> (int) s.charAt(0)).max(Integer::compareTo)
                .orElse(-1);

        String minLex = strings.stream()
                .collect(Collectors.minBy(String::compareTo))
                .orElse("none");
        System.out.println(minLex);

        List<String> lists = strings.stream()
                .collect(Collectors.filtering(s -> s.length() > 1, Collectors.toList()));
        System.out.println(lists);

        long counter = strings.stream()
                .collect(Collectors.counting());
        System.out.println(counter);

        int length = strings.stream()
                .collect(Collectors.summingInt(String::length));
        System.out.println(length);

        Double averageLength = strings.stream()
                .collect(Collectors.averagingDouble(String::length));
        System.out.println(averageLength);

        int sumCodeFirstChars = strings.stream()
                .map(s -> (int) s.charAt(0))
                .collect(Collectors.reducing(0, (a, b) -> a + b));
        System.out.println(sumCodeFirstChars);

        int productLength = strings.stream()
                .collect(Collectors.reducing(1, s -> s.length(), (s1, s2) -> s1 * s2));
        System.out.println(productLength);

        Map<Integer, List<String>> byLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(byLength);

        Map<Integer, Integer> sumChars = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.summingInt(String::length)));
        System.out.println(sumChars);

        Map<Boolean, List<String>> boolLength = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() < 2));
        System.out.println(boolLength);
    }
}
