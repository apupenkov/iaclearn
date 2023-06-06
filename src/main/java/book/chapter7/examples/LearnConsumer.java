package book.chapter7.examples;

import java.util.Arrays;
import java.util.function.Consumer;

public class LearnConsumer {
    public static void main(String[] args) {
        String str = "as a- the-d -on and";
        String regex = "-";
        String regex1 = "\\s";

        Consumer<String> consumer = s -> System.out.println(Arrays.toString(s.split(regex)));
        Consumer<String> consumer1 = s -> System.out.println(Arrays.toString(s.split(regex1)));

        consumer.accept(str);
        consumer1.accept(str);

        Consumer<String> consumer2 = s -> Arrays.toString(s.split(regex1));
        String regex2 = "a";
        Consumer<String> consumer3 = consumer2
                .andThen(s -> System.out.println(Arrays.toString(s.split(regex2))));
        consumer3.accept(str);

        
    }
}
