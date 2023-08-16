package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.builders.StudentsSaxBuilder;

public class StartParser {
    public static void main(String[] args) {
        book.chapter15.chapter_examples.validation.builders.StudentsSaxBuilder saxBuilder = new StudentsSaxBuilder();
        saxBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(saxBuilder.getStudents());
    }
}
