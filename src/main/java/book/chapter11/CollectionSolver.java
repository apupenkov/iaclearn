package book.chapter11;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CollectionSolver {

    /* Solve tasks from Variant A
    * */

    /*
     * [1]
     * Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
     * */
    public static String[] reverseArray(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив должен быть заполнен");
        }
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        return list.toArray(String[]::new);
    }

    /*
     * [2]
     * Ввести число, занести его цифры в стек. Вывести число, у которого цифры
     * идут в обратном порядке
     * */
    public static int reverseIntNumber(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            int digit = number % 10;
            stack.push(digit);
            number /= 10;
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(i -> sb.append(i.toString()));

        return Integer.parseInt(sb.toString());
    }

    /*
     * [4]
     * Занести стихотворения одного автора в список. Провести сортировку по
     * возрастанию длин строк.
     * */
    public static String[] sortByLength(String[] input) {
        List<String> poems = new ArrayList<>(List.of(input));
        poems.sort(Comparator.comparingInt(String::length));
        return poems.toArray(String[]::new);
    }

    /*
     * [16]
     * Заполнить HashMap 10 объектами <Integer, String>. Найти строки у которых ключ > 5. Если ключ = 0, вывести строки
     * через запятую. Перемножить все ключи, где длина строки > 5.
     * */
    public static void stringsWithKeyMoreFive() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(0, "Строка0");
        hashMap.put(1, "Строка1");
        hashMap.put(2, "Строка2");
        hashMap.put(3, "Строка3");
        hashMap.put(4, "Строка4");
        hashMap.put(5, "Строка5");
        hashMap.put(6, "Строка6");
        hashMap.put(7, "Строка7");
        hashMap.put(8, "Строка8");
        hashMap.put(9, "Строка9");
        hashMap.put(10, "Строка10");

        Map<Integer, String> keyMoreFive = hashMap.entrySet()
                .stream().filter(x -> x.getKey() > 5)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        System.out.println("Строки у которых ключ > 5:");
        keyMoreFive.entrySet().forEach(System.out::println);

        List<Integer> keys = hashMap.keySet().stream().filter(x -> x > 5).toList();
        System.out.println("Произведение ключей больше 5: " +
                keys.stream().reduce(1, (x, y) -> x * y));

        for (int key : hashMap.keySet()) {
            if (key == 0) {
                System.out.println(String.join(", ", hashMap.values()));
                break;
            }
        }
    }

    /*
    * [3]
    * Создать список из элементов каталога и его подкаталогов.
    * */

    public static void createListDirectoryElements(String path, List<String> fileList) {

        File directory = new File(path);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    createListDirectoryElements(file.getAbsolutePath(), fileList);
                }
                else {
                    fileList.add(file.getPath());
                }
            }
        }
    }

    /*
     * [5]
     * Задать два стека, поменять информацию местами.
     * */
    public static void swapStack(Stack<Object> original, Stack<Object> copy) {
        while (!original.isEmpty()) {
            copy.push(original.pop());
        }
    }

    public static <T> void swapTwoStack(Stack<T> stack1, Stack<T> stack2) {
        if (stack1.isEmpty() && stack2.isEmpty()) return;
        Stack<T> largestStack;
        Stack<T> smallerStack;
        Stack<T> tempStack = new Stack<>();

        if (stack1.size() > stack2.size()) {
            largestStack = stack1;
            smallerStack = stack2;
        } else {
            largestStack = stack2;
            smallerStack = stack1;
        }

        while (!largestStack.isEmpty()) {
            tempStack.push(largestStack.pop());
        }

        while (!smallerStack.isEmpty()) {
            largestStack.push(smallerStack.pop());
        }

        while (!tempStack.isEmpty()) {
            smallerStack.push(tempStack.pop());
        }
    }


    /*
    * [6]
    * Определить множество на основе множества целых чисел. Создать методы
    * для определения пересечения и объединения множеств.
    * */
    public static <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static <T> Set<T> findUnion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }


    /*
    * [7]
    * Списки, стеки или очереди T(1..n) и U(1..n) содержат результаты n-измерений тока и напряжения на неизвестном
    * сопротивлении R. Найти приближенное число R методом наименьших квадратов.
    * */
    public static double findResistance(List<Double> currentList, List<Double> voltageList) {
        int n = currentList.size();

        if (n != voltageList.size()) {
            throw new IllegalArgumentException("Размеры списков должны быть одинаковыми");
        }

        double tMean = calculateMean(currentList);
        double uMean = calculateMean(voltageList);

        double sumProducts = 0.0;
        double sumSquaredDifferencesT = 0.0;
        for (int i = 0; i < n; i++) {
            double dT = currentList.get(i) - tMean;
            double dU = voltageList.get(i) - uMean;

            sumProducts += dT * dU;
            sumSquaredDifferencesT += dT * dT;
        }

        return sumProducts / sumSquaredDifferencesT;
    }

    public static double calculateMean(List<Double> values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }


    /*
     * [8]
     * С использованием множества выполнить попарное суммирование произвольного конечного ряда чисел по следующим правилам:
     * на первом этапе суммируются попарно рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т.д.
     * до тех пор, пока не останется одно число.
     * */
    public static Set<Integer> pairwiseSum(Set<Integer> set) {
        if (set.size() < 2) {
            return set;
        }
        Set<Integer> pairs = new LinkedHashSet<>();
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer temp = iterator.next();
            if (iterator.hasNext()) {
                temp += iterator.next();
            }
            pairs.add(temp);
        }
        return pairwiseSum(pairs);
    }

    /*
     * [9]
     * Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap.
     * */
//    public static Map<Integer, Map<Integer, Integer>> addPolynomials(Map<Integer, Map<Integer, Integer>> polinom1, Map<Integer, Map<Integer, Integer>> polinom2) {
////        if (polinom1.size() != polinom2.size())
////            throw new IllegalArgumentException("Две коллекции должны быть одного размера.");
//
//        Map<Integer, Map<Integer, Integer>> sum = new HashMap<>();
//        for (Map.Entry<Integer, Map<Integer, Integer>> entry : polinom1.entrySet()) {
//            sum.put(entry.getKey(), entry.getValue());
//        }
//
//        return sum;
//    }

    /*
    * [10]
    * Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках
    * */

    /*
     * [11]
     * Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец,
     * а положительные — в начало списка.
     * */
    public static void sortBySign(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    /*
     * [13]
     * Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.
     * */
    public static boolean validateBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isClosedBracket(ch)) {
                if (stack.isEmpty() || !isMatchingBracket(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isClosedBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean isMatchingBracket(char openBracket, char closedBracket) {
        return (openBracket == '(' && closedBracket == ')')
                || (openBracket == '[' && closedBracket == ']')
                || (openBracket == '{' && closedBracket == '}');
    }

    /*
    * [14]
    * Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв,
    * считать одинаковыми. Использовать класс HashSet.
    * */
    public static Set<String> getUniqueWords(String[] array) {
        Set<String> uniqueWords = new HashSet<>(Arrays.stream(array).toList());

        return uniqueWords;
    }



    /* Solve tasks from Variant B
    * */

    /*
    * [1]
    * В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый второй человек,
    * пока не останется один. Составить две программы, моделирующие процесс. Одна из программ должна использовать класс
    * ArrayList, а вторая — LinkedList. Какая из двух программ работает быстрее? Почему?
    * */

    public static int getLastPersonArrayList(int n) {
        ArrayList<Integer> circle = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int currentIndex = 0;
        while (circle.size() > 1) {
            currentIndex = (currentIndex + 1) % circle.size();
            circle.remove(currentIndex);
        }

        return circle.get(0);
    }

    public static int getLastPersonLinkedList(int n) {
        LinkedList<Integer> circle = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int currentIndex = 0;
        while (circle.size() > 1) {
            currentIndex = (currentIndex + 1) % circle.size();
            circle.remove(currentIndex);
        }

        return circle.get(0);
    }

    /*
    * [2]
    * Задан список целых чисел и некоторое число X. Не используя вспомогательных объектов и методов сортировки и не
    * изменяя размера списка, переставить элементы списка так, чтобы сначала шли числа, не превосходящие X, а затем
    * числа, больше X.
    * */

    public static void rearrange(List<Integer> list, int x) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left) > x && list.get(right) <= x) {
                int temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }

            if (list.get(left) <= x) {
                left++;
            }

            if (list.get(right) > x) {
                right--;
            }
        }
    }


    /*
    * Main method for tests methods
    * */
    public static void main(String[] args) {

//        int n = 10; // Количество людей в кругу
//        int lastPersonA = getLastPersonArrayList(n);
//        System.out.println("Последний оставшийся человек: " + lastPersonA);
//        int lastPersonL = getLastPersonLinkedList(n);
//        System.out.println("Последний оставшийся человек: " + lastPersonL);

        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(5);
        list.add(10);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(7);
        list.add(9);

        int x = 10;

        System.out.println("Исходный список: " + list);
        rearrange(list, x);
        System.out.println("Переставленный список: " + list);


        // task 1
//        String[] hello = {"Hello world!!!", "KLJLKJSDF", "qwer", "aboba"};
//        Arrays.stream(reverseArray(hello)).forEach(System.out::println);

        // task 2
//        System.out.println(reverseIntNumber(12345));

        // task 4
//        String[] poem = {"В небе синем тихо горят звезды", "Белеет парус одинокий", "Тихо, тихо ползи, снежинка",
//                "Падал снег на весь квартал", "А",
//                "ААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААА"};
//        System.out.println(Arrays.toString(sortByLength(poem)));

        // task 16
//        stringsWithKeyMoreFive();

        // task 3
//        List<String> fileList = new ArrayList<>();
//        createListDirectoryElements("src", fileList);

//        fileList.forEach(System.out::println);

        // task 5
//        Stack<String> stringStack1 = new Stack<>();
//        Stack<String> stringStack2 = new Stack<>();
//
//        stringStack1.push("Hello");
//        stringStack1.push("My");
//        stringStack1.push("Dear");
//        stringStack1.push("Friend");
//
//
//        stringStack2.push("Lorem");
//        stringStack2.push("Ismus");
//        stringStack2.push("Diem");
//        stringStack2.push("Label");
//
//        stringStack1.forEach(System.out::println);
//        System.out.println("_____");
//        stringStack2.forEach(System.out::println);
//        System.out.println("+++++");
//
//        swapTwoStack(stringStack1, stringStack2);
//
//        stringStack1.forEach(System.out::println);
//        System.out.println("_____");
//        stringStack2.forEach(System.out::println);
//        System.out.println("+++++");

//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();

//        for (int i = 0; i < 1_000_000; i++) {
//            stack1.push(i);
//            stack2.push(1_000_000 - i);
//        }

//        long startTime = System.currentTimeMillis();
//
//        swapTwoStack(stack1, stack2);
//
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - startTime;
//        System.out.println("Время выполнения: " + executionTime + " миллисекунд");

        // task 6
//        Set<Integer> set1 = new HashSet<>();
//        set1.add(1);
//        set1.add(2);
//        set1.add(3);
//
//        Set<Integer> set2 = new HashSet<>();
//        set2.add(3);
//        set2.add(4);
//        set2.add(5);
//
//        Set<Integer> intersection = findIntersection(set1, set2);
//        System.out.println("Пересечение: " + intersection);
//
//        Set<Integer> union = findUnion(set1, set2);
//        System.out.println("Объединение: " + union);
//
//        // task 7
//        List<Double> currentList = List.of( 15.5, 12.2, 8.85, 12.1 );
//        List<Double> voltageList = List.of( 97.12, 52.5, 32.2, 56. );
//
//        double resistance = findResistance(currentList, voltageList);
//        System.out.println("Приближенное значение сопротивления R: " + resistance);
//
//        // task 8
//        System.out.println("Сумма: " + pairwiseSum(Set.of(1, 2, 3, 4, 5, 6, 7, 8)));

        // task 9
//        Map<Integer, Integer> polynomial1 = new HashMap<>();
//        polynomial1.put(2, 3);
//        polynomial1.put(1, 2);
//        polynomial1.put(0, 1);
//
//        Map<Integer, Integer> polynomial2 = new HashMap<>();
//        polynomial2.put(2, 1);
//        polynomial2.put(1, -2);
//        polynomial2.put(0, 3);
//
//        Map<Integer, Integer> sum = addPolynomials(polynomial1, polynomial2);
//        System.out.println("Сложенный многочлен: " + sum);

        // task 11
//        List<Integer> list = Arrays.asList(1, 5, 3, -3, 2, -5, -63, 0, 5, 5);
//        sortBySign(list);
//        System.out.println(list);
    }
}
