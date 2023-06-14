package book.chapter7.examples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");

        // Простое и лёгкое создание потока.
        Stream stream = list.stream();
//        stream.forEach(System.out::println);

        // Пример с потоком.
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120)
                .filter(x -> x < 90).map(x -> x + 10)
                .limit(3).forEach(System.out::println);

        // Пример без потока.

        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) continue;
            x += 10;
            count++;
            if (count > 3) break;
            System.out.println(x);
        }

        // Возможные способы создания Stream
        // Пустой Stream:
        Stream.empty();

        // Stream из List:
        // list.stream();

        // Stream из Map:
        // map.entrySet().stream();

        // Stream из массива:
        // Arrays.stream(array);

        // Stream из указанных элементов:
        Stream.of("1", "2", "3");

        stream.filter(x -> x.toString().length() == 3).forEach(System.out::println);

        String[] array = {"Hello", "Woooooorld"};
        Stream<String> stringStream = Arrays.stream(array);

        // Преобразует в примитивный stream
        stringStream.map(s -> s.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream<String> stringStream1 = Arrays.stream(array);

        // Преобразует в список потоков [stream1,stream2,stream3,stream4] => Stream.of(stream1,stream2,stream3,stream4)
        stringStream1.map(s -> s.split(""))
                .map(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::println);

        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::println);

        // А так же:
        // limit(long maxSize) - ограничивает стрим по количеству элементов
        // skip(long n) - пропускаем n элементво
        // sorted()
        // sorted(Comparator comparator) - сортирует стрим (сортировка как у TreeMap)
        // distinct() - проверяет стрим на уникальность элементов(убирает повторы элементов)
        // dropWhile(Predicate predicate) - пропускает элементы которые удовлетворяют условию (появилось в java 9)

        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(3));
        System.out.println(isPositive.test(-9));

        // https://javarush.com/groups/posts/2203-stream-api
    }
}
