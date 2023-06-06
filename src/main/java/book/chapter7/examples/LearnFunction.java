package book.chapter7.examples;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LearnFunction {
    public static void main(String[] args) {
        Function<String, Integer> fun1 = s -> s.length();
        Function<Integer, String> fun2 = i -> Integer.toBinaryString(i);

        System.out.println(fun1.apply("internazionalization"));
        System.out.println(fun2.apply(20));

        String[] arrayStr = {"as", "a", "the", "d", "on", "and"};
        System.out.println(Arrays.stream(arrayStr)
                .map(fun1)
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .map(s -> s.length())
                .collect(Collectors.toList()));

        Function<Integer, Integer> fun3 = fun1.compose(fun2);
        // or
        // Function<Integer, Integer> fun3 = fun1.compose(i -> Integer.toBinaryString(i));
        System.out.println(fun1.compose(fun2).apply(17));

        int[] arrayInt = { 1, 3, 5, 9, 17, 33, 65 };
        System.out.println(Arrays.stream(arrayInt)
                .boxed()
                .map(fun1.compose(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayInt)
                .boxed()
                .map(((Function<String, Integer>)s -> s.length())
                        .compose(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        Function<String, String> fun4 = fun1.andThen(fun2);
        // or
        // Function<String, String> fun4 = fun1.andThen(i -> Integer.toBinaryString(i))

        System.out.println(fun1.andThen(fun2).apply("java"));

        System.out.println(Arrays.stream(arrayStr)
                .map(fun1.andThen(fun2)) // or .map(fun1.andThen(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        // or
        System.out.println(Arrays.stream(arrayStr)
                .map(((Function<String, Integer>)s -> s.length()).andThen(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        UnaryOperator<Integer> operator = i -> ++i;
        System.out.println(operator.apply(1));

        BiFunction<Double, String, Integer> bi = (d, s) -> (Double.toString(d) + s).length();
        int length = bi.apply(1.23, "java");
        System.out.println(length);

        BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2.toUpperCase();
        System.out.println(binaryOperator.apply("Oracle", "epam"));
    }
}
