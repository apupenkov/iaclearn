package book.chapter7.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionSolver {
//    Predicate<Boolean> predicate = (String arr1, String arr2) -> arr1.equals(arr2);

    /*
     * [1]
     * С помощью каррирования реализовать функцию сложения двух чисел,
     * функцию проверки строки на регулярное выражение, функцию разбиения
     * строки по регулярному выражению
     * */
    public static Function<Integer, Function<Integer, Integer>> add() {
        return (a) -> (b) -> a + b;
    }

    public static Function<String, Function<String, Boolean>> checkRegex() {
        return (str) -> (regex) -> Pattern.compile(regex).matcher(str).matches();
    }

    public static Function<String, Function<String, String[]>> splitByRegex() {
        return (str) -> (regex) -> str.split(regex);
    }

    /*
    * [2]
    * Определить, являются ли слова анаграммами, т.е. можно ли из одного слова составить другое перестановкой букв.
    * */

    public static void main(String[] args) {

        // Task 1.2
        Function<String, Function<String, Boolean>> checkregex = checkRegex();
        System.out.println(checkRegex().apply("name@gmail.com").apply("^[A-Za-z0-9+_.-]+@(.+)$"));

        // Task 1.3
        Function<String, Function<String, String[]>> splitbyregex = splitByRegex();
        System.out.println(Arrays.stream(splitbyregex
                .apply("Hello world")
                .apply(" "))
                .collect(Collectors.toList()));


        String str1 = "listen";
        String str2 = "silent";

        BiPredicate<String, String> isAnagram = (a, b) ->
                a.length() == b.length() &&
                        a.chars().sorted().mapToObj(ch -> String.valueOf((char) ch))
                                .collect(Collectors.joining())
                                .equals(b.chars().sorted()
                                        .mapToObj(ch -> String.valueOf((char) ch))
                                        .collect(Collectors.joining()));


        System.out.println(isAnagram.test(str1, str2));



    }


    /*
    * [8]
    * Вывести количество вхождений заданного слова в тексте соответственно из файла в виде \[слово1-2, слово2-3, слово3-0].
    * */


    public static int countOccurrences(String text, String word) {
        BiFunction<String[], String, Integer> count = (strings, w) ->
        {
            int i = 0;
            for (String str : strings)
                if (str.equals(w)) i++;
            return i;
        };

        return count.apply(text.split("\\W+"), word);
    }

    /*
    * [11]
    * С помощью лямбда-выражений создать метод, который на вход принимает строку, количество копий N, ограничение на общую
    * длину L. Поставить запятые после каждого слова, сделать N копий, и если слов больше M — не выводить остальные слова.
    * */
    public static String processString(String input, int N, int L, int M) {
        return Arrays.stream(input.split("\\s+"))
                .limit(M)
                .collect(Collectors.joining(", "))
                .concat(", ")
                .repeat(N)
                .substring(0, L);
    }

    /*
    * [12]
    * Создать массив целых чисел. Убрать все четные элементы из массива и заполнить в конце нулями до прежнего размера массива.
    * */
    public static int[] processArray(int[] numbers) {
        int[] result = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .toArray();
        int[] paddedResult = new int[numbers.length];
        System.arraycopy(result, 0, paddedResult, 0, result.length);
        return paddedResult;
    }

    /*
    * [13]
    * Создать массив целых чисел. Используя лямбда-выражение, отсортировать массив по убыванию.
    * */


    /*
    * [14]
    * Определить, является ли число элементом Фибоначчи с помощью лямбда-выражений.
    * */
    public static boolean isFibonacciNumber(int number) {
        // проверяем, является ли число квадратом целого числа.
        Predicate<Integer> isPerfectSquare = x -> {
            int sqrt = (int) Math.sqrt(x);
            return sqrt * sqrt == x;
        };
        // создаём бесконечный помок, где каждый элемент последовательности Фибоначчи вычисляется на основе двух предыдущих элементов.
        // после чего отфильтровываем только те числа, которые больше или равны заданному число.
        // используя anyMatch() мы проверяем, если в отсортированной последовательности число, равное заданному числу,
        // и одновременно выполнем условие Фибоначчи с помощью проверка на квадратность
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .map(fib -> fib[0])
                .filter(fib -> fib >= number)
                .anyMatch(fib -> fib == number && isPerfectSquare.test(5 * fib * fib + 4) || isPerfectSquare.test(5 * fib * fib - 4));

    }
}
