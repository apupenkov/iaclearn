package book.chapter10.chapter_examples.serialization;

import book.chapter10.chapter_examples.serialization.model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationMain {
    public static void main(String[] args) {
        Student.faculty = "GEO";
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("data/o.dat"))) {
            Student student = (Student) input.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
