package book.chapter11;

import book.chapter11.entities.Line;
import book.chapter11.entities.Point;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CollectionSolver {

    /*
    * Solve tasks from Variant A
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
    public static int reverseIntNumber(long number) {
        if (number == 0) return 0;
        Stack<Long> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (number < 0) sb.append("-");
        while (number != 0) {
            long digit = number % 10;
            stack.push(Math.abs(digit));
            number /= 10;
        }

        stack.forEach(i -> sb.append(i.toString()));

        return Integer.parseInt(sb.toString());
    }

    /*
     * [4]
     * Занести стихотворения одного автора в список. Провести сортировку по
     * возрастанию длин строк.
     * */
    public static String[] sortByLength(String[] input) {
        if (input == null) throw new IllegalArgumentException("Передайте не пустой массив");
        List<String> poems = new ArrayList<>(List.of(input));
        poems.sort(Comparator.comparingInt(String::length));
        return poems.toArray(String[]::new);
    }

    /*
     * [16]
     * Заполнить HashMap 10 объектами <Integer, String>. Найти строки у которых ключ > 5. Если ключ = 0, вывести строки
     * через запятую. Перемножить все ключи, где длина строки > 5.
     * */

    public static Map<Integer, String> findStringByKeyMoreValue(Map<Integer, String> input, int value) {
        return input.entrySet().stream()
                .filter(x -> x.getKey() > value)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static Map<Integer, String> findStringByKey(Map<Integer, String> input, int value) {
        return input.entrySet().stream()
                .filter(x -> x.getKey() == value)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    public static List<String> getListString(Map<Integer, String> input, int value) {
        return input.values().stream().toList();
    }


    public static int sumKeysByMoreValue(HashMap<Integer, String> input, int value) {
        return input.keySet().stream().filter(x -> x > value).reduce(1, Integer::sum);
    }


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

    public static void createListDirectoryElements(String path, List<String> fileList) throws IOException {

        File directory = new File(path);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    createListDirectoryElements(file.getCanonicalPath(), fileList);
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
        copy = (Stack<Object>) original.clone();
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
    public static Map<Integer, Map<Integer, Integer>> addPolynomials(Map<Integer, Map<Integer, Integer>> polinom1, Map<Integer, Map<Integer, Integer>> polinom2) {
        if (polinom1.size() != polinom2.size())
            throw new IllegalArgumentException("Две коллекции должны быть одного размера.");

        Map<Integer, Map<Integer, Integer>> sum = new HashMap<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : polinom1.entrySet()) {
            sum.put(entry.getKey(), entry.getValue());
        }

        return sum;
    }

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
    * [12]
    * Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк, используя метод sort() из класса Collections.
    * */



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
        if (array == null) throw new IllegalArgumentException();
//        Arrays.stream(array).forEach(String::toLowerCase);
        return new HashSet<>(Arrays.stream(array).map(String::toLowerCase).sorted().toList());
    }

    /*
    * [15]
    * Задан файл с текстом на английском языке. Выделить все различные слова. Для каждого слова подсчитать частоту его
    * встречаемости. Слова, отличающиеся регистром букв, считать различными. Использовать класс HashMap
    * */

    /*
    * [16]
    * Заполнить HashMap 10 объектами <Integer, String>. Найти строки у которых ключ>5. Если ключ = 0, вывести строки
    * через запятую. Перемножить все ключи, где длина строки>5.
    * */

    /*
    * [17]
    * Написать функцию, которая получала бы итераторы на начало и конец отсортированного List и заданный символ.
    * Возвращать функция должна начало и конец диапазона, строки в котором начинаются с заданного символа.
    * */

    /* Solve tasks from Variant B
    * */

    /*
    * [1]
    * В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый второй человек,
    * пока не останется один. Составить две программы, моделирующие процесс. Одна из программ должна использовать класс
    * ArrayList, а вторая — LinkedList. Какая из двух программ работает быстрее? Почему?
    * */
    public static int getLastPerson(List<Integer> circle, int n) {

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
    * [3]
    * Написать программу, осуществляющую сжатие английского текста. Построить для каждого слова в тексте оптимальный
    * префиксный код по алгоритму Хаффмена. Использовать класс PriorityQueue.
    * */

    /*
    * [4]
    * Реализовать класс Graph, представляющий собой неориентированный граф. В конструкторе класса передается количество
    * вершин в графе. Методы должны поддерживать быстрое добавление и удаление ребер.
    * */

    /*
    * [5]
    * На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
    * - добавление/удаление числа;
    * - поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
    * */

    /*
    * [6]
    * Реализовать класс, моделирующий работу N­местной автостоянки. Машина подъезжает к определенному месту и едет
    * вправо, пока не встретится свободное место. Класс должен поддерживать методы, обслуживающие приезд и отъезд машины.
    * */

    /*
    * [7]
    * Во входном файле хранятся две разреженные матрицы — А и В. Построить циклически связанные списки СА и СВ,
    * содержащие ненулевые элементы соответственно матриц А и В. Просматривая списки, вычислить: а) сумму S = A + B; б)
    * произведение P = A × B.
    * */

    /*
    * [8]
    * Во входном файле хранятся наименования некоторых объектов. Построить список Z, элементы которого содержат
    * наименования и шифры данных объектов, причем элементы списка должны быть упорядочены по возрастанию шифров. Затем
    * «сжать» список Z, удаляя дублирующие наименования объектов.
    * */

    /*
    * [9]
    * Во входном файле расположены два набора положительных чисел; между наборами стоит отрицательное число. Построить
    * два списка C1 и С2, элементы которых содержат соответственно числа 1-го и 2-го набора таким образом, чтобы
    * внутри одного списка числа были упорядочены по возрастанию. Затем объединить списки C1 и С2 в один упорядоченный
    * список, изменяя только значения полей ссылочного типа.
    * */

    /*
    * [10]
    * Во входном файле хранится информация о системе главных автодорог, связывающих г. Полоцк с другими городами
    * Беларуси. Используя эту информацию, построить дерево, отображающее систему дорог республики, а затем, продвигаясь
    * по дереву, определить минимальный по длине путь из г. Полоцка в другой заданный город. Предусмотреть возможность
    * сохранения дерева в виртуальной памяти.
    * */

    /*
    * [11]
    * Один из способов шифрования данных, называемый «двойным шифрованием», заключается в том, что исходные данные при
    * помощи некоторого КОЛЛЕКЦИИ И STREAM API 365 преобразования последовательно шифруются на некоторые два ключа —
    * K1 и K2. Разработать и реализовать эффективный алгоритм, позволяющий находить ключи K1 и K2 по исходной строке и
    * ее зашифрованному варианту. Проверить, оказался ли разработанный способ действительно эффективным, протестировав
    * программу для случая, когда оба ключа являются 20-битными (время ее работы не должно превосходить одной минуты).
    * */

    /*
    * [12]
    * На плоскости задано N точек. Вывести в файл описания всех прямых, которые проходят более чем через одну точку из
    * заданных. Для каждой прямой указать, через сколько точек она проходит. Использовать класс HashMap.
    * */

    /*
        Чтобы линия проходила минимум через две или более точки (можно построить)
        class point (x, y)
        List<Poing> ponts = points()

        использовать вместо list<Point> set<Point>

    */
    public static List<Line> getLines(List<Point> points) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                lines.add(new Line(points.get(i), points.get(j)));
            }
        }
        return lines;
    }

    public static Map<Line, Set<Point>> getLinesThroughPoints(List<Line> lines, Set<Point> points) {
        Map<Line, Set<Point>> result = new HashMap<>();
        Set<Point> inputPoints = new HashSet<>();
        for (Line line : lines) {
            int count = 0;
            for (Point p : points) {
                if (line.pointOnLine(p)) {
                    count++;
                    inputPoints.add(p);
                }
            }
            if (count > 1) {
                result.put(line, new HashSet<>(inputPoints));
            }
            count = 0;
            inputPoints.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
//                System.out.println("new Point(" + i + ", " + j + "),");
                points.add(new Point(i, j));
            }
        }

        points.forEach(e -> System.out.print(e.getX() + "|" + e.getY() + ", "));


        List<Line> lines = getLines(points);

        Map<Line, Set<Point>> linePoints = getLinesThroughPoints(lines, new HashSet<>(points));

        System.out.println("Линии, которые проходят через более чем одну точку:");
        for (Map.Entry<Line, Set<Point>> entry : linePoints.entrySet()) {
            System.out.println("Line: " + entry.getKey());
            System.out.println("Points:\n" + entry.getValue().toString() + "\n");
        }
    }


    /*
    * [13]
    * На клетчатой бумаге нарисован круг. Вывести в файл описания всех клеток, целиком лежащих внутри круга, в порядке
    * возрастания расстояния от клетки до центра круга. Использовать класс PriorityQueue.
    * */

    /*
    * [14]
    * На плоскости задано N отрезков. Найти точку пересечения двух отрезков, имеющую минимальную абсциссу. Использовать
    * класс TreeMap.
    * */

    /*
    * [15]
    * На клетчатом листе бумаги закрашена часть клеток. Выделить все различные фигуры, которые образовались при этом.
    * Фигурой считается набор закрашенных клеток, достижимых друг из друга при движении в четырех направлениях. Две
    * фигуры являются различными, если их нельзя совместить поворотом на угол, кратный 90 градусам, и параллельным
    * переносом. Используйте класс HashSet.
    * */

    /*
    * [16]
    * Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу, состоящую из максимального количества
    * одинаковых элементов. Использовать класс ArrayDeque.
    * */

    /*
    * [17]
    * Реализовать структуру «черный ящик», хранящую множество чисел и имеющую внутренний счетчик K, изначально равный
    * нулю. Структура должна поддерживать операции добавления числа в множество и возвращение K-го по минимальности
    * числа из множества.
    * */

    /*
    * [18]
    * На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость.
    * Определить, сколько произойдет обгонов.
    * */

    /*
    * [19]
    * На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость.
    * Вывести первые K обгонов.
    * */
}
