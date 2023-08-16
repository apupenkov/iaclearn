package book.chapter15.chapter_examples.validation;

import book.chapter15.chapter_examples.validation.entities.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class StudentHandler extends DefaultHandler {
    private Set<Student> students;
    private Student current;
    private StudentXmlTag currentXmlTag;
    private EnumSet<StudentXmlTag> withText;
    private static final String ELEMENT_STUDENT = "student";
    public StudentHandler() {
        students = new HashSet<Student>();
        withText = EnumSet.range(StudentXmlTag.NAME, StudentXmlTag.STREET);
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_STUDENT.equals(qName)) {
            current = new Student();
            current.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) { // warning!!!!
                current.setFaculty(attrs.getValue(1));
            }
        } else {
            StudentXmlTag temp = StudentXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_STUDENT.equals(qName)) {
            students.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case TELEPHONE -> current.setTelephone(Integer.parseInt(data));
                case STREET -> current.getAddress().setStreet(data);
                case CITY -> current.getAddress().setCity(data);
                case COUNTRY -> current.getAddress().setCountry(data);
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

}