package book.chapter14.chapter_examples.socket.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSenderMain {
    public static void main(String[] args) {
        String fileName = "data/info.txt";
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            byte[] data = new byte[1024];
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet;
            System.out.println("sending file...");
            while (inputStream.read(data) != -1) {
                packet = new DatagramPacket(data, data.length, address, 8033);
                datagramSocket.send(packet);
            }
            System.out.println("file sent successfully.");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}