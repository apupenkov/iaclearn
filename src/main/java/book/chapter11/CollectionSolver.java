package book.chapter11;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CollectionSolver {
    /*
     * [1]
     * Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
     * */
    public static String[] reverseArray(String[] array) {
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
    * Main method for tests methods
    * */
    public static void main(String[] args) {
        String[] hello = {"Hello world!!!", "KLJLKJSDF", "qwer", "aboba"};
        Arrays.stream(reverseArray(hello)).forEach(System.out::println);

        System.out.println(reverseIntNumber(12345));

        String[] poem = {"В небе синем тихо горят звезды", "Белеет парус одинокий", "Тихо, тихо ползи, снежинка",
                "Падал снег на весь квартал", "А",
                "ААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААААА"};
        System.out.println(Arrays.toString(sortByLength(poem)));

        stringsWithKeyMoreFive();
    }
}
