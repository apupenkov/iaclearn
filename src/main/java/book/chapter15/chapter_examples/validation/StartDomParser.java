package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.builders.StudentsDomBuilder;

public class StartDomParser {
    public static void main(String[] args) {
        book.chapter15.chapter_examples.validation.builders.StudentsDomBuilder domBuilder = new StudentsDomBuilder();
        domBuilder.buildSetStudents("data_xml/students.xml");
        System.out.println(domBuilder.getStudents());
    }
}
