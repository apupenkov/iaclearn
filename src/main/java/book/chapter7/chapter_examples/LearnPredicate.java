package book.chapter7.chapter_examples;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LearnPredicate {
    public static void main(String[] args) {

        // Predicate - functional interface
        Predicate<String> predicateStr1 = s -> s.length() < 2;
        Predicate<String> predicateStr2 = String::isBlank; // eq.// s -> s.isBlank();
        Predicate<Integer> predicateInt = i -> i >= 9;

//        System.out.println(predicateStr1.test("java"));
//        System.out.println(predicateStr2.test(" "));
//        System.out.println(predicateInt.test(16));

        String[] arrayStr = {"as", "a", "the", " ", "d", "on", "and", ""};
        System.out.println(Arrays.stream(arrayStr)
                .filter(s -> s.length() > 2)
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr).anyMatch(String::isBlank));
        int[] arrayInt = {1, 3, 5, 9, 17, 33, 65};
        System.out.println(Arrays.stream(arrayInt).allMatch(i -> i >=1));

        Predicate<String> predicate1 = s -> s.contains("a");
        System.out.println(Arrays.stream(arrayStr)
                .filter(predicate1.and(s -> s.contains("n")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>) s -> s.contains("a")).and(s -> s.contains("n")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayInt)
                .filter(((IntPredicate) i -> i > 32).or(i -> i < 4))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>)s -> s.contains("and")).negate())
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.not(s -> s.contains("and")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.isEqual("and"))
                .collect(Collectors.toList()));

        BiPredicate<String, Integer> biPredicate = (s, max) -> s.length() <= max;
        System.out.println(biPredicate.test("java", 7));
    }
}
