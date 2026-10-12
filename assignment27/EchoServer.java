import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5001);
        System.out.println("Echo server waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String message;

        while ((message = input.readLine()) != null) {
            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Received: " + message);
            output.println(message);
        }

        socket.close();
        server.close();
    }
}