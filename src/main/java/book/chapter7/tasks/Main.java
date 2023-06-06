package book.chapter7.tasks;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /*
         * [1]
         * С помощью каррирования реализовать функцию сложения двух чисел,
         * функцию проверки строки на регулярное выражение, функцию разбиения
         * строки по регулярному выражению
         * */

        IntFunction<IntFunction<Integer>> add = x -> y -> x + y;
        int result = add.apply(5).apply(3);
        System.out.println(result);

        String regex = "\\s";
        Consumer<String> consumer1 = s -> System.out.println(Arrays.toString(s.split(regex)));
        consumer1.accept("Hello world");


    }
}
