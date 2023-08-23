package book.chapter14.chapter_examples.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UnCheckedHostMain {
    public static void main(String[] args) {
        byte ip[] = {(byte) 217, (byte) 21, (byte) 43, (byte) 3};
        try {
            InetAddress addr = InetAddress.getByAddress("bsu.by", ip);
            System.out.println(addr.getHostName() + "-> connection: " + addr.isReachable(1_000));
        } catch (UnknownHostException e) {
            System.err.println("address unavailable: " + e);
        } catch (IOException e) {
            System.err.println("I/O exception: " + e);
        }
    }
}