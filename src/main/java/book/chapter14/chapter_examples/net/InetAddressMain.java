package book.chapter14.chapter_examples.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
    public static void main(String[] args) {
        InetAddress currentIp;
        InetAddress epamIp;
        try {
            currentIp = InetAddress.getLocalHost();
            System.out.println("current IP -> " + currentIp.getHostAddress());
            epamIp = InetAddress.getByName("epam.com");
            System.out.println("EMAP IP address -> " + epamIp.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
