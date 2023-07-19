package book.chapter10;

import book.chapter10.exceptions.StudentException;
import book.chapter10.model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class StreamInputOutputUtil {

    /*
    * Вариант A
    * */

    /*
    * [1]
    * В каждой строке найти и удалить заданную подстроку
    * */

    /*
    * [2]
    * В каждой строке стихотворения найти и заменить заданную подстроку на подстроку иной длины.
    * */

    /*
    * [3]
    * В каждой строке найти слова, начинающиеся с гласной буквы.
    * */

    /*
    * [4]
    * Найти и вывести слова текста, для которых последняя буква одного слова совпадает с первой буквой следующего слова.
    * */

    /*
    * [5]
    * Найти в строке наибольшее число цифр, следующих подряд.
    * */

    /*
    * [6]
    * В каждой строке стихотворения Максима Богдановича подсчитать частоту повторяемости каждого слова из заданного
    * списка и вывести эти слова в порядке возрастания частоты повторяемости.
    * */

    /*
    * [7]
    * В каждом слове повести Владимира Короткевича «Дикая охота короля Стаха» заменить первую букву слова на прописную.
    * */

    /*
    * [8]
    * Определить частоту повторяемости букв и слов в стихотворении Адама Мицкевича.
    * */



    /*
    * Вариант B
    * */



    /*
    * Вариант C
    * */

    /*
    * [1]
    * Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.
    * */

    public static int getRandom() {
        return new Random().nextInt();
    }

    public static void writeRandomNumberInFile(String path, String file, int countNumbers) throws FileNotFoundException {
        if (!Files.exists(Path.of(path))) throw new FileNotFoundException("Path " + path + " does not exist");
        if (countNumbers < 1) throw new IllegalArgumentException("Number of numbers must be 1 or more");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + file))) {
            for (int i = 0; i < countNumbers; i++) {
                writer.write(String.valueOf(getRandom()));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> readRandomNumbersFromFile(String path, String file) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (Scanner scan = new Scanner(new FileReader(path + "/" + file))) {
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    list.add(scan.nextInt());
                } else throw new IOException("File contains more than just numbers.");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Path " + path + " does not exist");
        }
        Collections.sort(list);
        return list;
    }

    /*
    * [2]
    * Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.
    * */

    /*
    * [3]
    * Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.
    * */

    /*
    * [4]
    * Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными
    * */

    /*
    * [5]
    * В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые
    * имеют средний балл более 7.
    * */

    public static void writeSerializedStudent(String path, List<Student> students) throws StudentException {
        for (Student student :
                students) {
            if (student == null) {
                throw new StudentException("Данные о студенте не могут быть пустыми.");
            } else if (student.getLastname() == null || Objects.equals(student.getLastname(), "")) {
                throw new StudentException("Имя студента не может быть пустым.");
            } else if (student.getId() < 1) {
                throw new StudentException("Идентификатор пользователя не может быть отрицательным или быть нулевым");
            } else if (!Student.checkUniqueId(students)) {
                throw new StudentException("Все пользователи должны быть с уникальными идентификаторами (id)");
            }
        }
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void addLastnameSuccessfulStudents(String path, List<String> lastNames) {
//        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path, false))) {
//            output.writeObject(lastNames);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public static List<String> checkCorrectData(String path) {
//        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
//            input.readObject();
//            return (List<String>) input.readObject();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static List<Student> readSerializedStudent(String pathfile) throws StudentException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(pathfile))) {
            List<Student> students = (List<Student>) input.readObject();
            return students;
        } catch (InvalidClassException e) {
            throw new StudentException("Версия читаемого и существующего класса разные.");
        } catch (NotSerializableException e) {
            throw new StudentException("Не удалось десериализовать объект");
        } catch (ClassNotFoundException | IOException e) {
            throw new StudentException("Класс объекта не найден или произошла ошибка чтения из файла.");
        }
    }

    public static int average(List<Integer> nums) {
        int average = 0;
        for (int num : nums) {
            average += num;
        }
        return average / nums.size();
    }

    public static List<String> getStudentsByGrade(List<Student> students, int grade) {
        if (grade > Student.MAX_GRADE || grade < Student.MIN_GRADE)
            throw new IllegalArgumentException("The number is greater or less than allowed");

        List<String> lastnameStudents = new ArrayList<>();
        try {
            for (Student student : students) {
                int average = average(student.getGrades());
                if (average > grade) {
                    lastnameStudents.add(student.getLastname().toLowerCase());
                }
            }
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }

        return lastnameStudents;
    }

    /*
    * [6]
    * Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные, тип которых
    * вводится из командной строки.
    * */

    /*
    * [7]
    * Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки должно быть удалено
    * только максимальное четное количество таких слов.
    * */

    public static void removeWordsOfSpecificLength(String path, int startLength, int endLength) throws FileNotFoundException {
        if (startLength > endLength || startLength < 0)
            throw new IllegalArgumentException("Неправильно указанная длина");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + ".tmp", false)))) {
            String words = "";
            while ((words = reader.readLine()) != null) {
                int evenCount = 0;
                for (String word : words.split("\\W+")) {
                    if (word.length() >= 3 && word.length() <= 5) {
                        evenCount++;
                    }
                }

                int wordsToRemove = evenCount % 2 == 0 ? evenCount : evenCount - 1;
                int removedCount = 0;
                StringBuilder sb = new StringBuilder();

                for (String word : words.split("\\W+")) {
                    if (word.length() >= 3 && word.length() <= 5) {
                        if (removedCount < wordsToRemove) {
                            removedCount++;
                            continue;
                        }
                    }
                    sb.append(word).append(" ");
                }
                writer.write(sb.toString().trim());
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * [8]
    * Прочитать текст Java-программы и удалить из него все лишние пробелы и табуляции, оставив только необходимые
    * для разделения операторов.
    * */

    /*
    * [9]
    * Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
    * */

    /*
    * [10]
    * Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m
    * последних слов в каждой из последних n строк.
    * */

    /*
    * [11]
    * Ввести из текстового файла, связанного с входным потоком, последовательность строк. Выбрать и сохранить m
    * последних слов в каждой из последних n строк.
    * */

    /*
    * [12]
    * Из текстового файла ввести последовательность строк. Выделить отдельные слова, разделяемые пробелами. Написать
    * метод поиска слова по образцу-шаблону. Вывести найденное слово в другой файл.
    * */

    /*
    * [13]
    * Входной файл содержит совокупность строк. Строка файла содержит строку квадратной матрицы. Ввести матрицу в
    * двумерный массив (размер матрицы найти). Вывести исходную матрицу и результат ее транспонирования
    * */

    /*
    * [14]
    * Входной файл хранит квадратную матрицу по принципу: строка представляет собой число. Определить размерность.
    * Построить двумерный массив, содержащий матрицу. Вывести исходную матрицу и результат ее поворота на 90˚
    * по часовой стрелке.
    * */

    /*
    * [15]
    * В файле содержится совокупность строк. Найти номера строк, совпадающих с заданной строкой. Имя файла и строка
    * для поиска — аргументы командной строки. Вывести строки файла и номера строк, совпадающих с заданной.
    * */
}
