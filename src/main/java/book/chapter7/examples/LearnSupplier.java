package book.chapter7.examples;

import java.util.function.Supplier;

public class LearnSupplier {
    public static void main(String[] args) {
        Supplier<StringBuilder> supplier = () -> new StringBuilder("java");
        StringBuilder builder = supplier.get();
        Supplier<int[]> supplier1 = () -> new int[10];
        int[] arr = supplier1.get();

        int[] array = ArrayFactory.buildArray(10).get();
    }
}
