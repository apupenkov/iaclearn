package book.chapter14.tasks.messanger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 12345;
    private List<ClientHandler> clients;

    public Server() {
        clients = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен и ожидает подключения клиентов...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключен клиент: " + clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void broadcastMessage(String clientMessage, book.chapter14.tasks.messanger.server.ClientHandler clientHandler) {

    }
}
