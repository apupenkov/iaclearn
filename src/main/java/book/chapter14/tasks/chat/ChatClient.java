package book.chapter14.tasks.chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Welcome to the chat, " + name + "!");
            writer.println(name + " has joined the chat.");

            Thread readerThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readerThread.start();

            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("/quit")) {
                    writer.println(name + " has left the chat.");
                    break;
                }
                writer.println(name + ": " + input);
            }
            readerThread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
