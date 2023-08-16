package book.chapter15.chapter_examples.validation;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
public class ConsoleStudentHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String tagData = qName + " ";
        for (int i = 0; i < attrs.getLength(); i++) {
            tagData += " " + attrs.getQName(i) + "=" + attrs.getValue(i);
        }
        System.out.print(tagData);
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(" " + qName);
    }
    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }
}