import java.io.*;
import java.net.*;

public class NetworkClientForLogging {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server's IP address if needed
        int serverPort = 8080; // Change this to the server's port if needed

        try (Socket socket = new Socket(serverAddress, serverPort)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = reader.readLine();
            System.out.println("Response from server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}