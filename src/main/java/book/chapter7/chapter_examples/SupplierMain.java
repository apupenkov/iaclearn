package book.chapter7.chapter_examples;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<String> supplierNumber = plus(1.123450989f, 2.000001f);
        System.out.println("res = " + supplierNumber.get());
        Supplier<String> supplierTime = buildTime("yyyy-MM-dd HH:mm:ss");
        System.out.println("time = " + supplierTime.get());
    }

    static Supplier<String> buildTime(String timePattern) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
        return () -> timeFormatter.format(LocalDateTime.now());
    }

    static Supplier<String> plus(float a, float b) {
        BigDecimal decimal = new BigDecimal(a);
        BigDecimal decimal1 = new BigDecimal(b);
        BigDecimal res = decimal.add(decimal1, MathContext.DECIMAL32);
        return () -> res.toEngineeringString();
    }
}
