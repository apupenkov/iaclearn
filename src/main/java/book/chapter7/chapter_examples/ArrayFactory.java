package book.chapter7.chapter_examples;

import java.util.function.Supplier;

public class ArrayFactory {
    public static Supplier<int[]> buildArray(int size) {
        final int length = size > 0 ? size : 1;
        return () -> new int [length];
    }
}
