package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class StudentBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    private StudentBuilderFactory() {
    }

    public static AbstractStudentsBuilder createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new StudentsDomBuilder();
            }
            case STAX -> {
                return new StudentsStaxBuilder();
            }
            case SAX -> {
                return new StudentsSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    public static void main(String[] args) {
        String type = "stax";
        AbstractStudentsBuilder builder = StudentBuilderFactory.createStudentBuilder(type);
        builder.buildSetStudents("data_xml/students.xml");
        System.out.println(builder.getStudents());
    }
}

class StudentsSaxBuilder extends AbstractStudentsBuilder {
    private StudentHandler handler;
    private XMLReader reader;

    public StudentsSaxBuilder() {
    }

    public StudentsSaxBuilder(Set<Student> students) {
        super(students);
    }

    @Override
    public void buildSetStudents(String fileName) {
    }
}

class StudentsDomBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;
    public StudentsDomBuilder() {
    }
    public StudentsDomBuilder(Set<Student> students) {
        super(students);
    }
    @Override
    public void buildSetStudents(String fileName) {
    }
}
class StudentsStaxBuilder extends AbstractStudentsBuilder {
    private XMLInputFactory inputFactory;
    public StudentsStaxBuilder() {
    }
    public StudentsStaxBuilder(Set<Student> students) {
        super(students);
    }
    @Override
    public void buildSetStudents(String fileName) {
    }
}
