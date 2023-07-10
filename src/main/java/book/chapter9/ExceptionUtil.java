package book.chapter9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.OptionalDouble;

public class ExceptionUtil {
    /*
    * Задание к главе.
    * В символьном файле находится информация об N числах с плавающей запятой
    * с указанием локали каждого числа отдельно. Прочитать информацию из файла.
    * Проверить на корректность, то есть являются ли числа числами. Преобразовать
    * к числовым значениями вычислить сумму и среднее значение прочитанных чисел.
    * Создать собственный класс исключения. Предусмотреть обработку исключений,
    * возникающих при нехватке памяти, отсутствии самого файла по заданному адресу,
    * отсутствии или некорректности требуемой записи в файле, недопустимом значении
    * числа (выходящим за пределы максимально допустимых значений) и т.д
    * */

    public static double getNumber(String number, String locale) {
        double result = 0;
        try {
            if (isValidLocale(locale) == false) {
                throw new InvalidLocaleException("Указанная локализация не верна");
            }
            NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag(locale));
            result = format.parse(number).doubleValue();
        } catch (InvalidLocaleException exception) {
            System.out.println(exception);
        } catch (ParseException ex) {
            System.out.println("Введённое число числом не является");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public static boolean isValidLocale(String value) {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            if (value.equals(locale.toString())) {
                return true;
            }
        }
        return false;
    }

    public static List<Double> getListNumbers(String[] strings, String delimiter) {
        List<Double> numbers = new ArrayList<>();
        for (String str : strings) {
            numbers.add(getNumber(str.split(delimiter)[0], str.split(delimiter)[1]));
        }
        return numbers;
    }

    public static double sumNumbers(String[] strings, String delimiter) {
        return getListNumbers(strings, delimiter).stream().mapToDouble(f -> f).sum();
    }

    public static double sumNumbers(List<Double> numbers) {
        return numbers.stream().mapToDouble(f -> f).sum();
    }

    public static double averageNumbers(List<Double> numbers) {
        return numbers
                .stream()
                .mapToDouble(a -> a)
                .average().getAsDouble();
    }

    public static List<Double> readNumbersFromFile(String filename, String delimiter) {
        List<Double> numbers = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                numbers.add(getNumber(line.split(delimiter)[0], line.split(delimiter)[1]));
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OutOfMemoryError e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}
