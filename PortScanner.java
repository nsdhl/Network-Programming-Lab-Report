import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class PortScanner {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int startPort = 1;
        int endPort = 65535;

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket(host, port);
                System.out.println("Port " + port + " is open");
                socket.close();
            } catch (IOException e) {
                // Port is closed
            }
        }
    }
}