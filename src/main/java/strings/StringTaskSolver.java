package strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTaskSolver {
    private static final String enAlphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String returnStringWithoutLastChar(StringBuilder str) {
        return str.toString().substring(0, str.length() - 1);
    }

    public static Boolean checkEmptyString(String str) {
        if (str == "" || str == null || str == " " || str.isEmpty()) return true;
        return false;
    }

    public static boolean isVowel(char c) {
        return "aeiouyAEIOUY".indexOf(c) != -1;
    }

    public static String longestStringFromArray(String[] words) {
        return Arrays.stream(words)
                .max(Comparator.comparingInt(String::length))
                .orElseGet(String::new);
    }

    private static boolean isConsonant(char c) {
        c = Character.toLowerCase(c);
        return c >= 'b' && c <= 'z' && !"aeiou".contains(String.valueOf(c));
    }

    public static boolean isSpaces(String str) {
        if (str.trim().isEmpty()) return true;
        return false;
    }

    public static boolean isPunctuation(char c) {
        String punctuationPattern = "\\p{Punct}";
        return Pattern.matches(punctuationPattern, Character.toString(c));
    }

    public static boolean isPunct(char input) {
        return ",.!?'\"/:;".indexOf(input) != -1;
    }

    /*
    public static boolean isLetter(char input) {
        return Character.isLetter(input);
    }*/

    public static String removePunctuation(String input) {
        StringBuilder output = new StringBuilder(input);
        while (!Character.isLetter(output.charAt(output.length() - 1))) {
            output.deleteCharAt(output.length() - 1);
        }
        return output.toString();
    }

    public static String getLengthWords(String input) {
        StringBuilder output = new StringBuilder();
        for (String str : input.split(" ")) {
            output.append(removePunctuation(str).length() + " ");
        }
        return output.toString().trim();
    }

    /*
    * [1]
    * В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова, корректировку не выполнять.
    * */
    public static String replaceCharacterInWordsByIndex(String input, char replaceChar, int index) {
        if (checkEmptyString(input)) return "";
        if (isSpaces(input) || replaceChar == '\0' || index < 0)
            return input;

        StringBuilder output = new StringBuilder();

        for (String s : input.split(" ")) {
            StringBuilder temp = new StringBuilder(s);

            if (temp.length() > index) {
                temp.setCharAt(index, replaceChar);
            }
            output.append(temp + " ");
        }

        return output.toString().trim();
    }

    /*
    * [2]
    * В тексте каждую букву заменить ее порядковым номером в алфавите.
    * При выводе в одной строке печатать текст с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.
    * */
    public static String getAlphabetOrdinalNumbers(String input) {
        if (checkEmptyString(input) || isSpaces(input)) return "";

        StringBuilder output = new StringBuilder();
        for (char c : input.replaceAll("[^a-zA-Z]+", "").toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                output.append((int) (c - 'a' + 1)).append(" ");
            }
        }
        if (output.length() == 0) return "";
        return output.toString().trim();
    }

    /*
    * [3]
    * В тексте после буквы Р, если она не последняя в слове, ошибочно напечатана буква А вместо О. Внести исправления в текст.
    * */
    public static String replaceCharacterAfterLetterP(String input) {
        if (checkEmptyString(input)) return "";
        if (isSpaces(input)) return input;

        StringBuilder output = new StringBuilder();

        for (String s : input.split(" ")) {
            s.replaceAll("pa", "po");
            StringBuilder temp = new StringBuilder(
                    s.replaceAll("pa", "po")
                            .replaceAll("pA", "pO")
                            .replaceAll("Pa", "Po")
                            .replaceAll("PA", "PO"));
            output.append(temp + " ");
        }

        return output.toString().trim();
    }

    /*
    * [4]
    * В тексте после k-го символа вставить заданную подстроку.
    * */
    public static String insertSubstringByIndex(String input, int index, String substring) {
        if (checkEmptyString(input)) return "";
        if (index < 0 || index > input.length() || checkEmptyString(substring)) return input;

        return input.substring(0, index) + substring + input.substring(index);
    }

    /*
    * [5]
    * После каждого слова текста, заканчивающегося заданной подстрокой, вставить указанное слово.
    * */
    public static String insertWordAfterSubstring(String input, String substring, String word) {
        if (checkEmptyString(input) || isSpaces(input)) return "";
        if (checkEmptyString(substring)
                || checkEmptyString(word) || isSpaces(substring)) return input;
        StringBuilder output = new StringBuilder();
        for (String s : input.split(" ")) {
            if (s.endsWith(substring)) {
                output.append(s + word + " ");
            }
            else {
                output.append(s + " ");
            }
        }
        return output.toString().trim();
    }

    /*
    * [6]
    * В зависимости от признака (0 или 1) в каждой строке текста удалить указанный символ везде, где он встречается, или вставить его после k-гo символа.
    * */
    public static String[] modifyStringArray(String[] inputs, boolean type, String character, int index) {
        if (index < 0 || checkEmptyString(character)) return inputs;
        if (inputs.length == 0) return new String[0];

        String[] output = new String[inputs.length];
        int i = 0;
        for (String string : inputs) {
            if (type) {
                output[i] = new String(string.replaceAll(character, ""));
            } else {
                if (index >= string.length()) output[i] = string;
                else output[i] = string.substring(0, index) + character + string.substring(index);
            }
            i++;
        }

        return output;
    }

    /*
    * [7]
    * Изтекстаудалитьвсесимволы,кромепробелов,неявляющиесябуквами.Между последовательностями подряд идущих букв оставить хотя быодин пробел.
    * */
    public static String sanitizeText(String input) {
        if (checkEmptyString(input)) return "";
        input.replaceAll("\\p{Punct}", "");
        StringBuilder output = new StringBuilder();
        int index = 0;
        char lastChar = '\0';
        for (char s : input.toCharArray()) {
            if ((enAlphabet.contains(String.valueOf(s).toLowerCase()) || s == ' ') && lastChar != s) {
                output.append(String.valueOf(s));
                lastChar = s;
                index++;
            } else if (lastChar == s) {
                output.append(" " + s);
                lastChar = s;
                index += 2;
            }
        }

        return output.toString();
    }

    /*
     * [8]
     * Удалить из текста его часть, заключенную между двумя символами, которые вводятся (например, между скобками «(» и «)» или между звездочками «*» и т.п.).
     * */
    public static String removeTextBetween(String input, char startChar, char endChar) {
        if (startChar == '\0' || endChar == '\0') return input;
        if (checkEmptyString(input)) return "";
        int start = input.indexOf(startChar);
        int end = input.indexOf(endChar);

        while (start >= end) {
            end = input.indexOf(endChar, end + 1);
            if (end == -1)
                break;
        }

        if (start == -1 || end == -1)
            return input;
        return input.substring(0, start) + input.substring(end + 1);
    }

    /*
    * [9]
    * Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
    * */
    public static Map<String, Integer> countWordOccurrences(String input) {
        if (checkEmptyString(input)) return new HashMap<String, Integer>();
        Map<String, Integer> output = new HashMap<>();

        for (String str : input.replaceAll("\\p{Punct}", "").toLowerCase().split(" ")) {
            if (!output.containsKey(str)) {
                output.put(str, 1);
            } else if (output.containsKey(str)) {
                output.put(str, output.get(str) + 1);
            }
        }

        return output;
    }

    /*
    * [10]
    * В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
    * */
    public static Map<Character, Integer> mostFrequentCharacters(String input, int top) {
        if (checkEmptyString(input)) return new HashMap<Character, Integer>();

        Map<Character, Integer> output = new HashMap<Character, Integer>();

        for (Character chr : input.toLowerCase().toCharArray()) {
            if (!output.containsKey(chr)) {
                output.put(chr, 1);
            } else if (output.containsKey(chr)) {
                output.put(chr, output.get(chr) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(output.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        if (list.size() < top) {
            top = list.size();
        }

        Map<Character, Integer> topCharacters = new LinkedHashMap<>();
        for (int i = 0; i < top; i++) {
            topCharacters.put(list.get(i).getKey(), list.get(i).getValue());
        }

        return topCharacters;
    }

    /*
    * [11]
    * Найти, каких букв, гласных или согласных, больше в каждом предложении текста.
    * */
    public static String[] compareSentenceVowelConsonantFrequency(String[] input) {
        if (input.length == 0) {
            return new String[] {""};
        }
        if (input.length == 1)
            if (input[0].isEmpty()) return new String[] {""};

        int index = 0;
        int vowels = 0, consonants = 0;

        String[] result = new String[input.length];

        for (String str: input) {
            for (char c : str.replaceAll("[^a-zA-Z]+", "").toLowerCase().toCharArray()) {
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
            if (vowels > consonants)
            {
                result[index] = "vowels";
            }
            else if (vowels < consonants) {
                result[index] = "consonants";
            }
            else result[index] = "equals";
            index++;
            vowels = 0;
            consonants = 0;
        }

        return result;
    }

    /*
    * [12]
    * В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.
    * */
    public static int countWordsStartEndWithVowel(String[] input) {
        int count = 0;

        for (String str : input) {
            for (String word : str.replaceAll("[^a-zA-Z]+", "").toLowerCase().split(" ")) {
                if (word.length() > 1 && isVowel(word.charAt(0)) && isVowel(word.charAt(str.length() - 1))) {
                    count++;
                }
            }
        }

        return count;
    }

    /*
    * [13]
    * Напечатать без повторения слова текста, у которых первая и последняя буквы совпадают.
    * */
    public static String[] wordsWithSameFirstAndLastCharacter(String input) {
        Set<String> result = new HashSet<>();
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (word.length() > 1 && word.toLowerCase().charAt(0) == word.toLowerCase().charAt(word.length() - 1)) {
                result.add(word);
            }
        }
        if (result.size() == 0) return new String[] {""};
        return result.toArray(String[]::new);
    }

    /*
    * [14]
    * В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
    * */
    public static String[] findMinMaxWords(String input) {
        if (checkEmptyString(input)) return new String[] {""};
//        String[] words = input.split("[\\s\\n\\t.,;:!?(){}]");
        List<String> minWords = new ArrayList<>();
        List<String> maxWords = new ArrayList<>();
        int minLength = longestStringFromArray(input.split("[^A-Za-z]+")).length();
        int maxLength = 0;
        for (String word : input.split("[^A-Za-z]+")) {
            if (word.length() == minLength) {
                minWords.add(word);
            } else if (word.length() < minLength) {
                minWords.clear();
                minWords.add(word);
                minLength = word.length();
            }
            if (word.length() == maxLength) {
                maxWords.add(word);
            } else if (word.length() > maxLength) {
                maxWords.clear();
                maxWords.add(word);
                maxLength = word.length();
            }
        }
        List<String> result = new ArrayList<>(minWords);
        result.addAll(maxWords);
        return result.stream().distinct().toArray(String[]::new);
    }

    /*
     * [15]
     * Напечатать квитанцию об оплате телеграммы, если стоимость одного слова задана.
     * */
    public static double telegramPaymentReceipt(String input, double pricePerWord) {
        if (checkEmptyString(input) || isSpaces(input)) return 0.0;
        if (pricePerWord < 0) throw new IllegalArgumentException("The price cannot be less than zero");

        if (!Pattern.matches(".*[a-zA-Z].*", input)) return 0.0;

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(input);

        long numWords = matcher.results().count();
        double cost = numWords * pricePerWord;
        return cost;
    }

    /*
    * [16]
    * В стихотворении найти одинаковые буквы, которые встречаются во всех словах.
    * */
    public static char[] findCommonLetters(String input) {
        if (checkEmptyString(input)) return new char[0];

        String[] words = input.split("[\\s.,?!]+");
        Set<Character> common = new HashSet<>();
        Set<Character> letters = new HashSet<>();

        for (char c : words[0].toCharArray()) {
            letters.add(c);
        }

        for (char c : letters) {
            boolean foundInAllWords = true;
            for (int i = 1; i < words.length; i++) {
                if (words[i].indexOf(c) == -1) {
                    foundInAllWords = false;
                    break;
                }
            }
            if (foundInAllWords) {
                common.add(c);
            }
        }
        char[] result = new char[common.size()];
        int i = 0;

        for (char c : common) {
            result[i++] = c;
        }

        return result;
    }

    /*
    * [17]
    * В тексте найти первую подстроку максимальной длины, не содержащую букв.
    * */
    public static String findLongestNonLetterSubstring(String input) {
        String[] substrings = input.split("[A-Za-z]+");
        String longestSubstring = "";
        for (String substring : substrings) {
            if (substring.length() > longestSubstring.length()) {
                longestSubstring = substring;
            }
        }
        return longestSubstring;
    }

    /*
    * [18]
    * В тексте определить все согласные буквы, встречающиеся не более чем в двух словах.
    * */
    public static Set<Character> findConsonants(String input) {
        if (checkEmptyString(input) || isSpaces(input)) return new HashSet<Character>();
        Set<Character> consonants = new HashSet<>();
        Map<Character, Integer> consonantCount = new HashMap<>();

        String[] words = input.split("[\\s.,?!]+");

        for (String word : words) {
            Set<Character> uniqueConsonants = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c) && isConsonant(c)) {
                    uniqueConsonants.add(c);
                }
            }

            for (char c : uniqueConsonants) {
                consonantCount.put(c, consonantCount.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : consonantCount.entrySet()) {
            if (entry.getValue() <= 2) {
                consonants.add(entry.getKey());
            }
        }

        return consonants;
    }

    /*
    * [19]
    * Преобразовать текст так, чтобы каждое слово, не содержащее неалфавитных символов, начиналось с заглавной буквы.
    * */
    public static String capitalizeWords(String input) {
        if (checkEmptyString(input)) return "";
        StringBuilder sb = new StringBuilder();

        for (String word : input.toLowerCase().split("\\s+")) {
            if (word.substring(0, word.length() - 1).matches("^[a-zA-Z]*$")) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }

        return sb.toString().trim();
    }

    /*
    * [20]
    * Подсчитать количество содержащихся в данном тексте знаков препинания.
    * */
    public static int countPunctuationMarks(String input) {
        if (checkEmptyString(input)) return 0;
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : input.toCharArray()) {
            if (isPunctuation(c)) {
                count++;
            }
        }
        return count;
    }

    /*
    * [21]
    * В заданном тексте найти сумму всех встречающихся цифр.
    * */
    public static int sumOfDigits(String input) {
        if (checkEmptyString(input)) return 0;
        int sum = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    /*
    * [22]
    * Из кода Java удалить все комментарии (//, /*, /**).
    * */
    public static String removeComments(String code) {
        if (checkEmptyString(code)) return "";

        code = code.replaceAll("//.*", "");

        code = code.replaceAll("/\\*(.|\\R)*?\\*/", "");

        code = code.replaceAll("/\\*\\*.*?\\*/", "");

        return code;
    }

    /*
    * [23]
    * Все слова текста встречаются четное количество раз, за исключением одного. Определить это слово. При сравнении слов регистр не учитывать.
    * */
    public static String findOddWord(String input) {
        if (checkEmptyString(input)) return "";

        input = input.toLowerCase();

        String[] words = input.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!wordCounts.containsKey(word)) {
                wordCounts.put(word, 1);
            } else {
                wordCounts.put(word, wordCounts.get(word) + 1);
            }
        }

        StringBuilder oddWord = new StringBuilder("");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWord.append(entry.getKey());
                break;
            }
        }

        return oddWord.toString();
    }

    /*
    * [24]
    * Из текста удалить все лишние пробелы, если они разделяют два различных знака препинания, и если рядом с ними находится еще один пробел.
    * */
    public static String removeExtraSpaces(String input) {
        if (checkEmptyString(input)) return "";

        return input.replaceAll("[ \\t]{2,}", " ");
    }

    /*
    * [25]
    * Строка состоит из упорядоченных чисел от 0 до 100000, записанных подряд без пробелов. Определить, что будет подстрокой от позиции n до m.
    * */
    public static String getSubstring(String input, int n, int m) {
        if (n < 0 || m >= input.length() || n > m) {
            throw new IllegalArgumentException("Invalid indices");
        }

        return input.substring(n, m + 1);
    }

    /*
    * [26]
    * Определить количество вхождений заданного слова в текст, игнорируя регистр символов и считая буквы «е», «ё», и «и», «й» одинаковыми.
    * */
    public static int countWordOccurrences(String input, String word) {
        if (checkEmptyString(input) || checkEmptyString(word)) return 0;
        String text = input.toLowerCase().replace("ё", "е").replace("й", "е");
        String sword = word.toLowerCase().replace("ё", "е").replace("й", "е");

        String[] words = text.split("[\\s.,?!]+");

        int count = 0;
        for (String w : words) {
            if (w.equals(sword)) {
                count++;
            }
        }

        return count;
    }

    /*
    * [27]
    * Преобразовать текст так, чтобы только первые буквы каждого предложения были заглавными.
    * */

    public static String capitalizeSentences(String text) {
        if (checkEmptyString(text)) return "";
        StringBuilder result = new StringBuilder(text.toLowerCase());

        boolean capitalizeNext = true;
        for (int i = 0; i < result.length(); i++) {
            char currentChar = result.charAt(i);

            if (capitalizeNext && Character.isLetter(currentChar)) {
                result.setCharAt(i, Character.toUpperCase(currentChar));
                capitalizeNext = false;
            }

            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    /*
    * [28]
    * Заменить все одинаковые рядом стоящие в тексте символы одним символом.
    * */
    public static String replaceDuplicateCharacters(String text) {
        if (checkEmptyString(text) || isSpaces(text)) return "";
        StringBuilder result = new StringBuilder();

        char previousChar = '\0';
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar != previousChar) {
                result.append(currentChar);
                previousChar = currentChar;
            }
        }

        return result.toString();
    }

    /*
    * [29]
    * Вывести в заданном тексте все слова, расположив их в алфавитном порядке.
    * */
    public static String getWordsInAlphabeticalOrder(String text) {
        if (checkEmptyString(text)) return "";
        String[] words = text.split("\\s+");

        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word + " ");
        }
        return result.toString().trim();
    }

    /*
    * [30]
    * Подсчитать, сколько слов в заданном тексте начинается с прописной буквы.
    * */
    public static int countWordsStartingWithUppercase(String text) {
        String[] words = text.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                count++;
            }
        }

        return count;
    }

    /*
    * [31]
    * Подсчитать, сколько раз заданное слово входит в текст
    * */
    public static int countWordOccurrencesInTexts(String text, String word) {
        if (checkEmptyString(text) || checkEmptyString(word)) return 0;
        String[] words = text.split("\\s+");
        int count = 0;

        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }

        return count;
    }

}
