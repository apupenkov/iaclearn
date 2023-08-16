package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;
import org.xml.sax.XMLReader;

import java.util.Set;

public class AbstractStudentsSaxBuilder extends AbstractStudentsBuilder {
    private StudentHandler handler;
    private XMLReader reader;

    public AbstractStudentsSaxBuilder() {
    }

    public AbstractStudentsSaxBuilder(Set<Student> students) {
        super(students);
    }

    @Override
    public void buildSetStudents(String fileName) {
    }
}