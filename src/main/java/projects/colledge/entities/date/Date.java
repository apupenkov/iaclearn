package projects.colledge.entities.date;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 1990;
    }

    public Date(int day, int month, int year) {
        List<Integer> month31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> month30 = Arrays.asList(4, 6, 9, 11);
        int ynow = LocalDate.now().getYear();
        if (!(year > ynow || year < ynow - 100)) {
            if (month > 12 || month < 1) throw new IllegalArgumentException("Введите корректное значение месяца.");
            if ((month31.contains(month) && (day > 0 && day <= 31)) ||
                    (month30.contains(month) && (day > 0 && day <= 30)) ||
                    (ynow % 4 == 0 && month == 2 && (day > 0 && day <= 29)) ||
                    (month == 2 && (day > 0 && day <= 28))) {
                this.day = day;
                this.month = month;
                this.year = year;
            } else {
                throw new IllegalArgumentException("Введите корректное значение дня в указанном месяце");
            }
        } else {
            throw new IllegalArgumentException("Год не может быть больше чем " + ynow +
                    "и меньше чем " + (ynow - 100));
        }
    }

    @Override
    public String toString() {
        return "date{day=" + day + ",month=" + month + ",year=" + year+"}";
    }
}
