
import java.io.*;
import java.net.*;

public class EchoServerClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change to the server's IP if needed
        int serverPort = 3337;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server at " + serverAddress + ":" + serverPort);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                System.out.print("Enter a message to send to the server (or 'exit' to quit): ");
                message = reader.readLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(message);

                BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String response = serverReader.readLine();
                System.out.println("Server response: " + response);
            }

            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}