package book.chapter14.tasks.poetry;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class PoetryServer {
    private static final int PORT = 12345;
    private static final String POETRY_FILE_PATH = "src/main/resources/poetry/poetry.txt";
    private static String[] poems;

    public static void main(String[] args) {
        loadPoemsFromFile();
        startServer();
    }

    private static void loadPoemsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(POETRY_FILE_PATH));
            String line;
            StringBuilder poemBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    poems = addPoem(poems, poemBuilder.toString());
                    poemBuilder = new StringBuilder();
                } else {
                    poemBuilder.append(line).append("\n");
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] addPoem(String[] poems, String poem) {
        if (poems == null) {
            return new String[]{poem};
        } else {
            String[] newPoems = new String[poems.length + 1];
            System.arraycopy(poems, 0, newPoems, 0, poems.length);
            newPoems[poems.length] = poem;
            return newPoems;
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for connections...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                int randomIndex = new Random().nextInt(poems.length);
                String randomPoem = poems[randomIndex];
                out.println(randomPoem);
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
