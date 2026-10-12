import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5001);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in)
        );

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String message;

        while (true) {
            System.out.print("Enter message: ");
            message = keyboard.readLine();
            output.println(message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Echo from server: " + input.readLine());
        }

        socket.close();
    }
}