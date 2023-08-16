package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.builders.StudentsStaxBuilder;

public class StartStaxParser {
    public static void main(String[] args) {
        book.chapter15.chapter_examples.validation.builders.StudentsStaxBuilder staxBuilder = new StudentsStaxBuilder();
        staxBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(staxBuilder.getStudents());
    }
}
