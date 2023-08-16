package book.chapter15.chapter_examples.validation.builders;

import book.chapter15.chapter_examples.validation.StudentXmlTag;
import book.chapter15.chapter_examples.validation.entities.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
public class StudentsStaxBuilder {
    private Set<Student> students;
    private XMLInputFactory inputFactory;
    public StudentsStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        students = new HashSet<Student>();
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void buildSetStudents(String filename) {
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(StudentXmlTag.STUDENT.getValue())) {
                        Student student = buildStudent(reader);
                        students.add(student);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Student buildStudent(XMLStreamReader reader) throws XMLStreamException {
        Student student = new Student();
        student.setLogin(reader.getAttributeValue(null, StudentXmlTag.LOGIN.getValue()));
        student.setFaculty(reader.getAttributeValue(null, StudentXmlTag.FACULTY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentXmlTag.valueOf(name.toUpperCase())) {
                        case NAME -> student.setName(getXMLText(reader));
                        case TELEPHONE ->student.setTelephone(Integer.parseInt(getXMLText(reader)));
                        case ADDRESS -> student.setAddress(getXMLAddress(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentXmlTag.valueOf(name.toUpperCase()) == StudentXmlTag.STUDENT) {
                        return student;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <student>");
    }
    private Student.Address getXMLAddress(XMLStreamReader reader)
            throws XMLStreamException {
        Student.Address address = new Student().new Address();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StudentXmlTag.valueOf(name.toUpperCase())) {
                        case COUNTRY -> address.setCountry(getXMLText(reader));
                        case CITY -> address.setCity(getXMLText(reader));
                        case STREET -> address.setStreet(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (StudentXmlTag.valueOf(name.toUpperCase()) == StudentXmlTag.ADDRESS) {
                        return address;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}