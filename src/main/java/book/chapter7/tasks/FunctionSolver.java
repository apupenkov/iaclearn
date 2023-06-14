package book.chapter7.tasks;

import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionSolver {

    private static final Map<Integer, String> units = new HashMap<>();
    private static final Map<Integer, String> tens = new HashMap<>();
    private static final Map<Integer, String> scales = new HashMap<>();

    static {
        units.put(0, "zero");
        units.put(1, "one");
        units.put(2, "two");
        units.put(3, "three");
        units.put(4, "four");
        units.put(5, "five");
        units.put(6, "six");
        units.put(7, "seven");
        units.put(8, "eight");
        units.put(9, "nine");

        tens.put(10, "ten");
        tens.put(11, "eleven");
        tens.put(12, "twelve");
        tens.put(13, "thirteen");
        tens.put(14, "fourteen");
        tens.put(15, "fifteen");
        tens.put(16, "sixteen");
        tens.put(17, "seventeen");
        tens.put(18, "eighteen");
        tens.put(19, "nineteen");
        tens.put(20, "twenty");
        tens.put(30, "thirty");
        tens.put(40, "forty");
        tens.put(50, "fifty");
        tens.put(60, "sixty");
        tens.put(70, "seventy");
        tens.put(80, "eighty");
        tens.put(90, "ninety");

        scales.put(1_000, "thousand");
        scales.put(1_000_000, "million");
        scales.put(1_000_000_000, "billion");
    }


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

    /*
     * [19]
     * Дан предикат condition и две функции ifTrue и ifFalse. Написать метод ternaryOperator, который из них построит
     * новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
     * */
    public static <T, R> Function<T, R> ternaryOperator(
            Predicate<T> condition,
            Function<T, R> ifTrue,
            Function<T, R> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    /*
     * [20]
     * С помощью лямбда-выражений вычислить факториал заданного числа.
     * */
    public static int factorial(int number) {
        // попробовать реализовать функцию через IntUnaryOperator
        if (number <= 1) return 1;
        else return IntStream.rangeClosed(2, number).reduce((x, y) -> x * y).getAsInt();
    }

    /*
     * [21]
     * Дан прямоугольный треугольник с катетами a и b. С помощью лямбда-выражения найти радиус вписанной в треугольник окружности.
     * */
    public static double inscribedCircleRadius(double a, double b) {
        BiFunction<Double, Double, Double> radius = (x, y) -> (x + y - Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))) / 2;
//        UnaryOperator<Double> round = (x) ->
//            new BigDecimal(x, new MathContext(3, RoundingMode.HALF_UP)).doubleValue();
        return Math.round(radius.apply(a, b) * 100.0) / 100.0;
    }

    /*
    * [22]
    * Дана строка. Вернуть строку, где сначала идут гласные, а потом согласные из заданной строки. Гласные и согласные
    * должны быть в отсортированном порядке
    * */
    public static String sortVowelsAndConsonants(String input) {
        if (input == null || input.length() == 0) return "";
        String vowels = "aeiouAEIOU";
        String consonants = input.replaceAll("[^a-zA-Z]", "")
                .replaceAll("[aeiouAEIOU]", "");

        String sortedVowels = input.chars()
                .filter(ch -> vowels.contains(String.valueOf((char) ch)))
                .mapToObj(ch -> String.valueOf((char) ch))
                .sorted()
                .collect(Collectors.joining());

        String sortedConsonants = consonants.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .sorted()
                .collect(Collectors.joining());

        return sortedVowels + sortedConsonants;
    }

    /*
    * [23]
    * Написать программу, которая выводит число прописью.
    * */
//    public static String convertToWords1(int number) {
//        if (number == 0) {
//            return units.get(0);
//        }
//
//        StringBuilder words = new StringBuilder();
//
//        if (number < 0) {
//            words.append("minus ");
//            number = -number;
//        }
//
//        scales.entrySet().stream()
//                .filter(entry -> number >= entry.getKey())
//                .forEach(entry -> {
//                    int scale = entry.getKey();
//                    String scaleWord = entry.getValue();
//
//                    int scaleValue = number / scale;
//                    words.append(convertToWords(scaleValue))
//                            .append(" ")
//                            .append(scaleWord);
//                    number %= scale;
//
//                    if (number > 0) {
//                        words.append(" ");
//                    }
//                });
//
//        if (number > 0) {
//            if (number < 20) {
//                words.append(units.get(number));
//            } else {
//                int tensValue = number / 10 * 10;
//                int unitsValue = number % 10;
//
//                words.append(tens.get(tensValue));
//
//                if (unitsValue > 0) {
//                    words.append("-").append(units.get(unitsValue));
//                }
//            }
//        }
//
//        return words.toString();
//    }

    /*
     * [24]
     * Вывести массив NxN, заполненный по спирали в порядке возрастания.
     * */

    /*
    * [25]
    * Определить, является ли строка панграммой (использует каждую букву алфавита хотя бы один раз).
    * */
    public static boolean isPangram(String str) {
        Set<Character> alphabet = new HashSet<>();
        str = str.toLowerCase();

        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        return str.chars()
                .filter(Character::isLetter)
                .mapToObj(ch -> (char) ch)
                .collect(HashSet::new, Set::add, Set::addAll)
                .containsAll(alphabet);
    }

    /*
     * [26]
     * С помощью генераторов вывести первые N простых чисел.
     * */
    public static IntStream generatePrimes(int n) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(FunctionSolver::isPrime)
                .limit(n);
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * [27]
     * Преобразовать каждый элемент списка, цену без добавленной стоимости в цену с добавленной стоимостью.
     * */
    public static List<Double> transformPrices(List<Double> prices, double cost) {
        return prices.stream()
                .map(price -> price + cost)
                .toList();
    }

    /*
     * [28]
     * Дано время в 12-часовом формате в виде строки. Конвертировать время в 24-часовой формат.
     * */

    /*
     * [29]
     * Дан массив чисел. Построить из этих чисел двоичное дерево поиска и найти глубину этого дерева.
     * */

    /*
     * [30]
     * Последовательность координат вершин многоугольника задана массивом чисел. Определить, лежит ли точка внутри многоугольника.
     * */

    /*
     * [31]
     * С применением лямбда-выражения перевернуть входную строку.
     * */

    /*
     * [32]
     * С помощью лямбда-выражений разработать метод, который на вход получает массив объектов, а возвращает его уже без дубликатов.
     * */

    /*
     * [33]
     * Написать предикат, выбирающий имена, которые начинаются с заданной буквы.
     * */

    /*
     * [34]
     * Написать программу, возвращающую значения числа Пи, используя лямбда-выражения.
     * */

    /*
     * [35]
     * Используя фильтр, создать новый массив из строк с числом символов больше заданного.
     * */

    /*
     * [36]
     * В массиве строк найти все строки, начинающиеся на заданный символ и состоящие из N букв.
     * */

}
