package strings;

import java.io.IOException;
import java.util.*;

public class TaskSolver {
    public void testStringTaskSolver() {
        System.out.println("@dobrodelete for Alexandr-Calcifer\n");

        String fileNameTask3 = "StringFiles\\task3.txt";

        String[] forTasks = new String[(int)FileReaders.getCountLines(fileNameTask3)];

        try {
            forTasks = FileReaders.getStringsFromFile(fileNameTask3);
        } catch (IOException e) {
            e.printStackTrace();
        }


        int chosen = 1;

        while (chosen != 0) {
            System.out.print("Enter number tasks (0 - exit, 1-10 - tasks)\n-> ");
            Scanner scanner = new Scanner(System.in);
            try {
                chosen = Integer.parseInt(scanner.nextLine());
                switch (chosen) {
                    case 0:
                        System.out.println("Bye bye!");
                        break;

                    case 1:
                        System.out.println(StringTaskSolver.task1(forTasks[0], 'A', 5));
                        System.out.println(StringTaskSolver.task1("", 'A', 5));
                        System.out.println(StringTaskSolver.task1(forTasks[0], '\0', 5));
                        System.out.println(StringTaskSolver.task1(forTasks[0], 'a', 100000));
                        break;

                    case 2:
                        StringTaskSolver.task2(forTasks[0]);
                        StringTaskSolver.task2("");
                        StringTaskSolver.task2(null);
                        break;

                    case 3:
                        System.out.println(StringTaskSolver.task3(forTasks[0]));
                        System.out.println(StringTaskSolver.task3(forTasks[1]));
                        System.out.println(StringTaskSolver.task3(forTasks[2]));
                        break;

                    case 4:
                        System.out.println(StringTaskSolver.task4(forTasks[2], 5, "hello"));
                        System.out.println(StringTaskSolver.task4(forTasks[2], 100, "hello"));
                        System.out.println(StringTaskSolver.task4(forTasks[0], 186, "hello"));
                        break;

                    case 5:
                        System.out.println(StringTaskSolver.task5(forTasks[0], "et", "wow"));
                        System.out.println(StringTaskSolver.task5(forTasks[0], null, null));
                        break;

                    case 6:
                        String[] strings = new String[(int)FileReaders.getCountLines("StringFiles\\task6.txt")];
                        try {
                            strings = FileReaders.getStringsFromFile("StringFiles\\task6.txt");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        for (String string : StringTaskSolver.task6(strings, false, "a", 15)) {
                            System.out.println(string);
                        }
                        for (String string : StringTaskSolver.task6(strings, false, "a", 15)) {
                            System.out.println(string);
                        }

                        for (String string : StringTaskSolver.task6(strings, true, "a", 15)) {
                            System.out.println(string);
                        }
                        break;

                    case 7:
                        System.out.println(StringTaskSolver.task7("FIEJnadf -2348/./\\  asdffffff"));
                        break;

                    case 8:
                        System.out.println(StringTaskSolver.task8("Hello *asdflhjasldfj* world", '*', '*'));
                        System.out.println(StringTaskSolver.task8("Hello( asdflhjasldfj world)", '(', ')'));
                        System.out.println(StringTaskSolver.task8("Hello) asdflhjasldfj( world", '(', ')'));
                        break;

                    case 9:
                        Map<String, Integer> task9Solve = StringTaskSolver.task9(forTasks[0]);
                        task9Solve.forEach((key, value) -> System.out.println(key + " : " + value));

                        Map<String, Integer> task9 = StringTaskSolver.task9(null);
                        task9.forEach((key, value) -> System.out.println(key + " : " + value));
                        break;

                    case 10:
                        StringTaskSolver.task10(forTasks[0], 5);
                        break;

                    default:
                        System.out.println("Incorrect choose:(");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class StringTaskSolver {
    private static final String enAlphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String task1(String originString, char replaceChar, int index) {
        if (originString == "" || originString == null || replaceChar == '\0') return "";

        StringBuilder result = new StringBuilder();

        for (String s : originString.split(" ")) {
            StringBuilder temp = new StringBuilder(s);

            if (temp.length() >= index) {
                temp.setCharAt(index - 1, replaceChar);
            }
            result.append(temp + " ");
        }

        return result.toString();
    }

    public static void task2(String originString) {
        if (originString == "" || originString == null) return;

        int[] alphabetCharArray = new int[originString.length()];
        int index = 0;

        for (char c : originString.toCharArray()) {
            alphabetCharArray[index] = enAlphabet.indexOf(Character.toLowerCase(c) + 1);
            System.out.printf("%4s", alphabetCharArray[index]);
        }
        System.out.println();

        for (int i = 0; i < alphabetCharArray.length; i++) {
            System.out.printf("%4s", i);
        }
        System.out.println();
    }

    public static String task3(String originString) {
        if (originString == "" || originString == null) return "";
        StringBuilder result = new StringBuilder();

        for (String s : originString.split(" ")) {
            StringBuilder temp = new StringBuilder(s);

            if (s.toLowerCase().indexOf("p") != -1 &&
                    s.toLowerCase().indexOf("p") < s.length() - 1) {
                int t = s.toLowerCase().indexOf("p") + 1;
                if (Character.toLowerCase(s.charAt(t)) == 'a') {
                    temp.setCharAt(t, 'o');
                }
            }
            result.append(temp + " ");
        }

        return result.toString();
    }

    public static String task4(String originString, int index, String substring) {
        if (index < 0 || index >= originString.length()) return originString;
        return originString.substring(0, index) + substring + originString.substring(index);
    }

    public static String task5(String originString, String substring, String word) {
        if (originString == "" || originString == null || substring == null || word == null || word == "") return "";
        StringBuilder result = new StringBuilder();
        for (String s : originString.split(" ")) {
            result.append(s + " ");
            if (s.endsWith(substring))
                result.append(word + " ");
        }
        return result.toString();
    }

    public static String[] task6(String[] originStrings, boolean type, String character, int index) {
        if (index < 0 || character == null || character == "") return originStrings;
        String[] result = new String[originStrings.length];
        int i = 0;
        for (String string : originStrings) {
            if (type) {
                result[i] = new String(string.replaceAll(character, ""));
            }
            else {
                if (index >= string.length()) result[i] = string;
                result[i] = string.substring(0, index) + character + string.substring(index);
            }
            i++;
        }

        return result;
    }

    public static String task7(String originString) {
        if (originString == null || originString == null) return "";
        originString.replaceAll("\\p{Punct}", "");
        StringBuilder result = new StringBuilder();
        int index = 0;
        char lastChar = '\0';
        for (char s : originString.toCharArray()) {
            if ((enAlphabet.contains(String.valueOf(s).toLowerCase()) || s == ' ') && lastChar != s) {
                result.append(String.valueOf(s));
                lastChar = s;
                index++;
            } else if (lastChar == s) {
                result.append(" " + s);
                lastChar = s;
                index += 2;
            }
        }

        return result.toString();
    }

    public static String task8(String originString, char startChar, char endChar ) {
        if (startChar == '\0' || endChar == '\0') return originString;
        if (originString == "" || originString == null) return "";
        int start = originString.indexOf(startChar);
        int end = originString.indexOf(endChar);

        while (start >= end) {
            end = originString.indexOf(endChar, end + 1);
            if (end == -1)
                break;
        }

        if (start == -1 || end == -1)
            return "";
        return originString.substring(0, start) + originString.substring(end + 1);
    }

    public static Map<String, Integer> task9(String originString) {
        if (originString == null || originString == "") return new HashMap<String, Integer>();
        Map<String, Integer> result = new HashMap<>();

        for (String str : originString.replaceAll("\\p{Punct}", "").toLowerCase().split(" ")) {
            if (!result.containsKey(str)) {
                result.put(str, 1);
            }
            else if (result.containsKey(str)) {
                result.put(str, result.get(str) + 1);
            }
        }

        return result;
    }

    public static void task10(String originString, int top) {
        if (originString == "" || originString == null || top < 1) return;
        Map<Character, Integer> result = new HashMap<Character, Integer>();

        for (Character chr : originString.replaceAll("[^A-Za-z]+", "").toLowerCase().toCharArray()) {
            if (!result.containsKey(chr))
                result.put(chr, 1);
            else if (result.containsKey(chr))
                result.put(chr, result.get(chr) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(result.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        if (list.size() < top) top = list.size();

        for (int i = 0; i < top; i++) {
            System.out.println((i + 1) + ") " +
                    list.get(i).getKey().toString() + " : " + list.get(i).getValue().toString());
        }

    }
}