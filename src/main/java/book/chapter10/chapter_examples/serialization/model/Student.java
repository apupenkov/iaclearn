package book.chapter10.chapter_examples.serialization.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Student implements Serializable {
    public static String faculty = "MMF";
    private String name;
    private int id;
    private transient String password;
    private static final long serialVersionUID = 2L;

    public Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'").add("id=" + id)
                .add("password='" + password + "'").toString();
    }
}
