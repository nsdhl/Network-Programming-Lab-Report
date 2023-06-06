import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Connection has been established at: " + s.getInetAddress().getHostAddress());
            handleClient(s);
            s.close();
            System.out.println("Connection has been terminated");
        }
    }

    public static void handleClient(Socket s) throws IOException {
        // DataInputStream dis = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String message;
        int i=1;
        while ((message=br.readLine())!= null) {
            System.out.println("Mesaage received: "+ message);
            System.out.printf("Received Message %d: %s\n",i, message);
            i++;
            if (message.equals("bye")) {
                break;
            }
            // while (true) {
            // message = (String)br.readLine();
            // System.out.println(message);
            // if (message.equals("bye")) {
            // break;

            // }
            // }
            br.close();
        }
    }
}

//9 May