package book.chapter7.tasks;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static book.chapter7.tasks.FunctionSolver.*;

public class Main {
    public static void main(String[] args) {
        DevisionThirtyOneWithoutARemainder<Integer, Boolean> result = (a) -> a % 31 == 0;

        int[] numbers = new int[]{1, 5, 100, 47, 31, 62};

        for (int num : numbers) {
            if (result.getResult(num)) {
                System.out.println("The number is divisible by 31");
            }
            else System.out.println("The number is not divisible by 31");
        }

        Discriminant<Double, Double> discriminant = (a, b, c) -> Math.pow(b, 2) - 4 * a * c;

        System.out.println("Discriminant: " + discriminant.result(3.0, -4.0, 2.0));

        // task 5

        LongestLine<String, String> longestLine = (String str1, String str2) -> str1.length() > str2.length() ? str1 : str2;

        System.out.println(longestLine.apply("Hello world", "Hello, world!"));

        // task 10

        BinaryOperator<Integer> max = (x, y) -> x > y ? x : y;
        int maxNumber = max.apply(5, max.apply(6, 3));
        System.out.println("Max number: " + maxNumber);

        // task 11

        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        System.out.println(processString(str, 2, 100, 50));

        // task 12
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] res = processArray(nums);
        System.out.println(Arrays.toString(res));

        // task 13
        int[] nums1 = {5, 2, 8, 1, 9, 3, 7, 4, 6};

        Arrays.stream(nums1).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // task 14
        int n1 = 8;
        System.out.println("Число " + n1 + " является числом Фибоначчи: " + isFibonacciNumber(n1));

        // task 15
        int N = 5;
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            points[i] = new Point(x, y);
        }

        Arrays.sort(points, Comparator.comparingDouble(p -> Math.sqrt(p.x * p.x + p.y * p.y)));

        for (Point point : points) {
            System.out.println("(" + point.x + ":" + point.y + ")");
        }

        // task 16
        int sumOfIntegers = sum(1, 2, 3, 4, 5);
        double sumOfDoubles = sum(1.5, 2.5, 3.5);
        long sumOfLongs = sum(100L, 200L, 300L);

        System.out.println("Сумма целых чисел: " + sumOfIntegers);
        System.out.println("Сумма чисел с плавающей точкой: " + sumOfDoubles);
        System.out.println("Сумма длинных целых чисел: " + sumOfLongs);

        // task 17
        double a = 3.0;
        double b = 4.0;
        double c = 5.0;

        Predicate<Triangle> isTriangle = triplet ->
                (triplet.a + triplet.b > triplet.c) &&
                        (triplet.a + triplet.c > triplet.b) &&
                        (triplet.b + triplet.c > triplet.a);

        Triangle triplet = new Triangle(a, b, c);

        if (isTriangle.test(triplet)) {
            System.out.println("Можно образовать треугольник");
        } else {
            System.out.println("Нельзя образовать треугольник");
        }

        int x = 123536739;
        int digit = 3;

        Function<Integer, Integer> countOccurrences = num -> {
            int count = 0;
            while (num != 0) {
                int remainder = num % 10;
                if (remainder == digit) {
                    count++;
                }
                num /= 10;
            }
            return count;
        };

        int occurrences = countOccurrences.apply(x);
        System.out.println("Количество вхождений цифры " + digit + " в числе " + x + ": " + occurrences);
    }

    // int... - передаётся любое количество переменных.
    private static int sum(int... numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static double sum(double... numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static long sum(long... numbers) {
        return Arrays.stream(numbers).sum();
    }
}
