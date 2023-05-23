// import java.io.*;
import java.net.UnknownHostException;
import java.net.InetAddress;

public class Bytee {
    public static void main(String[] args) {
        // byte[] address1 = { 107, 23, (byte) 250, (byte) 196 };
        byte[] address2 = { (byte) 142, (byte) 250, (byte) 207, (byte) 196 };
        byte[] address3 = { (byte) 192, (byte) 168, 1, 1 };

        try {
            InetAddress less = InetAddress.getByAddress(address3);
            InetAddress less2 = InetAddress.getByAddress("pop-os", address3);
            System.out.println(less);
            System.out.println(less2);
            String reply = InetAddress.getByAddress(address2).getCanonicalHostName();
            System.out.println(reply);
            System.out.println(InetAddress.getByAddress(address2).getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not find www.google.com" + e);
        }

    }
}
