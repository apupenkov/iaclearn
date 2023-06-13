package book.chapter7.examples;

import java.util.Arrays;
import java.util.Comparator;

public class LearnComparator {
    public static void main(String[] args) {
        String str = "and java course epam the rose lion wolf hero green white red white";

        Comparator<String> comparator = (s1, s2) -> s2.length() - s1.length();

        Arrays.stream(str.split("\\s"))
                .sorted(comparator) // .reversed() - инверсионная процесс сортировки
                .forEach(s -> System.out.printf("%s ", s));

        Arrays.stream(str.split("\\s"))
                .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
                .forEach(s -> System.out.printf("%s ", s));
    }
}
