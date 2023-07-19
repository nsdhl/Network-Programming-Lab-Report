import java.io.*;
import java.net.*;

public class clientSocket {
    public static void main(String[] args) throws IOException {
        int port = 5678;
        Socket client = new Socket("localhost", port);
        client.setReuseAddress(true);
        System.out.println("Client Started and connected to the port 5678");
        handleClient(client);
        client.close();
    }

    public static void handleClient(Socket client) throws IOException {
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();
        byte[] buf = new byte[2048];
        int readBytes = is.read(buf);
        while (readBytes != -1) {
            os.write(buf, 0, readBytes);
            readBytes = is.read(buf);
        }
        System.out.println("Client has been disconnected from the server");
    }
}
