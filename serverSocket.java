import java.io.*;
import java.net.*;


public class serverSocket {
    public static void main(String[] args) throws IOException {
        int port=5678;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setReuseAddress(true);
        System.out.println("Server Started and listening to the port 5678");
        while (true){
            Socket cs  = serverSocket.accept();
            cs.setTcpNoDelay(true);
            cs.setSoLinger(true, 1000);
            cs.setSoTimeout(2000);
            cs.setSendBufferSize(2048);
            System.out.println("Client connected" + cs.getInetAddress() + cs.getLocalAddress());
            handleClient(cs);
        }
    }

    public static void handleClient(Socket cs) throws IOException{
        InputStream is = cs.getInputStream();
        OutputStream os = cs.getOutputStream();
        byte[] buf = new byte[2048];
        int readBytes = is.read(buf);
        while (readBytes  !=  -1){ 
            os.write(buf,0,readBytes);
            readBytes = is.read(buf);
        }
        System.out.println("Client has been disconnected" + cs.getInetAddress());
        cs.close();
        
    }
}


// july - 19



