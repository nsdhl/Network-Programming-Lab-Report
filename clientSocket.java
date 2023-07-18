import java.io.*;
import java.net.UnknownHostException;
import java.net.*;

public class clientSocket {
    public static void main(String[] args) throws UnknownHostException , IOException, ClassNotFoundException, InterruptedException {
        Socket socket = new Socket("localhost", 3000);
        System.out.println("Connected to server");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        oos.writeObject("Hello from client");
        System.out.println("Server says: " + (String) ois.readObject());
        oos.close();
        ois.close();
        socket.close();
    }
}