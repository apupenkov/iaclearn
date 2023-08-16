package book.chapter15.chapter_examples.validation;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.logging.Logger;

public class StudentErrorHandler implements ErrorHandler {
//    private static Logger logger = LogManager.getLogger();
//    public void warning(SAXParseException e) {
//        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
//    }
//
//    public void error(SAXParseException e) {
//        logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
//    }
//    public void fatalError(SAXParseException e) {
//        logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
//    }
    private String getLineColumnNumber(SAXParseException e) {
// determine line and position of error
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}
