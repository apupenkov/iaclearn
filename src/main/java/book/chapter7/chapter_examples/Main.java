package book.chapter7.chapter_examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, String> intToString = (num) -> Integer.toString(num);
        System.out.println(intToString.apply(42));

        BiFunction<Integer, Integer, Integer> summ = (a, b) -> a + b;
        System.out.println(summ.apply(5, 7));

        Function<Integer, Function<Integer, Integer>> add = (x) -> (y) -> x + y;
        System.out.println(add.apply(5).apply(7));

        Function<Integer, Function<Integer, Integer>> add1 = curryAdd();
        int result = add1.apply(3).apply(5);
        System.out.println(result);
    }

    private static Function<Integer, Function<Integer, Integer>> curryAdd() {
        return (x) -> (y) -> x + y;
    }
}
