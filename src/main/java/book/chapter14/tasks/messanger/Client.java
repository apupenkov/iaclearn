package book.chapter14.tasks.messanger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Введите ваше имя: ");
            String name = reader.readLine();

            System.out.println("Добро пожаловать, " + name + "!");
            System.out.println("Чтобы отправить сообщение другому клиенту, введите его имя и сообщение через пробел.");

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String message;
            while (true) {
                message = reader.readLine();
                out.println(name + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
