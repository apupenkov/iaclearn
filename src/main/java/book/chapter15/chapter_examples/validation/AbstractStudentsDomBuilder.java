package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class AbstractStudentsDomBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;
    public AbstractStudentsDomBuilder() {
    }
    public AbstractStudentsDomBuilder(Set<Student> students) {
        super(students);
    }
    @Override
    public void buildSetStudents(String fileName) {
    }
}