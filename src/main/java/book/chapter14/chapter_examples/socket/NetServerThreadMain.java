package book.chapter14.chapter_examples.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThreadMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8071);
            System.out.println(serverSocket.getInetAddress() + " server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ServerThread extends Thread {
    private PrintStream printStream;
    private BufferedReader reader;
    private InetAddress address;
    public ServerThread(Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        address = socket.getInetAddress();
    }
    public void run() {
        int counter = 0;
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                if ("PING".equals(message)) {
                    printStream.println("PONG #" + ++counter);
                }
                System.out.println("PING-PONG #" + counter + " from " + address.getHostName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }
    private void disconnect() {
        if (printStream != null) {
            printStream.close();
        }
        try {
            if (reader != null) {
                reader.close();
            }
            System.out.println(address.getHostName() + ": disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}