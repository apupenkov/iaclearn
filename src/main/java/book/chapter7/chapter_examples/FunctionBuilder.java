package book.chapter7.chapter_examples;

import java.util.function.Function;

public class FunctionBuilder<T> {
    public static Function<String, Integer> build(String strNum) {
        int count = 1;
        return t -> {
            int res = Integer.valueOf(strNum + t) + count;
            return res;
        };
        // return t -> Integer.valueOf(strNum + t) + count;
    }
}
