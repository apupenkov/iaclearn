package book.chapter15.chapter_examples.validation.builders;

import book.chapter15.chapter_examples.validation.entities.Student;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentsDomBuilder {
    private Set<Student> students;
    private DocumentBuilder docBuilder;
    public StudentsDomBuilder() {
        students = new HashSet<Student>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
        }
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void buildSetStudents(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList studentsList = root.getElementsByTagName("student");
            for (int i = 0; i < studentsList.getLength(); i++) {
                Element studentElement = (Element) studentsList.item(i);
                Student student = buildStudent(studentElement);
                students.add(student);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Student buildStudent(Element studentElement) {
        Student student = new Student();
        student.setFaculty(studentElement.getAttribute("faculty"));
        student.setName(getElementTextContent(studentElement, "name"));
        Integer tel = Integer.parseInt(getElementTextContent(studentElement, "telephone"));
        student.setTelephone(tel);
        Student.Address address = student.getAddress();
        Element adressElement =
                (Element) studentElement.getElementsByTagName("address").item(0);
        address.setCountry(getElementTextContent(adressElement, "country"));
        address.setCity(getElementTextContent(adressElement, "city"));
        address.setStreet(getElementTextContent(adressElement, "street"));
        student.setLogin(studentElement.getAttribute("login"));
        return student;
    }
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}