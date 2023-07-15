package book.chapter10.chapter_examples.xml_serialization;

import book.chapter10.chapter_examples.xml_serialization.model.Student;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlSerializeMain {
    public static void main(String[] args) {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("data/serial.xml")
        ))) {
            Student student = new Student("Janka", 555777, "VKL_1410");
            xmlEncoder.writeObject(student);
            xmlEncoder.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream("data/serial.xml")
        ))) {
            Student student = (Student) xmlDecoder.readObject();
            System.out.println(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
