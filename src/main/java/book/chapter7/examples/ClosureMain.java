package book.chapter7.examples;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ClosureMain {
    public static void main(String[] args) {
        Function<String, Integer> function = FunctionBuilder.build("100");
        int res = function.apply("77");
        System.out.println(res);

        Function<Order, Long> function1 = o -> o.getOrderId();
        // or
        // function = Order::getOrderId;

        // other example:
        Consumer<String> consumer = s -> System.out.println(s);
        // or
        // consumer = System.out::println;

        // for static methods:
        BiFunction<Double, Double, Double> biFunction = Math::hypot;
        // equals:
        // biFunction = (x, y) -> Math.hypot(x, y);

        Comparator<Long> comparator = (l1, l2) -> l1.compareTo(l2);
        // comparator = Long::compareTo;

        Supplier<StringBuilder> supplier = StringBuilder::new;

        
    }
}
