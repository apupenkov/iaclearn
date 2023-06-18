package book.chapter11.chapter_examples.learn_stream_api;

import book.chapter11.chapter_examples.entity.Order;
import book.chapter11.chapter_examples.learn_iterator.OrderType;

import java.util.*;
import java.util.stream.Collectors;

public class LearnStream {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(231, 12.));
                add(new Order(289, 29.));
                add(new Order(747, 32.));
                add(new Order(517, 18.));
                add(new Order(414, 17.));
                add(new Order(777, 10.));
            }
        };

        final int controlAmount = 20;
        final int discountPercent = 10;

        // поиск, удаление, изменение элементов списка с помощью stream
        List<Order> orderList = orders.stream()
                .filter(o -> o.getAmount() <= controlAmount)
                .map(o -> { o.setAmount(o.getAmount() * (100 - discountPercent) / 100);
                    return o; })
                .collect(Collectors.toList());

        // Ошибочное использование stream;
//        List<String> strings = Arrays.asList("Hello", "word", "!");
//        Stream<String> stream = strings.stream();
//        stream.findFirst();
//        stream.filter(String::isBlank).findAny();
        // будет сгенерировано исключение IllegalStateException

        // получение stream из коллекции
        List<String> strs = List.of(" as a the d on and".split("\\s+"));
        strs.stream();
        // фильтрация:
        strs.stream()
                .filter(s -> s.length() < 2)
                .forEach(s -> System.out.print(s + " "));

        strs.stream()
                .map(s -> s.length())
                .forEach(s -> System.out.print(s + " "));

        strs.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        // преобразование списка
        OrderType type1 = new OrderType(771);
        type1.add("SEK");
        type1.add("DDK");
        type1.add("NOK");
        type1.add("EUR");

        OrderType type2 = new OrderType(779);
        type2.add("SEK");
        type2.add("PLN");
        type2.add("CZK");
        type2.add("EUR");

        List<OrderType> orderTypes = List.of(type1, type2);

        List<String> currencyList =
                orderTypes.stream()
                        .map(o -> o.getCurrencyNames())
                        .flatMap(o -> o.stream())
                        .collect(Collectors.toList());
        System.out.println(currencyList);

        System.out.println();
        currencyList.stream()
                .map(String::length)
                .peek(s -> System.out.print(s + "-"))
                .map(n -> n + 100)
                .forEach(s -> System.out.print(s + " "));


        List<String> strings = List.of("a and as d on the".split("\\s+"));
        strings.stream()
                .sorted()
                .forEach(s -> System.out.print(s = " "));

        strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
//                .sorted(Comparator.comparingInt(String::length)) // идентично
                .forEach(s -> System.out.print(s + " "));

        strings.stream()
                .limit(3)
                .forEach(s -> System.out.println());

        strings.stream().skip(4).forEach(System.out::println);

        strings.stream().distinct().forEach(System.out::println);

        String firstStr = strings.stream()
                .filter(s -> s.matches("a\\w*"))
                .findFirst()
                .orElse("none");
        System.out.println(firstStr);

        String anyStr = strings.stream()
                .filter(s -> s.matches("an[a-z]"))
                .findAny()
                .orElse("none");
        System.out.println(anyStr);

        long count = strings.stream()
                .filter(s -> s.matches("a\\w*"))
                .count();
        System.out.println(count);

        boolean res1 = strings.stream()
                .allMatch(s -> s.startsWith("a")); // false

        boolean res2 = strings.stream()
                .anyMatch(s -> s.startsWith("a")); // true

        boolean res3 = strings.stream()
                .noneMatch(s -> s.endsWith("z"));

        int sumLength = strings.stream()
                .map(s -> s.length())
                .reduce(0, (n1, n2) -> n1 + n2); // 12

        int sum = strings.stream()
                .reduce(0, (identity, v) -> v.length() + identity, Integer::sum);

        Map<String, Integer> map = Arrays.stream("as a the d on and".split("\\s+"))
                .collect(Collectors.toMap(s -> s, s -> s.length()));

        String min = strings.stream()
                .min(Comparator.comparingInt(s -> s.charAt(s.length() - 1)))
                .orElse("none");
        System.out.println(min);

        String max = strings.stream()
                .max(Comparator.comparingInt(Action::sumCharCode))
                .orElse("empty");


    }
}

class Action {
    public static int sumCharCode(String str) {
        return str.codePoints().reduce(0, Integer::sum);
    }
}