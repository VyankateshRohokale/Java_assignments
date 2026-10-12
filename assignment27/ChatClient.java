import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5002);

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String message;

        while (true) {
            System.out.print("Enter message: ");
            message = keyboard.readLine();
            output.println(message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Server: " + input.readLine());
        }

        socket.close();
    }
}