package book.chapter10.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {
    private long id;
    private static long last_id = 0;
    private String lastname;
    private List<Integer> grades;
    @Serial
    private static final long serialVersionUID = 3L;
    public static final int MAX_GRADE = 10;
    public static final int MIN_GRADE = 1;

    public Student() {}

    public Student(String lastname, List<Integer> grades) {
        this.id = last_id + 1;
        ++ last_id;
        this.lastname = lastname;
        this.grades = grades;
    }

    public Student(long id, String lastname, List<Integer> grades) {
        this.id = id;
        this.lastname = lastname;
        this.grades = grades;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public static boolean checkUniqueId(List<Student> students) {
        Set<Long> ids = new HashSet<>();
        for (Student student : students) {
            if (ids.size() == 0) {
                ids.add(student.getId());
                continue;
            }
            if (ids.size() > 0 || ids.contains(student.getId())) {
                ids.add(student.getId());
            } else return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, grades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && lastname.equals(student.lastname) && grades.equals(student.grades);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", book.chapter10.model.Student.class.getSimpleName() + "[", "]")
                .add("name='" + lastname + "'").add("id=" + id)
                .add("password='" + grades + "'").toString();
    }
}
