package book.chapter14.chapter_examples.socket.email;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MailMain {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("config\\mail.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties);
        String mailTo = "ihar_blinou@epam.com";
        String subject = "Sample Mail";
        String body = "Hello java mail";
        MailSender sender = new MailSender(mailTo, subject, body, properties);
        sender.send();
    }
}