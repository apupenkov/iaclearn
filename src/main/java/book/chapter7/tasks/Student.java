package book.chapter7.tasks;

import java.sql.SQLOutput;
import java.util.*;

public class Student {
    private String name;
    private int age;
    private Double mark;

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " - " + age + " - " + mark;
    }



    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John", 18, 8.2),
                new Student("Jane", 22, 3.5),
                new Student("Mark", 19, 10.0),
                new Student("Qwerty", 16, 9.9),
                new Student("Islam", 21, 10.0),
                new Student("Tony", 15, 5.7)
        );

        int minMark = 8;

        Collections.sort(students, Comparator.comparing(Student::getName));

        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getMark() > minMark) {
                filteredStudents.add(student);
            }
        }
        System.out.println("Filtered students:");
        filteredStudents.stream().map(s -> s.toString()).forEach(System.out::println);
    }
}
