import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message;
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
            System.out.println("Enter your message.(Enter bye to close)");
            while (true) {
                message = sc.nextLine();
                dataOut.writeUTF(message+"\n");
                dataOut.flush();
                if (message.equals("bye")) {
                    System.out.println("Terminating Connection.......");
                    break;
                }
            }
            dataOut.close();
            sc.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception has been occured" + e);
        }
    }
}