import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5002);
        System.out.println("Server waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String message;

        while (true) {
            message = input.readLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Client: " + message);
            System.out.print("Server reply: ");
            output.println(keyboard.readLine());
        }

        socket.close();
        server.close();
    }
}