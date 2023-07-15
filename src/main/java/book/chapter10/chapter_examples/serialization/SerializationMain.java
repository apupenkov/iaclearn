package book.chapter10.chapter_examples.serialization;

import book.chapter10.chapter_examples.serialization.model.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationMain {
    public static void main(String[] args) {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data/o.dat"))) {
            Student student = new Student("Janka", 555777, "VKL_1410");
            System.out.println(student);
            output.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
