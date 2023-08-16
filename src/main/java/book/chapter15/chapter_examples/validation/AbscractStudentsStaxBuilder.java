package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class AbscractStudentsStaxBuilder extends AbstractStudentsBuilder {
    private XMLInputFactory inputFactory;
    public AbscractStudentsStaxBuilder() {
    }
    public AbscractStudentsStaxBuilder(Set<Student> students) {
        super(students);
    }
    @Override
    public void buildSetStudents(String fileName) {
    }
}