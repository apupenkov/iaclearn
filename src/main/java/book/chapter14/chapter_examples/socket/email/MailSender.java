package book.chapter14.chapter_examples.socket.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class MailSender {
    private MimeMessage message;
    private String sendToEmail;
    private String mailSubject;
    private String mailText;
    private Properties properties;

    public MailSender(String sendToEmail, String mailSubject, String mailText, Properties props) {
        this.sendToEmail = sendToEmail;
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.properties = props;
    }

    public void send() {
        try {
            initMessage();
            Transport.send(message); // sending mail
        } catch (AddressException e) {
            System.err.println("Invalid address: " + sendToEmail + " " + e);
        } catch (MessagingException e) {
            System.err.println("Error generating or sending message: " + e);
        }
    }

    private void initMessage() throws MessagingException {
        Session mailSession = SessionFactory.createSession(properties);
        mailSession.setDebug(true);
        message = new MimeMessage(mailSession);
        message.setSubject(mailSubject);
        message.setContent(mailText, "text/html");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendToEmail));
    }
}