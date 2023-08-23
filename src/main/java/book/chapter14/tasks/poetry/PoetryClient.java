package book.chapter14.tasks.poetry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PoetryClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String poem;
            while ((poem = in.readLine()) != null) {
                System.out.println("Received poem:\n" + poem);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
